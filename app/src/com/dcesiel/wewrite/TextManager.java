package com.dcesiel.wewrite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

import android.R.string;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.Selection;
import android.util.Log;


@SuppressWarnings("unused")
public class TextManager {

	private static final boolean REMOVE = true;
	private static final boolean INSERT = false;

  private MainActivity docEdit;
  private EditText inputText;
  private TextWatcher collectText;
  private Buffer undoRedoList;
	
	private int cursorIndex;
  private Move moveToAdd;

  private int userId;
	private Random r;

	private String globalText;

	//Temp variables used for undo/redo
	Editable editable;
  Move tmpMove;
	
	//constructor
	TextManager(EditText ref, MainActivity docEditSrc){
    inputText = ref;
    globalText = "";
    docEdit = docEditSrc;
		userId = 8765445;
		cursorIndex = 0;
		undoRedoList = new Buffer();
		newTextWatch();
		inputText.addTextChangedListener(collectText);
	}

	private void newTextWatch(){
		collectText = new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
					if (count > after) {
						moveToAdd = new Move(start+after, count-after, s.toString().substring(start+after, start+count), REMOVE);
						printMove(moveToAdd);
						undoRedoList.add(moveToAdd);
						cursorIndex = moveToAdd.start;
						docEdit.broadcastMessage(REMOVE, moveToAdd.start, moveToAdd.change, userId);
					}
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(count > before){
					moveToAdd = new Move(start+before, count-before, s.toString().substring(start+before, start+count), INSERT);
					printMove(moveToAdd);
					undoRedoList.add(moveToAdd);
					cursorIndex = moveToAdd.start+moveToAdd.length;
					docEdit.broadcastMessage(INSERT, moveToAdd.start, moveToAdd.change, userId);
				}
			}
		};
	}

	public void undo(){
		tmpMove = undoRedoList.getUndo();
		if (tmpMove == null) {
			Log.d("Undo", "Nothing left to undo");
			return;
		}
		//Remove listener that looks for text changes because we don't want it listening for undos and redos
		//and adding them again to the undo/redo buffer
		inputText.removeTextChangedListener(collectText);
		editable = inputText.getText();
		if (tmpMove.type == INSERT) {
			editable.delete(tmpMove.start, tmpMove.start + tmpMove.length);
			cursorIndex = tmpMove.start;
			inputText.setText(editable);
			docEdit.broadcastMessage(REMOVE, tmpMove.start, tmpMove.change, userId);
			inputText.setSelection(cursorIndex);
		} 
		else{
			CharSequence insert = editable.insert(tmpMove.start, tmpMove.change);
			inputText.setText(insert);
			docEdit.broadcastMessage(INSERT, tmpMove.start, tmpMove.change, userId);
			cursorIndex = tmpMove.start + tmpMove.length;
			inputText.setSelection(cursorIndex);
		}
		newTextWatch();
		inputText.addTextChangedListener(collectText);
	}

	public void redo(){
		tmpMove = undoRedoList.getRedo();
		if(tmpMove == null){
			Log.d("Redo", "Nothing left to redo");
			return;
		}
		inputText.removeTextChangedListener(collectText);
		editable = inputText.getText();
		printMove(tmpMove);
		if(tmpMove.type == REMOVE){
			editable.delete(tmpMove.start, tmpMove.start + tmpMove.length);
			cursorIndex = tmpMove.start;
			inputText.setText(editable);
			docEdit.broadcastMessage(REMOVE, tmpMove.start, tmpMove.change, userId);
			inputText.setSelection(cursorIndex);
		} 
		else{
			CharSequence insert = editable.insert(tmpMove.start, tmpMove.change);
			inputText.setText(insert);
			docEdit.broadcastMessage(INSERT, tmpMove.start, tmpMove.change, userId);
			cursorIndex = tmpMove.start + tmpMove.length;
			inputText.setSelection(cursorIndex);
		}
		newTextWatch();
		inputText.addTextChangedListener(collectText);
	}
	
	
	void updateLocal(int start, int length, String s, boolean type, int id){
		inputText.removeTextChangedListener(collectText);
		if(start > globalText.length()){
			start = globalText.length();
		}
		String tmpFirst = globalText.substring(0, start);
		if(type == REMOVE){
			String tmpSecond = globalText.substring(start+length);
			tmpFirst = tmpFirst.concat(tmpSecond);
		}
		else{
			String temp_second = globalText.substring(start);
			tmpFirst = tmpFirst.concat(s);
			tmpFirst = tmpFirst.concat(temp_second);
		}
		globalText = tmpFirst;
		if(id != userId){
			int curLoc = inputText.getSelectionStart();
			Log.e("CURSOR LOCATION: ", String.valueOf(curLoc));
			inputText.setText((CharSequence) globalText);
			undoRedoList.offset(start, length, type);
			if(type && curLoc > start){
				inputText.setSelection(curLoc-length);
			}
			else if(!type && curLoc > start){
				inputText.setSelection(curLoc+length-1);
			}
			else{
				inputText.setSelection(curLoc);
			}
		}
		newTextWatch();
		inputText.addTextChangedListener(collectText);
	}
	
	//testing function
	private void printMove(Move m) {
		Log.d("MOVE start index:", String.valueOf(m.start));
		Log.d("MOVE length:", String.valueOf(m.length));
		Log.d("MOVE change:", m.change);
		Log.d("MOVE type:", String.valueOf(m.type));
	}

}
