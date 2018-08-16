package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Agricultor;
import model.Genero;
import testMocker.ObjectMocker;

public class ControllerAgricultor implements ContollerBaseVistaFormulario{

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
	@FXML Button btnBuscar;
	@FXML Button btnBuscarNombre;
	
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
		ObjectMocker.mockearListaAgricultores();
		
		btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Agricultor agricultorEncontrado = buscarPorCedula(txtCedula.getText());
				if(agricultorEncontrado!=null)
				{
					cargar(agricultorEncontrado);
				}else {
					System.err.println("Opps. No encontrado.");
					limpiar();
				}
				
			}

		});
		
		btnBuscarNombre.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Agricultor agricultorEncontrado = buscarPorNombre(txtNombre.getText());
				if(agricultorEncontrado!=null)
				{
					cargar(agricultorEncontrado);
				}else {
					System.err.println("Opps. No encontrado.");
					limpiar();
				}
				
			}

		});
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
		
		ObjectMocker.listaAgricultoresMockeados.add(tempAgricultor);
		System.out.println("Ahora la lista de agricultores es:");
		System.out.println(ObjectMocker.listaAgricultoresMockeados);
	}
	
	private void cargar(Agricultor agricultorEncontrado) {
		txtCedula.setText(agricultorEncontrado.getCedula());
		txtNombre.setText(agricultorEncontrado.getNombre());
		txtTelefono.setText(agricultorEncontrado.getTelefono());
		
		switch (agricultorEncontrado.getGenero()) {
		case MASCULINO:
			rbMasculino.setSelected(true);
			break;
		case FEMENINO:
			rbFemenino.setSelected(true);
			break;
		case OTRO:
			rbOtro.setSelected(true);
			break;
		case PREFIERO_NO_DECIR:
			rbNoDigo.setSelected(true);
			break;

		default:
			rbNoDigo.setSelected(true);
			break;
		}
		
	}
	
	private Agricultor buscarPorCedula(String cedula)
	{
		Agricultor agricultorBusqueda = null;
		System.out.println("Cedula a Buscar:" + cedula);
		for(Agricultor a: ObjectMocker.listaAgricultoresMockeados)
		{
			
			if(a.getCedula().equals(cedula))
			{
				agricultorBusqueda = a;
				System.out.println("Agricultor Encontrado: " + a );
				break;
			}
		}
		
		return agricultorBusqueda;
		
	}
	
	private Agricultor buscarPorNombre(String nombre)
	{
		Agricultor agricultorBusqueda = null;
		System.out.println("Nombre a Buscar:" + nombre);
		for(Agricultor a: ObjectMocker.listaAgricultoresMockeados)
		{
			
			if(a.getNombre().equals(nombre))
			{
				agricultorBusqueda = a;
				System.out.println("Agricultor Encontrado: " + a );
				break;
			}
		}
		
		return agricultorBusqueda;
		
	}
	
	public void cancelar()
	{
		System.out.println("salir");
		System.exit(0);
	}

	@Override
	public void limpiar() {
		txtCedula.clear();
		txtNombre.clear();
		txtTelefono.clear();
		tggGenero.selectToggle(rbNoDigo);
	}

	@Override
	public void borrar() {
		// TODO Auto-generated method stub
		
	}
}
