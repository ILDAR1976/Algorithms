package edu.computer_since.view;

import edu.computer_since.App;
import edu.computer_since.model.Model;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller 
{
	@FXML
	private TextArea outText;
	@FXML
	private TextField edit;
	
	private App App;
	
	public Controller(){}
	
	@FXML
    private void initialize() {
	}
	
    @FXML
    private void handleAddText() {
        
    	Model m = new Model();
    	int[] array;
    	
    	array = m.stringToArray(edit.getText());
    	
    	outText.setText((outText.getText().isEmpty()) ? "":outText.getText() + "\n");
    	
    	for (int i = 1;i < array.length; i++){
    		outText.setText(outText.getText() + array[i] + ((i != (array.length - 1))?",":""));
    	}
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

	public void setApp(App App) {
        this.App = App;
    }

}