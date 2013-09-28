package com.dcesiel.wewrite;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.umich.imlc.collabrify.client.CollabrifyAdapter;
import edu.umich.imlc.collabrify.client.CollabrifyClient;
import edu.umich.imlc.collabrify.client.CollabrifyListener;
import edu.umich.imlc.collabrify.client.CollabrifyParticipant;
import edu.umich.imlc.collabrify.client.CollabrifySession;
import edu.umich.imlc.collabrify.client.exceptions.CollabrifyException;
import edu.umich.imlc.collabrify.client.exceptions.ConnectException;

public class MainActivity extends Activity {
  
  public static final String SESSION_NAME = "cesiel";
  public static final String SESSION_TAGS = "";
  
  private static final boolean getLatestEvent = false;
  
  private EditText text;
  private TextManager textManager;
  private Button undo;
  private Button redo;
  private Button startSessionButton;
  private long sessionId;
  private String sessionName;
  
  private CollabrifyListener collabrifyListener;
  private CollabrifyClient collabClient;
  private ArrayList<String> tags;
  
  Context mainActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        mainActivityContext = this;
        
        text = (EditText) findViewById(R.id.textBox);
        undo = (Button) findViewById(R.id.undo);
        redo = (Button) findViewById(R.id.redo);
        startSessionButton = (Button) findViewById(R.id.startSessionButton);
        textManager = new TextManager(text);
        tags = new ArrayList<String>();
        tags.add("default");
        
        undo.setOnClickListener(undoButtonListener);
        redo.setOnClickListener(redoButtonListner);
        startSessionButton.setOnClickListener(startSessionButtonListener);
        
    }
    
    View.OnClickListener undoButtonListener = new View.OnClickListener() {
      public void onClick(View v) {
        Log.i("Undo Button:", "Undo Pressed");
        textManager.undo();
      }
    };
    
    View.OnClickListener redoButtonListner = new View.OnClickListener() {
      public void onClick(View v) {
        Log.i("Redo Button:", "Redo Pressed");
        textManager.redo();
      }
    };
    
    View.OnClickListener startSessionButtonListener = new View.OnClickListener() {
      public void onClick(View v) {
        Log.i("Start session button:", "Start session pressed");
        
        
        try{
          collabrifyListener = new CollabrifyAdapter()
          {
            
            @Override
            public void onSessionJoined(long maxOrderId, long baseFileSize)
            {
              Log.i("onSessionJoined", "SessionJoined yo");
            }
            
            @Override
            public void onSessionEnd(long id)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onSessionCreated(long id)
            {
              Log.i("onSessionCreated", "SessionCreated yo");
            }
            
            
            @Override
            public void onReceiveSessionList(List<CollabrifySession> sessionList)
            {
              boolean sessionExists = false;
              int counter = 0;
              int sessionIndex = 0;
              for(CollabrifySession session : sessionList){
                if (session.name().equals(SESSION_NAME)){
                  sessionExists = true;
                  sessionIndex = counter;
                }
                counter++;
              }
              if (sessionExists){
                try
                {
                  sessionId = sessionList.get(sessionIndex).id();
                  sessionName = sessionList.get(sessionIndex).name();
                  collabClient.joinSession(sessionId, null);
                }
                catch( ConnectException e )
                {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                }
                catch( CollabrifyException e )
                {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                }
              } else {
                try
                {                    
                  collabClient.createSession(SESSION_NAME, tags, null, 0);
                  Log.i("Session Create", "Session name is " + SESSION_NAME);
                }
                catch( CollabrifyException e ){
                    Log.e("CollabrifyException", "error", e);
                }
              }
            }
            
            @Override
            public void onReceiveEvent(long orderId, int submissionRegistrationId,
                String eventType, byte[] data)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onParticipantLeft(CollabrifyParticipant p)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onParticipantJoined(CollabrifyParticipant p)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onError(CollabrifyException e)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onDisconnect()
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onBaseFileUploadComplete(long baseFileSize)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public byte[] onBaseFileChunkRequested(long currentBaseFileSize)
            {
              // TODO Auto-generated method stub
              return null;
            }
            
            @Override
            public void onBaseFileChunkReceived(byte[] baseFileChunk)
            {
              // TODO Auto-generated method stub
              
            }
          };
          collabClient = new CollabrifyClient(mainActivityContext, "user email", "user display name", "441fall2013@umich.edu", "XY3721425NoScOpE", getLatestEvent, collabrifyListener);
          Log.d("Main:", "collabClient Created");
          collabClient.requestSessionList(tags);
      

          Toast toast = Toast.makeText(mainActivityContext, "Session Created", Toast.LENGTH_SHORT);
          toast.show();
        }
        catch(Exception e){
          e.printStackTrace();
        }
      }
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        
        
        return true;
    }
    
}
