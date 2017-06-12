package edu.computer_since.model;

import java.beans.IndexedPropertyChangeEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Model{
	
	private StringBuilder Logger = null;
	private int operation = 1;
	private final int INFINITY = 2147483647;
	
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
			
			case "Merge Sort":
				return mergeSort(stringToArray(array));

			case "Shell Sort":
				return shellSort(stringToArray(array));
			
			case "Quick Sort":
				return quickSort(stringToArray(array));
			
			case "Tim Sort":
				return timSort(stringToArray(array));
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
		operation = 1;
		mergeSortLocal(inp,1,inp.length - 1);
		return inp;
	}

	public void mergeSortLocal(int[] inp,int p, int r){
		if ( p < r) {
			int q = (p + r) / 2;
			mergeSortLocal(inp, p, q);
			mergeSortLocal(inp, q + 1, r);
			merge(inp, p, q, r);
		}
	}
	
	public void merge(int[] inp, int p, int q, int r ){
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] iL = new int[n1 + 2];
		
		int[] iR = new int[n2 + 2];
		
		for (int i = 1; i <= n1; i++) {
			iL[i] = inp[p + i - 1];
		}
		
		for (int i = 1; i <= n2; i++) {
			iR[i] = inp[q + i];
		}
		
		iL[n1 + 1] = INFINITY; 
		iR[n2 + 1] = INFINITY;
		
		int i = 1;
		int j = 1;
		
		for (int k = p; k <= r; k++) {
			if (iL[i] <= iR[j]) {
				inp[k] = iL[i];
				i++;
			} else {
				inp[k] = iR[j];
				j++;
			}
			
			printArray(inp);
			Logger.append(" (" + operation + ")\n");
			operation++;
				
		}
	}

	public int[] shellSort(int[] inp){
		int i,j,k,t;
		
		final int N = inp.length;
		
		operation = 1;
		
		for(k = N/2; k > 0; k /=2)
	        for(i = k; i < N; i++)
	        {
	            t = inp[i];
	            for(j = i; j>=k; j-=k)
	            {
	                if(t < inp[j-k])
	                    inp[j] = inp[j-k];
	                else
	                    break;
					
	                printArray(inp);
					Logger.append(" (" + operation + ")\n");
					operation++;

	            }
	            inp[j] = t;
	        }
        
		printArray(inp);
		Logger.append(" (" + operation + ")\n");
		
		return inp;
	}
	
	public int[] quickSort(int[] inp){
		
		operation = 1;

		quickSortLocal(inp, 1, inp.length - 1);
		
		return inp;
	}
	
	private void quickSortLocal (int[] inp, int lo, int hi){
		
		int p;
		
	    if (lo < hi) {
	        p = partition(inp, lo, hi);
	        quickSortLocal(inp, lo, p - 1);
	        quickSortLocal(inp, p + 1, hi);
	    }
	    
	}
	
	private int partition(int[] inp, int lo, int hi){
		
		int pivot,i,j;
	   
		pivot = inp[hi];
	    
		i = lo - 1;
	    
	    for (j = lo; j < hi; j++) {
		    
	    	if (inp[j] <= pivot) {
		    	i++;
		    	swap(inp, i, j);
		    }
	
	        printArray(inp);
			Logger.append(" (" + operation + ")\n");
			operation++;
	        
	    }
	
	    swap(inp, i + 1, hi); 

        printArray(inp);
		Logger.append(" (" + operation + ")\n");
		operation++;

		return i + 1;		
	}
	
	private void swap(int[] inp, int a, int b){
		if (a != b) {
			inp[a] = inp[a] + inp[b]; 
			inp[b] = inp[a] - inp[b]; 
			inp[a] = inp[a] - inp[b];
		}
	}
	
	public int[] timSort(int[] inp){
		Integer[] tsb = new Integer[inp.length];
		
		for (int i = 0; i < inp.length; i++) {
			tsb[i] = inp[i];
		}
		
		TimSort ts = new TimSort(new Integer[inp.length], NumberComparator);
		
		ts.sort(tsb, NumberComparator);
		Logger.setLength(0);
		Logger.append(ts.getLogger());
		ts.clearLogger();
		
		for (int i = 0; i < inp.length; i++) {
			inp[i] = tsb[i];
		}
		
		return inp;
	}
	
	public static Comparator<Integer> NumberComparator = new Comparator<Integer>() {
		 
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    };
    
	
 	public void printArray(int[] inp){

		for (int i = 1; i < inp.length; i++)
			Logger.append(inp[i] + ((i < inp.length - 1)?", ":""));
		
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