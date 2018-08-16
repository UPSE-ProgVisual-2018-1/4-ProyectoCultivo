package controllers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class ControllerCosecha implements Initializable, ContollerBaseVistaFormulario {

	@FXML Button btnBuscar;
	@FXML TextField txtId;
	@FXML Spinner<Double> spnHectareasCosechadas;
	@FXML Spinner<Integer> spnHumedadPorCien;
	@FXML Spinner<Integer> spnImpurezaPorCien;
	@FXML DatePicker dateFechaCosecha;
	@FXML TextField txtProduccionTotal;
	@FXML TextField txtProduccionTotalTM;
	@FXML TextField txtRendimientoHectareaPromedio;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		asignarFuncionalidadBusqueda();
		calcularAutomaticamenteRendimientoPromedio();
	}

	private void calcularAutomaticamenteRendimientoPromedio() {
		
		ChangeListener<Boolean> listenerCambiosParaCalculoRendimiento = new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(!newValue)
				{
					if(!txtProduccionTotalTM.getText().isEmpty() 
							&& !spnHectareasCosechadas.getValue().equals(0)
							&& txtProduccionTotalTM.getText().matches("\\d+"))
					{
						float rendimientoPromedioTemp = calculoMatematimaticoRendimientoPromedio();
						txtRendimientoHectareaPromedio.setText(String.valueOf(rendimientoPromedioTemp));
					}else {
						txtRendimientoHectareaPromedio.setText(null);
					}
				}	
			}
		};
		
		//NuevoListenerCambiosRendimiento nlcr = new NuevoListenerCambiosRendimiento();
		
		txtProduccionTotalTM.focusedProperty().addListener(listenerCambiosParaCalculoRendimiento);
		
		spnHectareasCosechadas.focusedProperty().addListener(listenerCambiosParaCalculoRendimiento);
		
	}
	
	protected float calculoMatematimaticoRendimientoPromedio() {
		float hectareasCosechadasTemp = spnHectareasCosechadas.getValue().floatValue();
		float produccionTotalTMTemp = Float.parseFloat(txtProduccionTotalTM.getText());
		float rendimientoPromedioTemp = produccionTotalTMTemp/hectareasCosechadasTemp;
		return rendimientoPromedioTemp;
	}

	private void asignarFuncionalidadBusqueda() {
//		btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.println("Buscando" + txtId.getText());
//			}
//		});
		
		btnBuscar.setOnAction(e -> System.out.println("Buscando " + txtId.getText()));
		
		
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
