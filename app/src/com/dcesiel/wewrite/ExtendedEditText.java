package com.dcesiel.wewrite;

//Extended edit text from jgracik

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class ExtendedEditText extends EditText
{
  public interface onSelectionChangedListener 
  {
    public void onSelectionChanged(int selStart, int selEnd);
  }
  
  onSelectionChangedListener listener;
  
  public ExtendedEditText(Context context) 
  {
    super(context);
    listener = null;
  }

  public ExtendedEditText(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    listener = null;
  }
  
  public ExtendedEditText(Context context, AttributeSet attrs, int defStyle)
  {
    super(context, attrs, defStyle);
    listener = null;
  }

  public void addOnSelectionChangedListener(onSelectionChangedListener oscl)
  {
    listener = oscl;
  }
  
  public void removeOnSelectionChangedListener()
  {
    listener = null;
  }

  protected void onSelectionChanged(int selStart, int selEnd) 
  {
    if(listener != null) {
      listener.onSelectionChanged(selStart, selEnd);
    }
  }
  
}