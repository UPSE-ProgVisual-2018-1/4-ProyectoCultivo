package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import helpers.Criterio;
import helpers.HelperBuscadorAgricultor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Agricultor;
import model.Genero;
import testMocker.ObjectMocker;

public class ControllerBuscadorAgricultor implements Initializable {

	@FXML ChoiceBox<String> chbCriterioBusquedaAgricultor;
	@FXML HBox boxDataBusqueda;
	@FXML Button btnBuscar;
	@FXML ListView<Agricultor> lstResultados;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObjectMocker.mockearListaAgricultores();
		List<String> criterios = crearCriterios();
		ObservableList<String> listaObservableCriterios = FXCollections.observableArrayList(criterios);
		chbCriterioBusquedaAgricultor.setItems(listaObservableCriterios);

		chbCriterioBusquedaAgricultor.setOnAction( e -> cargarControlesPorCriterio());


	}

	private void cargarControlesPorCriterio()
	{
		switch (chbCriterioBusquedaAgricultor.getSelectionModel().getSelectedItem()) {
		case "Nombre":
			boxDataBusqueda.getChildren().clear();
			Label labelNombre = new Label("Nombre de Agricultor");
			TextField txtNombreAgricultor = new TextField();
			boxDataBusqueda.getChildren().add(labelNombre);
			boxDataBusqueda.getChildren().add(txtNombreAgricultor);
			btnBuscar.setOnAction(e -> { 
//				List<Agricultor> listaAgricultoresEncontrados 
//				= buscarPorNombre(txtNombreAgricultor.getText());
//				ObservableList<Agricultor> listaObsevableAgricultor 
//				= FXCollections.observableArrayList(listaAgricultoresEncontrados);
//				lstResultados.setItems(listaObsevableAgricultor);
			});
			break;
		case "Cedula":
			boxDataBusqueda.getChildren().clear();
			Label labelCedula = new Label("Cedula de Agricultor");
			TextField txtCedulaAgricultor = new TextField();
			boxDataBusqueda.getChildren().add(labelCedula);
			boxDataBusqueda.getChildren().add(txtCedulaAgricultor);
			break;
		case "Telefono":
			boxDataBusqueda.getChildren().clear();
			Label labelTelefono = new Label("Telefono de Agricultor");
			TextField txtTelefonoAgricultor = new TextField();
			boxDataBusqueda.getChildren().add(labelTelefono);
			boxDataBusqueda.getChildren().add(txtTelefonoAgricultor);
			break;
		case "Genero":
			boxDataBusqueda.getChildren().clear();
			ChoiceBox<Genero> chbGeneroABuscar = new ChoiceBox<Genero>();
			ObservableList<Genero> listaObsevableGeneros = FXCollections.observableArrayList(Genero.values());
			chbGeneroABuscar.setItems(listaObsevableGeneros);
			boxDataBusqueda.getChildren().add(chbGeneroABuscar);
			btnBuscar.setOnAction(e -> { 
				List<Agricultor> listaAgricultoresEncontrados 
				= HelperBuscadorAgricultor.buscarAgricultorPorCriterio(ObjectMocker.listaAgricultoresMockeados,
						new Criterio() {
							
							@Override
							public boolean verificar(Agricultor a) {
								if(a.getGenero()==chbGeneroABuscar.getValue()) {
									return true;
								}else {
									return false;
								}
							}
						});
				ObservableList<Agricultor> listaObsevableAgricultor 
				= FXCollections.observableArrayList(listaAgricultoresEncontrados);
				lstResultados.setItems(listaObsevableAgricultor);
			});
			break;
		case "Rango Fechas Nacimiento":
			boxDataBusqueda.getChildren().clear();
			Label lblFechaInicio = new Label("Fecha Inicio");
			DatePicker dateFechaInicio = new DatePicker();
			Label lblFechaFin = new Label("Fecha Fin");
			DatePicker dateFechaFin = new DatePicker();
			boxDataBusqueda.getChildren().add(lblFechaInicio);
			boxDataBusqueda.getChildren().add(dateFechaInicio);
			boxDataBusqueda.getChildren().add(lblFechaFin);
			boxDataBusqueda.getChildren().add(dateFechaFin);
			btnBuscar.setOnAction(e -> {
				List<Agricultor> listaAgricultoresEncontrados 
				= HelperBuscadorAgricultor.buscarAgricultorPorCriterio(ObjectMocker.listaAgricultoresMockeados, 
						a -> {
							if(a.getFechaNacimiento()!=null 
									&& a.getFechaNacimiento().isBefore(dateFechaFin.getValue())
									&& a.getFechaNacimiento().isAfter(dateFechaInicio.getValue()))
							{
								return true;
								}
							else {
								return false;
							}
						} );
				ObservableList<Agricultor> listaObsevableAgricultor 
				= FXCollections.observableArrayList(listaAgricultoresEncontrados);
				lstResultados.setItems(listaObsevableAgricultor);
			});
			break;
		default:
			break;
		}
	}

//	private List<Agricultor> buscarPorGenero(Genero genero) {
//		List<Agricultor> listaAgricultoresEncontrados = new ArrayList<Agricultor>();
//		for(Agricultor a:ObjectMocker.listaAgricultoresMockeados)
//		{
//			if(a.getGenero().equals(genero))
//			{
//				listaAgricultoresEncontrados.add(a);
//			}
//			System.out.println(a);
//		}
//		return listaAgricultoresEncontrados;
//	}
//
//	private List<Agricultor> buscarPorNombre(String nombre)
//	{
//		List<Agricultor> listaAgricultoresEncontrados = new ArrayList<Agricultor>();
//		for(Agricultor a:ObjectMocker.listaAgricultoresMockeados)
//		{
//			if(a.getNombre().contains(nombre))
//			{
//				listaAgricultoresEncontrados.add(a);
//			}
//			System.out.println(a);
//		}
//		return listaAgricultoresEncontrados;
//	}
//	
//	private List<Agricultor> buscarPorFechas(LocalDate fechaInicio, LocalDate fechaFin)
//	{
//		List<Agricultor> listaAgricultoresEncontrados = new ArrayList<Agricultor>();
//		
//		System.out.println("Buscando entre:" + fechaInicio + " y " + fechaFin);
//		for(Agricultor a: ObjectMocker.listaAgricultoresMockeados)
//		{
//			
//			if(a.getFechaNacimiento()!=null && a.getFechaNacimiento().isAfter(fechaInicio) 
//					&&  a.getFechaNacimiento().isBefore(fechaFin))
//			{
//				listaAgricultoresEncontrados.add(a);
//				System.out.println("Agricultor Encontrado: " + a );
//			}
//		}
//		
//		return listaAgricultoresEncontrados;
//		
//	}

	private List<String> crearCriterios() {
		List<String> criterios = new ArrayList<String>();
		criterios.add("Nombre");
		criterios.add("Cedula");
		criterios.add("Telefono");
		criterios.add("Genero");
		criterios.add("Rango Fechas Nacimiento");
		return criterios;
	}
}
