package edu.computer_since.view;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.event.DocumentEvent.EventType;

import edu.computer_since.App;
import edu.computer_since.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;


public class Controller 
{
	@FXML
	private TextArea outText;
	@FXML
	private TextField edit;
	@FXML
	private ChoiceBox selector;
	
	private App App;
	public static String CurrentAlgorithm;
	
	public Controller(){}
	
	@SuppressWarnings("restriction")
	@FXML
    private void initialize() {
		ObservableList<String> List = FXCollections.observableArrayList();
		List.add("Bubble Sort");
		List.add("Insertion Sort");
		List.add("Merge Sort");
		List.add("Shell Sort");
		List.add("Quick Sort");
		List.add("Tim Sort");
		
		selector.setItems(List);
		
		selector.getSelectionModel().selectedIndexProperty().addListener(
				new ChangeListener<Number>() {
					@SuppressWarnings("unused")
					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
							Number newValue) {
						CurrentAlgorithm = (String) selector.getItems().get((int) newValue);
					}
				});
	}
   
    @FXML
    private void handleCalc() {
        
    	Model m = new Model();
    	
    	int[] array;
    	
    	outText.clear();
    	
    	array = m.select(CurrentAlgorithm, edit.getText());

    	if (array != null) outText.setText(m.getLogger());
    	
     }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
	public void setApp(App App) {
        this.App = App;
    }

}