package com.dcesiel.wewrite;

import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
  
  public static final String SESSION_NAME = "cesiel";
  public static final String SESSION_TAGS = "";
  
  private EditText text;
  private TextManager textManager;
  private Button undo;
  private Button redo;
  private Button startSessionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        text = (EditText) findViewById(R.id.textBox);
        undo = (Button) findViewById(R.id.undo);
        redo = (Button) findViewById(R.id.redo);
        startSessionButton = (Button) findViewById(R.id.startSessionButton);
        textManager = new TextManager(text);
        
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
      }
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        
        
        return true;
    }
    
}
