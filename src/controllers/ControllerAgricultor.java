package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Agricultor;
import model.Genero;

public class ControllerAgricultor {

	@FXML TextField txtCedula;
	@FXML TextField txtNombre;
	//@FXML ChoiceBox<Genero> chbGenero;
	@FXML TextField txtTelefono;
	@FXML GridPane gridDatos;
	@FXML ToggleGroup tggGenero;
	@FXML RadioButton rbMasculino;
	@FXML RadioButton rbFemenino;
	@FXML RadioButton rbOtro;
	@FXML RadioButton rbNoDigo;
	
	private Agricultor tempAgricultor;
	
	public void initialize()
	{ 
		ObservableList<Genero> generos = FXCollections.observableArrayList(Genero.values());
		//chbGenero.setItems(generos);
		ToggleGroup toggleGroupOpciones = new ToggleGroup();
		RadioButton rbOpcion1 = new RadioButton("Opcion 1");
		RadioButton rbOpcion2 = new RadioButton("Opcion 2");
		rbOpcion1.setToggleGroup(toggleGroupOpciones);
		rbOpcion2.setToggleGroup(toggleGroupOpciones);
		rbOpcion1.setSelected(true);
		gridDatos.add(rbOpcion1, 1, 6);
		gridDatos.add(rbOpcion2, 1, 7);
		
	}
	
	public void guardar()
	{
		String cedula = txtCedula.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		//Genero genero = chbGenero.getValue();
		Toggle generoToggle = tggGenero.getSelectedToggle();
		Genero genero = Genero.PREFIERO_NO_DECIR;
		if(generoToggle==rbMasculino)
		{
			genero = Genero.MASCULINO;
		}
		if(generoToggle==rbFemenino)
		{
			genero = Genero.FEMENINO;
		}
		if(generoToggle==rbOtro)
		{
			genero = Genero.OTRO;
		}
		if(generoToggle==rbNoDigo)
		{
			genero = Genero.PREFIERO_NO_DECIR;
		}
		tempAgricultor = new Agricultor(cedula, nombre);
		tempAgricultor.setTelefono(telefono);
		tempAgricultor.setGenero(genero);
		System.out.println("Objeto Agricultor Lleno!");
		System.out.println(tempAgricultor.imprimirCompleto());
	}
	
	public void cancelar()
	{
		System.out.println("salir");
		System.exit(0);
	}
}
