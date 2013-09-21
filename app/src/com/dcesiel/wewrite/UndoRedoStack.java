package com.dcesiel.wewrite;

import java.util.Stack;

import android.util.Log;

public class UndoRedoStack
{
  private Stack<UndoRedoData> bufferStack = new Stack<UndoRedoData>();
  private Stack<UndoRedoData> redoStack = new Stack<UndoRedoData>();
  
  public void push(UndoRedoData d){
    bufferStack.push(d);
  }
  
  public void undo(){
    if (!bufferStack.empty()){
      UndoRedoData d = bufferStack.peek();
      Log.i("UndoRedoStack", "Undoing: " + Character.toString(d.c));
      redoStack.push(bufferStack.pop());
    }
    else{
      Log.i("UndoRedoStack", "Can't undo, bufferStack is empty");
    }
  }
  
  public void redo(){
    if (!redoStack.empty()){
      UndoRedoData d = redoStack.peek();
      Log.i("UndoRedoStack", "Redoing: " + Character.toString(d.c));
      bufferStack.push(redoStack.pop());
    }
    else{
      Log.i("UndoRedoStack", "Can't redo, redoStack is empty");
    }
  }
  
  public void wipeRedo(){
    redoStack.clear();
  }
  
}
