package com.dcesiel.wewrite;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class TextManager extends UndoRedoStack
{
  private static final boolean REMOVE = true;
  private static final boolean INSERT = false;
  private int prevStart = 0;
  boolean undoRedoPressed = false;
  TextManager t = this;
  EditText text;
  
  Move prevMove = new Move();
  
  
  TextManager(EditText ref){
    text = ref;
    ref.addTextChangedListener(new TextWatcher(){
      @Override
      public void afterTextChanged(Editable s) {}
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!undoRedoPressed){
          Move current_move = new Move();
          if (prevMove == null){
            prevMove = new Move();
          }
          if(prevStart != start && prevMove.change != " "){
            t.push(prevMove);
            Log.d("Adding a move:", prevMove.change);
            prevMove.change.concat(" ");
            prevStart = start;
          }
          current_move.start_coordinate = start;
          current_move.old_length = before;
          current_move.new_length = count;
          current_move.change = s.toString().substring(start, start+count);
          if (before > count){
            current_move.type = REMOVE;
          }
          else{
            current_move.type = INSERT;
          }
          prevMove = current_move;
        }
      }
    });
  }
  
  @Override
  public Move undo()
  {
    Move move = super.undo();
    if (move != null){
      if (move.type = REMOVE){
        Editable currentText = text.getText();
        undoRedoPressed = true;
        currentText.replace(move.start_coordinate, (move.start_coordinate + move.new_length), "");
        Log.i("TextManager", currentText.toString());
        text.setText(currentText);
        text.setSelection(move.start_coordinate);
      }
    }
    prevMove = super.getBufferTop();
    undoRedoPressed = false;
    return move;
  }
  
  @Override
  public Move redo()
  {
    return super.redo();
  }
}
