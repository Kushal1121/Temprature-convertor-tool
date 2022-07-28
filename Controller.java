package com.intershala;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox choiceBox;

	@FXML
	public TextField textField;

	@FXML
	public Button convertButton;
	private  boolean isC_TO_FH=true;

	public static final String C_TO_FH="Celsius to Fahrenheit ";
	public static final String FH_TO_C="Fahernheit to Celsius ";
	@Override
	public void initialize(URL location, ResourceBundle resources) {


		choiceBox.getItems().add(C_TO_FH);
		choiceBox.getItems().add(FH_TO_C);

		choiceBox.setValue(C_TO_FH);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if(newValue.equals(C_TO_FH)){
				isC_TO_FH=true;
			}else{
				isC_TO_FH=false;
			}
		});



       convertButton.setOnAction(event -> {
       	  convert();
       });
	}

	private void convert() {

	 String input=	textField.getText();  // 23.5 -> "23.5"
		float enterdTemprature=0.0f;
		try {
			 enterdTemprature = Float.parseFloat(input);  // "23.5"->23.5f

		}catch (Exception ex){
			warnUser();
			return;
		}


		float newTemprature=0.0f;
		if(isC_TO_FH){
			newTemprature=(enterdTemprature*9/5)+32;
		}else{
			newTemprature=(enterdTemprature-32)*5/9;
		}
		display(newTemprature);
	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occured");
		alert.setHeaderText("Invalid Temprature Entered");
		alert.setContentText("Please Enter Valid Temprature");
		alert.show();
	}

	private void display(float newTemprature) {
		String unit=isC_TO_FH? "F":"C";

		Alert alert= new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temprature is :"+ newTemprature + " "+unit);
		alert.show();
	}

}
