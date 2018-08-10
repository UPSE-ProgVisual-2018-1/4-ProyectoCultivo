package controllers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ControllerCosecha implements Initializable, ContollerBaseVistaFormulario {

	@FXML Button btnBuscar;
	@FXML TextField txtId;
	@FXML Spinner<Double> spnHectareasCosechadas;
	@FXML Spinner<Integer> spnHumedadPorCien;
	@FXML Spinner<Integer> spnImpurezaPorCien;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		asignarFuncionalidadBusqueda();
	}

	private void asignarFuncionalidadBusqueda() {
		btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Buscando" + txtId.getText());
			}
		});
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
		class Borrador{
			public int idABorrar;
			
			public Borrador(int idABorrar)
			{
				this.idABorrar = idABorrar;
			}
			
			public boolean borrar()
			{
				Random r = new Random();
				boolean operacionBorrado = r.nextBoolean();
				idABorrar = Integer.parseInt(txtId.getText());
				if(operacionBorrado)
				{
					return true;
				}else {
					return false;
				}
			}
		}
		
		Borrador borraDatos = new Borrador(Integer.parseInt(txtId.getText()));
		boolean seBorro = borraDatos.borrar();
		if(seBorro)
		{
			System.out.println("Se Borro Correctamente");
		}else {
			System.err.println("No se Borro");
		}
	}

	@Override
	public void cancelar() {
		// TODO Auto-generated method stub
		
	}

}
