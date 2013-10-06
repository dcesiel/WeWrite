package com.dcesiel.wewrite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.dcesiel.wewrite.CollabTextProto.globalMove;
import com.google.protobuf.InvalidProtocolBufferException;

import edu.umich.imlc.android.common.Utils;
import edu.umich.imlc.android.common.Utils.Logger;
import edu.umich.imlc.android.common.Utils.Logger.Level;
import edu.umich.imlc.collabrify.client.CollabrifyAdapter;
import edu.umich.imlc.collabrify.client.CollabrifyClient;
import edu.umich.imlc.collabrify.client.CollabrifyListener;
import edu.umich.imlc.collabrify.client.CollabrifySession;
import edu.umich.imlc.collabrify.client.exceptions.CollabrifyException;

public class MainActivity extends Activity
{

  private static final String SESSION_NAME = "adsflytdgsfhgsfgsfsjts";

  private int idCount = 0;
  private int idClock = -1;
  private int sub_id = -2;

  private TextManager mainTextEditor;

  private static String TAG = "MainActivity";
  private CollabrifyClient client;
  
  // private CheckBox withBaseFile;
  private CollabrifyListener collabrifyListener;
  private long sessionId;
  private String sessionName;
  private ByteArrayInputStream baseFileBuffer;
  private ByteArrayOutputStream baseFileReceiveBuffer;
  private ArrayList<String> tags = new ArrayList<String>();

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    EditText ref = (EditText) findViewById(R.id.editorBox);
    mainTextEditor = new TextManager(ref, this);

    tags.add("default");

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
      public void onDisconnect()
      {
        Log.i(TAG, "disconnected");
      }

      @Override
      public void onReceiveEvent(final long orderId, int subId, String eventType, final byte[] data)
      {
        //TODO: Check this
        Utils.printMethodName(TAG);
        Log.d(TAG, "RECEIVED SUB ID:" + subId);
        sub_id = subId;
        runOnUiThread(new Runnable()
        {
          @Override
          public void run()
          {
            Utils.printMethodName(TAG);

            globalMove message;
            try
            {
              message = globalMove.parseFrom(data);
              if( sub_id == -1 )
              {
                mainTextEditor.updateLocal(message.getLocation(), message.getLength(),
                    message.getText(), message.getDelete(), 0);
              }
              else
              {
                mainTextEditor.updateLocal(message.getLocation(), message.getLength(),
                        message.getText(), message.getDelete(),
                        message.getUserId());
              }

              idClock++;
              // }
            }
            catch( InvalidProtocolBufferException e )
            {
              Log.e(TAG, "error", e);
            }

          }
        });
      }

      @Override
      public void onSessionCreated(long id)
      {
        Log.i("onSessionCreated", "Session created with Id: " + id);
        sessionId = id;
      }

      @Override
      public void onError(CollabrifyException e)
      {
        Log.e("Collabrify Error", "error", e);
      }

      @Override
      public void onSessionJoined(long maxOrderId, long baseFileSize)
      {
        Log.i(TAG, "Session Joined");
        if(baseFileSize > 0)
        {
          baseFileReceiveBuffer = new ByteArrayOutputStream((int) baseFileSize);
        }
      }

      @Override
      public byte[] onBaseFileChunkRequested(long currentBaseFileSize)
      {
        //TODO: Check this
        // read up to max chunk size at a time
        byte[] temp = new byte[CollabrifyClient.MAX_BASE_FILE_CHUNK_SIZE];
        int read = 0;
        try{ read = baseFileBuffer.read(temp); }
        catch( IOException e ) {e.printStackTrace();}
        if( read == -1 )
        {
          return null;
        }
        if( read < CollabrifyClient.MAX_BASE_FILE_CHUNK_SIZE )
        {
          // Trim garbage data
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          bos.write(temp, 0, read);
          temp = bos.toByteArray();
        }
        return temp;
      }

      @Override
      public void onBaseFileChunkReceived(byte[] baseFileChunk)
      {
        try
        {
          if(baseFileChunk != null)
          {
            baseFileReceiveBuffer.write(baseFileChunk);
          }
          else
          {
            baseFileReceiveBuffer.close();
          }
        }
        catch(IOException e) {e.printStackTrace();}
      }

      @Override
      public void onBaseFileUploadComplete(long baseFileSize)
      {
        try
        {
          baseFileBuffer.close();
        }
        catch( IOException e ) {e.printStackTrace();}
      }
    };
    boolean getLatestEvent = false; //Make sure this is false

    // Instantiate client object
    try
    {
      client = new CollabrifyClient(this, "user email", "user display name",
          "441fall2013@umich.edu", "XY3721425NoScOpE", getLatestEvent, collabrifyListener);
      Log.i(TAG, "client Created");
      client.requestSessionList(tags);
    }
    catch(CollabrifyException e) {e.printStackTrace();}
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  public void broadcastMessage(Boolean delete, int location, String text,
      int UserId)
  {

    if( client != null && client.inSession() ) // if in session
    {
      try
      {
        globalMove message = globalMove.newBuilder().setDelete(delete)
            .setId(idCount).setUserId(UserId).setLocation(location)
            .setLength(text.length()).setText(text).build();

        idCount++;

        client.broadcast(message.toByteArray(), "lol");
      }
      catch( CollabrifyException e )
      {
        Log.e(TAG, "error", e);
      }
    }

  }

  public void undo(MenuItem menu)
  {
    mainTextEditor.undo();
  }

  public void redo(MenuItem menu)
  {
    mainTextEditor.redo();
  }


}
