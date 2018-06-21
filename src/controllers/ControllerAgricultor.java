package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Agricultor;
import model.Genero;

public class ControllerAgricultor {

	@FXML TextField txtCedula;
	@FXML TextField txtNombre;
	@FXML ChoiceBox<Genero> chbGenero;
	@FXML TextField txtTelefono;
	
	private Agricultor tempAgricultor;
	
	public void initialize()
	{ 
		ObservableList<Genero> generos = FXCollections.observableArrayList(Genero.values());
		chbGenero.setItems(generos);
	}
	
	public void guardar()
	{
		String cedula = txtCedula.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		Genero genero = chbGenero.getValue();
		tempAgricultor = new Agricultor(cedula, nombre);
		tempAgricultor.setTelefono(telefono);
		tempAgricultor.setGenero(genero);
		System.out.println("Objeto Agricultor Lleno!");
		System.out.println(tempAgricultor);
	}
	
	public void cancelar()
	{
		System.out.println("salir");
		System.exit(0);
	}
}
