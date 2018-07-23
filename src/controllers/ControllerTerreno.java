package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

public class ControllerTerreno implements Initializable, ContollerBaseVistaFormulario{
	@FXML CheckBox cbxSeguroAgricola;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
	}
	
	public void guardar()
	{
		boolean seguroAgricola = cbxSeguroAgricola.isSelected();
		System.out.println("Valor Seguro Agricola: " + seguroAgricola);
	}
	
	public void cancelar()
	{
		
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}
}
