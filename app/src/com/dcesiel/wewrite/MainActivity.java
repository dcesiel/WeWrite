package com.dcesiel.wewrite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.dcesiel.wewrite.EditorEventProto.EditorEvent;
import com.dcesiel.wewrite.TextManager.TextManagerEvent;
import com.google.protobuf.InvalidProtocolBufferException;

import edu.umich.imlc.collabrify.client.CollabrifyAdapter;
import edu.umich.imlc.collabrify.client.CollabrifyClient;
import edu.umich.imlc.collabrify.client.CollabrifyListener;
import edu.umich.imlc.collabrify.client.CollabrifySession;
import edu.umich.imlc.collabrify.client.exceptions.CollabrifyException;

public class MainActivity extends Activity implements TextManagerEvent
{
  //Random hard coded session name
  private static final String SESSION_NAME = "asdfsdfg1234";
  private static final String TAG = "Main";
  
  //Phone editor vars
  private TextManager textManager;
  private ExtendedEditText editTextCursor;
  private int latestChangeSent;
  private int latestChangeApplied;  
  
  //Collab and event stuff
  private long sessionId;
  private String sessionName;  
  private CollabrifyListener collabrifyListener;
  private CollabrifyClient client;
  private EditText serverText;
  private LinkedList<Integer> eventIds;
  private long orderIdCount;  
  private LinkedList<EditorEvent> eventQueue;
  private int forceNext;
  ArrayList<String> tags = new ArrayList<String>();
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    
    //Remote setup
    serverText = new EditText(this);
    eventQueue = new LinkedList<EditorEvent>();
    eventIds = new LinkedList<Integer>();
    orderIdCount = 0L; 
    forceNext = 0;
    latestChangeApplied = -1;
    
    //Setup local text editor
    editTextCursor = (ExtendedEditText) findViewById(R.id.editorBox);
    editTextCursor.setLongClickable(false);
    editTextCursor.setEnabled(false);
    editTextCursor.setFocusable(false);
    editTextCursor.setHint("Connecting");
    textManager = new TextManager(editTextCursor);
    textManager.setTextManagerEventListener(this);
    latestChangeSent = -1;
    
    sync = new Handler();
    sync.removeCallbacks(timeKeep);
    lastSyncedChange = 0;

    //Don't remember what this is but it's needed
    tags.add("asdf");

    collabrifyListener = new CollabrifyAdapter() 
    {
      @Override
      public void onReceiveSessionList(final List<CollabrifySession> sessionList)
      {
        int sessionIndex = 0;
        boolean sessionExists = false;
        for( CollabrifySession s : sessionList )
        {
          if( s.name().equals(SESSION_NAME) )
          {
            sessionExists = true;
            break;
          }
          sessionIndex++;
        }
        try
        {
          if(!sessionExists)
          {
            sessionName = SESSION_NAME; // name hardcoded
            client.createSession(sessionName, tags, null, 0);
          }
          else
          {
            sessionId = sessionList.get(sessionIndex).id();
            sessionName = sessionList.get(sessionIndex).name();
            client.joinSession(sessionId, null);
          }
        }
        catch(CollabrifyException e)
        {
          Log.e("onReceiveSessionList", "error", e);
        }
      }
      
      @Override
      public void onReceiveEvent(final long orderId, final int subId, String eventType, final byte[] data) 
      {
        //For out of order ids
        if(orderIdCount != orderId) {
          return;
        } else {
          orderIdCount++;
        }
        final EditorEvent fromServer;
        boolean isLocalChange = false; 
        if(eventType.equals("TEXT_CHANGE")) 
        {
          try
          {
            fromServer = EditorEvent.parseFrom(data);
            eventQueue.add(fromServer);
            eventIds.add(subId);
            isLocalChange = (fromServer.getUserid() == client.currentSessionParticipantId());
            textManager.updateUndoRedoStacks(fromServer);
            if(!isLocalChange) {
              textManager.updateCursorOffset(fromServer);
            } else {
              runOnUiThread(new Runnable() {
                @Override
                public void run()
                {
                  textManager.confirmEvent(subId, fromServer);
                }           
              }); 
            }
          }
          catch( InvalidProtocolBufferException e )
          {
            e.printStackTrace();
          }
        } else if(eventType.equals("CURSOR_CHANGE")) {
          try
          {
            fromServer = EditorEvent.parseFrom(data);
            eventQueue.add(fromServer);
            eventIds.add(subId);
            isLocalChange = (fromServer.getUserid() == client.currentSessionParticipantId());
          }
          catch( InvalidProtocolBufferException e )
          {
            e.printStackTrace();
          }
        }
      }
      
      @Override
      public void onSessionCreated(long id)
      {
        sessionId = id;
        runOnUiThread(new Runnable()
        {
          @Override
          public void run() {
            enableTextEditor();
          }
        });
        Log.i(TAG, "SessionId: " + id);
      }
      
      @Override
      public void onError(CollabrifyException e)
      {
        Log.e(TAG, "error", e);
      }
      
      @Override
      public void onSessionJoined(long maxOrderId, long baseFileSize)
      {
        runOnUiThread(new Runnable()
        {
          @Override
          public void run() {
            enableTextEditor();
          }
        });
      }
      
      @Override
      public void onSessionEnd(long id)
      {
        Log.i(TAG, "session ended");
      }
      
    };  
    
    try
    {
      client = new CollabrifyClient(this, "user email", "user display name", "441fall2013@umich.edu", "XY3721425NoScOpE", false, collabrifyListener);
      Log.i(TAG, "Client Created");
      client.requestSessionList(tags);
    }
    catch(CollabrifyException e) {e.printStackTrace();}
  }
  
  protected void enableTextEditor()
  {
    try {
      textManager.setUserID(client.currentSessionParticipantId());
      editTextCursor.setEnabled(true);
      editTextCursor.setFocusableInTouchMode(true);
      editTextCursor.setFocusable(true);
      editTextCursor.setHint("");
      editTextCursor.requestFocus();
      sync.postDelayed(timeKeep, 2000);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  public void undo(MenuItem menu)
  {
    textManager.undo();
  }

  public void redo(MenuItem menu)
  {
    textManager.redo();
  }
  
 //Event polling and timer based on events from jgracik
  
 public boolean applyTextEvent(int iter, boolean setNeedToSync)
 {
   if(eventQueue.isEmpty()) {
     return setNeedToSync;
   }
   
   EditorEvent ev = eventQueue.poll();
   Integer sub = eventIds.poll();
   
   if(!ev.hasBeginIndex()) {
     // is cursor event, ignore
     if(client.currentSessionParticipantId() == ev.getUserid()) {
       latestChangeApplied = sub.intValue();
     }
     return applyTextEvent(iter, setNeedToSync);
   }
   
   Editable e_text = Editable.Factory.getInstance().newEditable(serverText.getText());
   int endIdx = ev.getBeginIndex();
   CharSequence csReplace = ev.getNewText();
   CharSequence csOther = ev.getOldText();
   
   try {
     if(csReplace != null) {
       endIdx += csOther.length();
     }
     e_text.replace(ev.getBeginIndex(), endIdx, csReplace);
   } catch(IndexOutOfBoundsException ex) {
     if(e_text.length() < ev.getBeginIndex()) {
       e_text.append(csReplace);
     } else {
       e_text.insert(ev.getBeginIndex(), csReplace);
     }
   }
   if(client.currentSessionParticipantId() != ev.getUserid()) {
     setNeedToSync = true;
   } else {
     latestChangeApplied = sub.intValue();
     if(forceNext > 0) {
       setNeedToSync = true;
       forceNext--;
     }
   }
   serverText.setText(e_text);
   if(eventQueue.isEmpty() || iter == 10) {
     return setNeedToSync;
   } else {
     return applyTextEvent(iter + 1, setNeedToSync);
   }
 }

  public int sendEvent(EditorEvent editorEvent, String type)
  {
    if(client.inSession()) {
      try
      {
        return client.broadcast(editorEvent.toByteArray(), type);
      }
      catch( CollabrifyException e )
      {
        e.printStackTrace();
      }
    } 
    return Integer.MIN_VALUE;   
  }
  
  public void triggerSync()
  {
    String serverTextStr = new String(serverText.getText().toString());
    textManager.sync(serverTextStr);
  }


  public void forceNextSync()
  {
    forceNext++;
  }


  public void setChangeId(int id)
  {
    latestChangeSent = id;
  }

  private Handler sync;  
  private int lastSyncedChange;
  private Runnable timeKeep = new Runnable()
  {
    public void run()
    {
      if(latestChangeApplied != latestChangeSent) {
        applyTextEvent(0, false);
        sync.postDelayed(this, 1500);
        return;
      } else {
        if(lastSyncedChange < latestChangeApplied) {
          textManager.sync(serverText.getText().toString());
          lastSyncedChange = latestChangeApplied;
          sync.postDelayed(this, 1500);
          return;
        }
      }
      if(textManager.checkNotBusy() && applyTextEvent(0, false)) {
        lastSyncedChange = latestChangeApplied;
        textManager.sync(serverText.getText().toString());
      }
      sync.postDelayed(this, 1500);  // 1500 ms
    }
  };

}
