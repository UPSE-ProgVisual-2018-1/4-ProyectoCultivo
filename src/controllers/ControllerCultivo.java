package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
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
	
	@FXML CheckMenuItem cmiTooltipMenu;
	@FXML Menu menuUsuario;
	
	@FXML Label lblId;
	@FXML Label lblHectareasCultivadas;
	@FXML Label lblEspecie;
	@FXML Label lblSemilla;
	
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
		
		menuUsuario.setDisable(true);

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
	
	public void salirPantalla()
	{
	    Stage stage = (Stage) txtId.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public void salirSistema()
	{
		System.exit(0);
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
	
	private void activarTooltip()
	{
		Tooltip toolTipId = new Tooltip("ID es un identificador unico. Sirve para guardar y cargar.");
		txtId.setTooltip(toolTipId );
		
		Tooltip toolTipHectareasCultivadas 
			= new Tooltip("Un numero que indique las hectareas a cultivar/cultivadas (puede tener decimales).");
		txtHectareasCultivadas.setTooltip(toolTipHectareasCultivadas);
		
		Tooltip toolTipEspecies
		= new Tooltip("La especie especifica a Cultivar. Para ingresar nuevas, vaya a la Pantalla de Especies.");
		chbEspecie.setTooltip(toolTipEspecies); //Cambiar a ComboBox
		
		Tooltip toolTipSemilla 
		= new Tooltip("El tipo de semilla a utilizar en el cultivo. A veces depende del paquete.");
		chbSemilla.setTooltip(toolTipSemilla);
		
		Tooltip toolTipPaquete
		= new Tooltip("El paquete es un kit preensamblado de sembrado. Suele contener semillas y fertilizante.");	
		chbPaquete.setTooltip(toolTipPaquete);
		
		Tooltip toolTipFechaSiembra 
		= new Tooltip("La Fecha efectiva en que se realizo la siembra de este cultivo.");
		dateSiembra.setTooltip(toolTipFechaSiembra);
		
		Tooltip toolTipFechaSiembra30Dias
		= new Tooltip("La fecha en que la siembra cumple 30 dias y se realiza el control. No siempre coinciden. Normalmente es el primer control.");
		dateSiembra30Dias.setTooltip(toolTipFechaSiembra30Dias);
		
		Tooltip toolTipFechaSiembra45Dias
		= new Tooltip("La fecha en que la siembra cumple 45 dias y se realiza el control. No siempre coinciden.");
		dateSiembra45Dias.setTooltip(toolTipFechaSiembra45Dias);
		
		Tooltip toolTipFechaSiembra60Dias
		= new Tooltip("La fecha en que la siembra cumple 60 dias y se realiza el control. No siempre coinciden. Normalmente es el ultimo control, previo a la cosecha.");
		
		dateSiembra60Dias.setTooltip(toolTipFechaSiembra60Dias);
		
		Tooltip toolTipProgresoCultivo
		= new Tooltip("Permite visualizar el progreso estimado del cultivo. Fines meramente informativos.");
		
		pbarProgresoCultivo.setTooltip(toolTipProgresoCultivo);
		
	}
	
	private void desactivarTooltip()
	{
		txtId.setTooltip(null);
		txtHectareasCultivadas.setTooltip(null);
		chbEspecie.setTooltip(null); //Cambiar a ComboBox
		chbSemilla.setTooltip(null);
		chbPaquete.setTooltip(null);
		dateSiembra.setTooltip(null);
		dateSiembra30Dias.setTooltip(null);
		dateSiembra45Dias.setTooltip(null);
		dateSiembra60Dias.setTooltip(null);
		pbarProgresoCultivo.setTooltip(null);
		
	}
	
	public void toggleToolTip()
	{
		if(cmiTooltipMenu.isSelected())
		{
			activarTooltip();
		}else {
			desactivarTooltip();
		}
	}
	
	public void traducirControlesIngles()
	{
		lblHectareasCultivadas.setText("Cultivated Area (Hectare)");
		lblSemilla.setText("Seed");
		lblEspecie.setText("Specie");
	}
	
	public void traducirControlesEspanol()
	{
		lblHectareasCultivadas.setText("Hectareas Cultivadas");
		lblSemilla.setText("Semilla");
		lblEspecie.setText("Especie");
	}

}
