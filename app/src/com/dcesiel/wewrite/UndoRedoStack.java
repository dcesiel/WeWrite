package com.dcesiel.wewrite;

import java.util.Stack;

import android.util.Log;

public class UndoRedoStack
{
  private Stack<Move> bufferStack = new Stack<Move>();
  private Stack<Move> redoStack = new Stack<Move>();
  
  public void push(Move d){
    Log.i("UndoRedoStack", "Pushing " + "Start: " + d.start_coordinate + " Length: " + d.new_length + " to stack");
    bufferStack.push(d);
  }
  
  public Move undo(){
    if (!bufferStack.empty()){
      Move d = bufferStack.peek();
      Log.i("UndoRedoStack", "Undoing: " + d.change);
      redoStack.push(bufferStack.pop());
      return d;
    }
    else{
      Log.i("UndoRedoStack", "Can't undo, bufferStack is empty");
    }
    return null;
  }
  
  public Move redo(){
    if (!redoStack.empty()){
      Move d = redoStack.peek();
      Log.i("UndoRedoStack", "Redoing: " + d.change);
      bufferStack.push(redoStack.pop());
      return d;
    }
    else{
      Log.i("UndoRedoStack", "Can't redo, redoStack is empty");
    }
    return null;
  }
  
  public void wipeRedo(){
    redoStack.clear();
  }
  
  public Move getBufferTop(){
    if (!bufferStack.empty()){
      return bufferStack.peek();
    }
    return null;
  }
  
}
