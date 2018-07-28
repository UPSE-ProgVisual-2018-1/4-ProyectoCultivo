package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Cultivo;
import model.Especie;
import model.TipoPaquete;
import model.TipoSemilla;
import testMocker.ObjectMocker;
import java.time.temporal.ChronoUnit;

public class ControllerCultivo implements Initializable, ContollerBaseVistaFormulario {

	@FXML TextField txtId;
	@FXML TextField txtHectareasCultivadas;
	@FXML ChoiceBox<Especie> chbEspecie; //Cambiar a ComboBox
	@FXML ChoiceBox<TipoSemilla> chbSemilla;
	@FXML ChoiceBox<TipoPaquete> chbPaquete;
	@FXML DatePicker dateSiembra;
	@FXML DatePicker dateSiembra30Dias;
	@FXML DatePicker dateSiembra45Dias;
	@FXML DatePicker dateSiembra60Dias;
	@FXML ProgressBar pbarProgresoCultivo;
	
	private Cultivo cultivo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<TipoSemilla> listaObservableSemilla =
				FXCollections.observableArrayList(TipoSemilla.values());
		chbSemilla.setItems(listaObservableSemilla);
		

		ObservableList<TipoPaquete> listaObservablePaquete =
				FXCollections.observableArrayList(TipoPaquete.values());
		chbPaquete.setItems(listaObservablePaquete);
		
		ObservableList<Especie> listaObservableEspecie =
				FXCollections.observableArrayList(ObjectMocker.listaEspecieMocker());
		chbEspecie.setItems(listaObservableEspecie);
		
		dateSiembra.setValue(LocalDate.now());
		calcularFechasAutomaticas();

	}

	@Override
	public void guardar() {
		
		int id = Integer.parseInt(txtId.getText());
		double hectareasCultivadas = Double.parseDouble(txtHectareasCultivadas.getText());
		Especie especie = chbEspecie.getValue();
		TipoSemilla semilla = chbSemilla.getValue();
		LocalDate fechaSiembra = dateSiembra.getValue();
		
		cultivo = new Cultivo(id, hectareasCultivadas, especie, semilla, fechaSiembra);
		System.out.println("Veamos el cultivo guardado.");
		System.out.println(cultivo);
		
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
	
	public void calcularFechasAutomaticas()
	{
		LocalDate fechaSiembra30dias = dateSiembra.getValue().plusDays(30);
		dateSiembra30Dias.setValue(fechaSiembra30dias);
		
		LocalDate fechaSiembra45dias = dateSiembra.getValue().plusDays(45);
		dateSiembra45Dias.setValue(fechaSiembra45dias);
		
		LocalDate fechaSiembra60dias = dateSiembra.getValue().plusDays(60);
		dateSiembra60Dias.setValue(fechaSiembra60dias);
	}
	
	public void calcularProgresoCultivo()
	{
		double progresoCultivo = 0;
		LocalDate fechaActual = LocalDate.now();
		
		long diasTranscurridos = ChronoUnit.DAYS.between(dateSiembra.getValue(), fechaActual);
		
		System.out.println("Dias Transcurrido: " + diasTranscurridos);
		
		progresoCultivo = diasTranscurridos/60.0;
		
		System.out.println("Progreso Cultivo: " + progresoCultivo);
		
		pbarProgresoCultivo.setProgress(progresoCultivo);
		
	}

}
