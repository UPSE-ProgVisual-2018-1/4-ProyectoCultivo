package controllers;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import model.Agricultor;

public class ControllerOrganizacion implements Initializable, ContollerBaseVistaFormulario {

	@FXML ListView<Agricultor> lstAgricultores;
	@FXML MediaView mvVideoOrganizacion;
	@FXML Button btnPlayPause;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		ObservableList<Agricultor> listaObservableAgricultor = 
				FXCollections.observableArrayList(mockearBaseAgricultores());
		lstAgricultores.setItems(listaObservableAgricultor);
		
		cargarVideo();
		playPauseTransition();
		
	}
	
	private List<Agricultor> mockearBaseAgricultores()
	{
		List<Agricultor> listaAgricultores = new ArrayList<Agricultor>();
		
		Agricultor a = new Agricultor("0123456789", "Garanon");
		Agricultor b = new Agricultor("1111111111", "Vijente Perez");
		
		listaAgricultores.add(a);
		listaAgricultores.add(b);
		return listaAgricultores;
		
	}

	public void guardar()
	{
		
	}
	
	public void cancelar()
	{
		
	}
	
	public void cargarVideo()
	{
		//Media: Representa el video (como el dvd fisico - el disco)
		String direccion = "resources/videos/big_buck_bunny.mp4";
		File f = new File(direccion);
		if(f.exists())
		{
			System.out.println(f.getAbsolutePath());
			URI uri = f.toURI();
			System.out.println(uri.toString());
			Media video = new Media(uri.toString());
			
			//MediaPlayer: Vendria a ser como un Reproductor de DVD (el aparato).
			MediaPlayer mp = new MediaPlayer(video);
			mp.setAutoPlay(false);
			
			//Conectar el Reproductor (MediaPlayer) con el Televisor (MediaView)
			this.mvVideoOrganizacion.setMediaPlayer(mp);
		}else {
			System.err.println("Archivo no encontrado. WTF!");
		}
		
	}
	
	public void playVideo()
	{
		mvVideoOrganizacion.getMediaPlayer().play();
	}
	
	public void stopVideo()
	{
		mvVideoOrganizacion.getMediaPlayer().stop();
		btnPlayPause.setText("Play");
	}
	
	public void pauseVideo()
	{
		mvVideoOrganizacion.getMediaPlayer().pause();;
	}
	
	public void playPauseTransition()
	{
		btnPlayPause.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				Status estadoMediaPlayer = mvVideoOrganizacion.getMediaPlayer().getStatus();	
				
				if(estadoMediaPlayer==Status.PAUSED)
				{
					btnPlayPause.setText("Pause");
					playVideo();
				}
				
				if(estadoMediaPlayer==Status.PLAYING)
				{
					btnPlayPause.setText("Play");
					pauseVideo();
				}
				
				if(estadoMediaPlayer==Status.READY)
				{
					btnPlayPause.setText("Pause");
					playVideo();
				}
				
				if(estadoMediaPlayer==Status.STOPPED)
				{
					btnPlayPause.setText("Pause");
					playVideo();
				}
			}
		});
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
