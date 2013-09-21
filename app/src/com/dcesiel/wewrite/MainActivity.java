package com.dcesiel.wewrite;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import edu.umich.imlc.collabrify.client.CollabrifyClient;
import edu.umich.imlc.collabrify.client.CollabrifyListener;
import edu.umich.imlc.collabrify.client.CollabrifyParticipant;
import edu.umich.imlc.collabrify.client.CollabrifySession;
import edu.umich.imlc.collabrify.client.exceptions.CollabrifyException;

public class MainActivity extends Activity {
  
  public static final String SESSION_NAME = "cesiel";
  public static final String SESSION_TAGS = "";
  
  private EditText editText;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editText = (EditText) findViewById(R.id.textBox);
        try
        {
          CollabrifyListener collabrifyListener = new CollabrifyListener()
          {
            
            @Override
            public void onSessionJoined(long maxOrderId, long baseFileSize)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onSessionEnd(long id)
            {
              // TODO Auto-generated method stub
              
            }
            
            @Override
            public void onSessionCreated(long id)
            {
              // TODO Auto-generated method stub
              Log.i("", "Session Created");
              
            }
            
            @Override
            public void onReceiveSessionList(List<CollabrifySession> sessionList)
            {
              // TODO Auto-generated method stub
              
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
          CollabrifyClient collabClient = new CollabrifyClient(this, "dcesiel@gmail.com", "dcesiel", 
                            "441fall2013@umich.edu", "XY3721425NoScOpE", true, collabrifyListener);
          collabClient.createSession(SESSION_NAME, null, null, 0);
        }
        catch(CollabrifyException e){
          e.printStackTrace();
        }
        
        
        
        
    }

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        
        
        return true;
    }
    
}
