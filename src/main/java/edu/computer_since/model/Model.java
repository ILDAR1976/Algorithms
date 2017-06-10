package edu.computer_since.model;

import java.beans.IndexedPropertyChangeEvent;
import java.util.ArrayList;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Model{
	public void copyText(TextArea area, TextField field){
		area.setText(area.getText() + "\n" + field.getText());
	}
	
	public int[] stringToArray(String inp){
		
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		
		String str = "";
		
		for (int i = 0; i < inp.length(); i++){
			
			char symbol = inp.charAt(i);
			if (symbol != ',') {
				str += symbol; 
			} else {
				buffer.add(Integer.parseInt(str));
				str = "";
			};
		}
		
		if (!str.isEmpty()) buffer.add(Integer.parseInt(str));
		
		int[] out = new int[buffer.size() + 1];
		
		for (int i = 1; i<buffer.size() + 1; i++){
			out[i] = buffer.get(i-1);
		}
		
		return out;
	}
	
	public int[] bubbleSort(int[] inp){
		int[] out = new int[inp.length];
		return out;
	}
	
	public int[] insertSort(int[] inp){
		int[] out = new int[inp.length];
		return out;
	}
	
	public int[] mergeSort(int[] inp){
		int[] out = new int[inp.length];
		return out;
	}


}