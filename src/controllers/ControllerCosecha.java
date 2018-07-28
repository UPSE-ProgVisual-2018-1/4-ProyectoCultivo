package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;

public class ControllerCosecha implements Initializable, ContollerBaseVistaFormulario {

	@FXML Spinner<Double> spnHectareasCosechadas;
	@FXML Spinner<Integer> spnHumedadPorCien;
	@FXML Spinner<Integer> spnImpurezaPorCien;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar() {
		double hectareasCosechadas = spnHectareasCosechadas.getValue();
		System.out.println("Hectareas Cosechadas: " + hectareasCosechadas);
		int impurezaPorCien = spnImpurezaPorCien.getValue();
		System.out.println("Impureza %: " + impurezaPorCien);
		int humedadPorCien = spnHumedadPorCien.getValue();
		System.out.println("Humedad %: " + humedadPorCien);
	}

	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

}
