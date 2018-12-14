package pkgApp.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;

	@FXML
	private TextField txtYearsToWork;
	
	@FXML
	private TextField txtAnnualReturn;
	
	@FXML
	private TextField txtYearsRetired;
	
	@FXML
	private TextField txtRetiredReturn;
	
	@FXML
	private TextField txtRequiredIncome;
	
	@FXML
	private TextField txtMonthlySSI;
	
	@FXML
	private Label lblSaveEachMonth;
	
	@FXML
	private Label lblTotalToSave;
	
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		lblSaveEachMonth.setText("");
		lblTotalToSave.setText("");
		txtMonthlySSI.setText("");
		txtRequiredIncome.setText("");
		txtRetiredReturn.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturn.setText("");
		txtYearsToWork.setText("");
		//	TODO: Clear all the text inputs
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 
		try {
			Retirement.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
			Retirement.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturn.getText()));
			Retirement.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			Retirement.setdAnnualReturnRetired(Double.parseDouble(txtRetiredReturn.getText()));
			Retirement.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
			Retirement.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));		
		
			Retirement.TotalAmountSaved();
			Retirement.AmountToSave();
				
			populate();
		}catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("Incorrect Format");
			alert.setHeaderText("Input Format Incorrect");
			alert.setContentText("Please input numbers for the calculation.");
			
			alert.showAndWait();
		}
		
	}
	
	
	private void populate () {
		lblTotalToSave.setText(String.format("%.2f", Retirement.getdTotalAmountSaved()));
		lblSaveEachMonth.setText(String.format("%.2f", Retirement.getdAmountToSave()));
		
	}
	
}
