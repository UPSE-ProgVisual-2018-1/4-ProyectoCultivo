package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ControllerInicial implements Initializable {

	@FXML ImageView imgCultivo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Image imagenCultivo = new Image("cultivo.jpeg");
		
		imgCultivo.setPreserveRatio(true);
		imgCultivo.setSmooth(true);
		
		Rectangle2D vp = new Rectangle2D(100,100, imgCultivo.getParent().getLayoutX(), imgCultivo.getParent().getLayoutY());
		imgCultivo.setViewport(vp);
		imgCultivo.setRotate(45);
		imgCultivo.setFitWidth(vp.getMaxX());
		imgCultivo.setImage(imagenCultivo);
	}

}
