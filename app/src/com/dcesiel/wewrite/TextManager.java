package com.dcesiel.wewrite;

import java.util.Stack;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

//Some code based on UndoableTextEditor by jgracik and marwel 

public class TextManager
{
  String TAG = "TextManager";
  EditText editor;
  private Stack<EditHistory> undoStack;
  private Stack<EditHistory> redoStack;
  
  private static final int UNDO = 1;
  private static final int REDO = 2;
  private static final int HISTORY_SIZE = 20;
  
  private boolean undoRedoPressed;
  
  TextManager(EditText ref){
    undoStack = new Stack<EditHistory>();
    redoStack = new Stack<EditHistory>();
    undoRedoPressed = false;
    editor = ref;
    
    editor.addTextChangedListener(new TextWatcher(){
      private CharSequence original, change;
      
      @Override
      public void afterTextChanged(Editable s) {}
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //Don't change stack info if undoing or redoing
        if(undoRedoPressed) return;
        
        original = s.subSequence(start, start + count);
        Log.d("TextListener", "beforeTextChanged:  Start: " + start + " Count: " + count + " Original Text: [" + original + "]");
      }
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        //Don't change stack info if undoing or redoing
        if (undoRedoPressed) return;
        
        change = s.subSequence(start, start + count);
        Log.d("TextListener", "onTextChanged:  Start: " + start + " Count: " + count + " Original Text: [" + change + "]");
        
        undoStack.push(new EditHistory(start, original, change));
        
        // Listener sometimes creates random duplicate events with some keyboards 
        if(change.toString().equals(original.toString())) {
          Log.d("Duplicate removal", "Removed duplicate");
          undoStack.pop();
        }
        
        if(undoStack.size() > HISTORY_SIZE) {
          undoStack.remove(0);  // remove from bottom of stack
        }
        //Wipe redo stack if on a new edit
        redoStack.clear();
      } 
    });
  }
  
  public EditHistory edit(EditHistory edit, int type)
  {
    Editable editor_text = editor.getText();
    int endIdx = edit.begin;
    CharSequence csReplacedText;
    CharSequence csInsertedText;
    
    if(type == UNDO) {
      csReplacedText = edit.originalText;
      csInsertedText = edit.newText;
    } else {  //Redo
      csReplacedText = edit.newText;
      csInsertedText = edit.originalText;
    }
    
    try {
      if(edit.newText != null) {
        endIdx += csInsertedText.length();
      }
      
      editor_text.replace(edit.begin, endIdx, csReplacedText);
      Log.d(TAG, "replace okay");
    } catch(IndexOutOfBoundsException ex) {
      Log.d(TAG, "performEdit exeption: " + ex.toString());
    }
    
    return edit;
  }
  
  public void undo()
  {
    if(undoStack.empty()) {
      Log.d(TAG, "nothing to undo");
      return;
    }
    
    //Lock that prevents listener from adding undo to stack
    undoRedoPressed = true;
    EditHistory undoEvent = undoStack.pop();
    EditHistory edit = edit(undoEvent, UNDO);
    redoStack.push(edit);
    undoRedoPressed = false;
  }
  
  public void redo()
  {
    if(redoStack.empty()){
      Log.d(TAG, "nothing to redo");
      return;
    }
    
    //Lock that prevents listener from adding undo to stack
    undoRedoPressed = true;
    EditHistory redoEvent = redoStack.pop();
    EditHistory edit = edit(redoEvent, REDO);
    undoStack.push(edit);
    undoRedoPressed = false;
  }
  
  
  private class EditHistory
  {
    int begin;
    CharSequence originalText;
    CharSequence newText;
    
    public EditHistory(int start, CharSequence originalText, CharSequence newText){
      this.begin = start;
      this.originalText = originalText;
      this.newText = newText;
    }
  }
  
}
