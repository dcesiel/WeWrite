package com.dcesiel.wewrite;

import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
  
  public static final String SESSION_NAME = "cesiel";
  public static final String SESSION_TAGS = "";
  
  private EditText text;
  //private Stack<UndoRedoData> undoRedoStack;
  private Button undo;
  private Button redo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //undoRedoStack = new Stack<UndoRedoData>();
        
        text = (EditText) findViewById(R.id.textBox);
        undo = (Button) findViewById(R.id.undo);
        redo = (Button) findViewById(R.id.redo);
        
        undo.setOnClickListener(undoButtonHandler);
        redo.setOnClickListener(redoButtonListner);
        
        
        text.addTextChangedListener(new TextWatcher(){
            public void onTextChanged(CharSequence s, int start, int before, int count){
              Log.i("TextBuffer", "Char: " + " " + s.charAt(start) + " Value: " + start);
              //undoRedoStack.push(new UndoRedoData(s.charAt(start), start));
            }

            @Override
            public void afterTextChanged(Editable s)
            {
              // TODO Auto-generated method stub
              
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                int after)
            {
              // TODO Auto-generated method stub
              
            }
        });
        
        
    }
    
    View.OnClickListener undoButtonHandler = new View.OnClickListener() {
      public void onClick(View v) {
        Log.i("Undo Button:", "Undo Pressed");
      }
    };
    
    View.OnClickListener redoButtonListner = new View.OnClickListener() {
      public void onClick(View v) {
        Log.i("Redo Button:", "Redo Pressed");
      }
    };

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        
        
        return true;
    }
    
}
