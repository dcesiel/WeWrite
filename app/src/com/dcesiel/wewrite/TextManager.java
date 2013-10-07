package com.dcesiel.wewrite;

import java.util.Stack;
import java.util.TreeSet;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.dcesiel.wewrite.ExtendedEditText.onSelectionChangedListener;
import com.dcesiel.wewrite.EditorEventProto.EditorEvent;

public class TextManager
{
  private static final int HISTORY_SIZE = 20;  
  private Stack<EditorEvent> undoStack;
  private Stack<EditorEvent> redoStack;
  private TreeSet<Integer> undosToSend;
  private TreeSet<Integer> redosToSend;
  private TreeSet<Integer> pendingEvent;
  
  private static final int UNDO = 1;
  private static final int REDO = 2;

  private EditorListener editorListener; 
  private long userId;
  private boolean connected;
  private boolean needToSync;
  private boolean syncing;
  private int cursorOffset;
  private int lastCursorIndex;
  
  private ExtendedEditText extendedEditText;
  
  //Locks to prevent events and undos/redos from happening improperly
  private boolean undoingOrRedoing; 
  private boolean generatingEvent;  
  
  private static final String TAG = "TextManager";
  
  private TextManagerEvent textManagerEvent;
  
  public TextManager(ExtendedEditText edittext)
  {
    extendedEditText = edittext;
    connected = false;
    needToSync = false;
    syncing = false;
    cursorOffset = 0;
    lastCursorIndex = 0;
    userId = 0L;
    
    undoStack = new Stack<EditorEvent>();
    redoStack = new Stack<EditorEvent>();
    undosToSend = new TreeSet<Integer>();
    redosToSend = new TreeSet<Integer>();
    pendingEvent = new TreeSet<Integer>();

    undoingOrRedoing = false;
    generatingEvent = false;
    
    editorListener = new EditorListener();
    extendedEditText.addTextChangedListener(editorListener);
    extendedEditText.addOnSelectionChangedListener(editorListener);
  }

  
  public void setTextManagerEventListener(TextManagerEvent e) 
  {
    textManagerEvent = e;
  }
  
  public EditorEvent createCursorEvent(int cursorIndex)
  {
    EditorEvent editorEvent = EditorEvent.newBuilder().setNewCursorIdx(cursorIndex).setUserid(userId).build();   
    return editorEvent;
  }
  
  public EditorEvent createUndoRedoEvent(EditorEvent e, int type)
  {
    // swap text ordering
    CharSequence csReplace = e.getOldText();
    CharSequence csOther = e.getNewText();
    
    EditorEvent ee = EditorEvent.newBuilder()
        .setBeginIndex(e.getBeginIndex())
        .setNewText(csReplace.toString())
        .setOldText(csOther.toString())
        .setNewCursorIdx(extendedEditText.getSelectionStart())
        .setUserid(userId)
    .build();
    
    lastCursorIndex = extendedEditText.getSelectionStart();
    int eventId = textManagerEvent.sendEvent(ee, "TEXT_CHANGE");
    textManagerEvent.setChangeId(eventId);
    if(type == UNDO) {
      undosToSend.add(eventId);
    } else {
      redosToSend.add(eventId);
    }
    
    return ee;
  }
    
  public void setUserID(long id) 
  {
    userId = id;
    connected = true;
  }
  
  public void setNeedToSync(boolean b) 
  {
    needToSync = b;
  }
  
  public boolean needsToSync()
  {
    Log.d("SYNC", "needToSync: " + needToSync);
    return needToSync;
  }
  
  public boolean checkNotBusy()
  {
    return !syncing && !undoingOrRedoing && !generatingEvent;
  }
  
  public void sync(String s)
  {
    Log.d("Sync", "Syncing");
    syncing = true;
    extendedEditText.removeTextChangedListener(editorListener);
    extendedEditText.removeOnSelectionChangedListener();
    
    int origIdx = extendedEditText.getSelectionStart() + cursorOffset;
    extendedEditText.setText(s);
    
    if(origIdx <= extendedEditText.length()) {
      extendedEditText.setSelection(origIdx);
    } else {
      extendedEditText.setSelection(extendedEditText.length());
    }
    needToSync = false;
    cursorOffset = 0;
    
    extendedEditText.addOnSelectionChangedListener(editorListener);
    extendedEditText.addTextChangedListener(editorListener);
    syncing = false;
  }
  
  public void updateCursorOffset(EditorEvent editorEvent)
  {
    if(editorEvent.getBeginIndex() > (extendedEditText.getSelectionStart() + cursorOffset)) {
      return;
    }

    int endIndex = editorEvent.getBeginIndex();
    CharSequence csNew = editorEvent.getNewText();
    CharSequence csOld = editorEvent.getOldText();
    
    if(csNew.length() == 0) {
      endIndex += csOld.length();
    } else if(csOld.length() == 0) {
      endIndex += csNew.length();
    }
    
    cursorOffset += (endIndex - editorEvent.getBeginIndex());
  }
  
  public void redo()
  {
    if(redoStack.empty()){
      Log.d(TAG, "nothing to redo");
      return;
    }
    
    undoingOrRedoing = true;
    EditorEvent redoEvent = redoStack.pop();
    createUndoRedoEvent(redoEvent, REDO);
    undoingOrRedoing = false; 
    Log.d(TAG, "redo()");
  }
  
  public void undo()
  {
    if(undoStack.empty()) {
      Log.d(TAG, "nothing to undo");
      return;
    }
    Log.d(TAG, "undo()");
    
    //Set lock
    undoingOrRedoing = true;
    EditorEvent undoEvent = undoStack.pop();
    createUndoRedoEvent(undoEvent, UNDO);
    undoingOrRedoing = false;
  }
  
  public void updateUndoRedoStacks(EditorEvent ee)
  {
    updateStack(undoStack, ee);
    updateStack(redoStack, ee);
  }
  
  public void updateStack(Stack<EditorEvent> history, EditorEvent ee)
  {
    int newIdx = ee.getBeginIndex();
    for(int i = 0; i < history.size(); i++)
    {
      EditorEvent inStack = history.get(i);
      if(newIdx <= inStack.getBeginIndex()) {
        int replaceIdx = inStack.getBeginIndex() + (ee.getNewText().length() - ee.getOldText().length());
        EditorEvent replacement = EditorEvent.newBuilder()
            .setBeginIndex(replaceIdx)
            .setNewText(inStack.getNewText())
            .setOldText(inStack.getOldText())
            .setNewCursorIdx(replaceIdx + inStack.getNewText().length())
            .setUserid(userId)
        .build();
        history.set(i, replacement);
      }
      else if(ee.getUserid() != inStack.getUserid() &&
              newIdx > inStack.getBeginIndex() && 
              newIdx < (inStack.getBeginIndex() + inStack.getNewText().length())) {
        history.remove(i);
      }
    }
  } 
  
  public void confirmEvent(final int id, final EditorEvent editorEvent)
  {
    if(pendingEvent.contains(id)) {
      undoStack.push(editorEvent);
      if(undoStack.size() > HISTORY_SIZE) {
        undoStack.remove(0);
      }
      pendingEvent.remove(id);
    } else if(undosToSend.contains(id)) {
      textManagerEvent.forceNextSync();
      redoStack.push(editorEvent);
      if(redoStack.size() > HISTORY_SIZE) {
        redoStack.remove(0);
      }
      extendedEditText.setSelection(editorEvent.getBeginIndex());
      undosToSend.remove(id);
    } else if(redosToSend.contains(id)) {
      textManagerEvent.forceNextSync();
      undoStack.push(editorEvent);
      if(undoStack.size() > HISTORY_SIZE) {
        undoStack.remove(0);
      }
      try {
        extendedEditText.setSelection(editorEvent.getBeginIndex() + editorEvent.getNewText().length());
      } catch(IndexOutOfBoundsException e) {
        Log.e(TAG, "set cursor index out of bounds");
      }
      redosToSend.remove(id);
    }
  }
  
  private class EditorListener implements TextWatcher, onSelectionChangedListener
  {
    private CharSequence orig, change;
    private int beginIndex, cursorIndex;
    private boolean duplicate = false;
    
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {
      if(undoingOrRedoing || syncing) return;
      generatingEvent = true;
      beginIndex = start;
      orig = s.subSequence(start, start + count);
    }
    
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
      if(undoingOrRedoing || syncing) return;
      change = s.subSequence(start, start + count);
    }

    public void afterTextChanged(Editable s)
    {
      //Check lock before registering change.  Could be undo/redo
      if(undoingOrRedoing || syncing) return;
      
      // create EditorEvent object
      EditorEvent textChange = EditorEvent.newBuilder()
          .setBeginIndex(beginIndex + cursorOffset)
          .setNewText(change.toString())
          .setOldText(orig.toString())
          .setNewCursorIdx(extendedEditText.getSelectionStart())
          .setUserid(userId)
      .build();
      
      if(connected && !duplicate) {
        int eventId = textManagerEvent.sendEvent(textChange, "TEXT_CHANGE");
        textManagerEvent.setChangeId(eventId);
        pendingEvent.add(eventId);
      }
      
      duplicate = false;
      generatingEvent = false;
    }

    @Override
    public void onSelectionChanged(int selStart, int selEnd)
    {
      //Send to server
      if(!generatingEvent) {
        cursorIndex = selStart;
        if(cursorIndex == lastCursorIndex) return;
        
        EditorEvent ee = createCursorEvent(cursorIndex);
        textManagerEvent.setChangeId(textManagerEvent.sendEvent(ee, "CURSOR_CHANGE"));
      } else {
        generatingEvent = true;
      }
    }
    
  } 

  //Interface to notify other classes of editor changes
  public interface TextManagerEvent {
    public int sendEvent(EditorEvent ee, String type);
    public void triggerSync();
    public void forceNextSync();
    public void setChangeId(int id);
  }
  
}