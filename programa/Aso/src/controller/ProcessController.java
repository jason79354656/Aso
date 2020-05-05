package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Proces;


public class ProcessController implements Initializable{
	
	@FXML
	private TextField txtcpu;
	@FXML
	private TextField txtproces;
	@FXML
	private TextField txtarrival;
	@FXML
	private TextField txt;
	@FXML
	private Button btnsave;
	@FXML 
	private Button btncancel;
	@FXML
	private Proces proces;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	@FXML
	private void saveprocess(ActionEvent event) {
		String name = this.txtproces.getText();
		int arrival = Integer.parseInt(this.txtarrival.getText());
		
	}
	
	@FXML
	private void closet(ActionEvent event) {
		
	}

}
