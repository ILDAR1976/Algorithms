package edu.computer_since.model;

import java.beans.IndexedPropertyChangeEvent;
import java.util.ArrayList;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Model{
	
	private StringBuilder Logger = null;

	public Model(){
		Logger = new StringBuilder();
	}
	
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
	
	public int[] select(String inp, String array){
		if (inp != null)
			switch (inp){
			
			case "Bubble Sort":
				return bubbleSort(stringToArray(array));
			
			case "Insertion Sort":
				return insertionSort(stringToArray(array));
			
			}
		
		return null;
	}
	
	public int[] bubbleSort(int[] inp){
		int[] out = new int[inp.length];
		
		int buffer = 0;
		
		boolean flag = true;
		
		int operation = 1;
		
		while (flag) {
		
			flag = false;	
			
			for (int i = 1; i < inp.length - 1; i++) {
				
				if (inp[i] > inp[i + 1]) {
					flag = true;
					buffer = inp[i + 1];
					inp[i + 1] = inp[i];
					inp[i] = buffer;
					
				}
				
				printArray(inp);
				Logger.append(" (" + operation + ")\n");
				operation++;
				
			}
			
		}
				
		return inp;
	}
	
	public int[] insertionSort(int[] inp){
		
		int i = 0;
		int j = 2;
		int key = 0;
		int operation = 1;
		
		for (;j < inp.length; j++){
			
			key = inp[j];
			  
			i = j - 1;
			
			while ((i > 0) && (inp[i] > key)){
				inp[i + 1] = inp[i];
				
				i = i - 1;

				printArray(inp);
				Logger.append(" (" + operation + ")\n");
				operation++;
			}
			
			inp[i + 1] = key;
		}

		printArray(inp);
		Logger.append(" (" + operation + ")\n");

		return inp;
	}
	
	public int[] mergeSort(int[] inp){
		int[] out = new int[inp.length];
		return out;
	}

	public void printArray(int[] inp){

		for (int i = 1; i < inp.length; i++)
			Logger.append(inp[i] + ((i < inp.length - 1)?", ":""));
		
		//if (Logger.length() != 0) Logger.append("\n");
	}
	
	public String getLogger(){
		return Logger.toString();
	}

	public String getInizialValue(){
		String out = "";
		
		int value = 10;
		
		for (int i = 1; i < 11; i++)
			out += "" + (value--) + ((i < 10)?",":"");
			
		return out; 
	}
}