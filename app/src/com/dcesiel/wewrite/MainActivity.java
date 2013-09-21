package com.dcesiel.wewrite;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {
  
  public static final String SESSION_NAME = "cesiel";
  public static final String SESSION_TAGS = "";
  
  private EditText text;
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        text = (EditText) findViewById(R.id.textBox);
        text.addTextChangedListener(new TextWatcher(){
            public void onTextChanged(CharSequence s, int start, int before, int count){
              Log.i("TextBuffer", s.toString() + " " + Integer.toString(start) + " " + Integer.toString(count));
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

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        
        
        
        
        return true;
    }
    
}
