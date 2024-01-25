package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rimbalzo2 extends Application{
	Pane quadro = new Pane();
	Timeline timeline;
	int cont=0;
	boolean sopra=true;
	double xCoordinate=0;
	double yCoordinate=150;
	boolean avanti;
	Circle pallino = new Circle(7);
	int random=1;
	int xRandom;
	public void start(Stage finestra) throws Exception {
		
		Scene scena = new Scene(quadro, 400, 300);
		
		finestra.setTitle("Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    quadro.getChildren().add(pallino);
	    
	    
		
	    
	    timeline = new Timeline(new KeyFrame(
				Duration.millis(10),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.play();
	}
	private void aggiornaTimer(){
		if(xCoordinate>=400) {
			avanti=false;
		}
		if(xCoordinate<=0) {
			avanti=true;
		}
		if(avanti==false) {
			pallino.setCenterX(xCoordinate--);
		} else {
			pallino.setCenterX(xCoordinate++);
		}
		if(yCoordinate>=300) {
			sopra=false;
		}
		if(yCoordinate<=0) {
			sopra=true;
		}
		if(sopra==false) {
			pallino.setCenterY(yCoordinate--);
		} else {
			pallino.setCenterY(yCoordinate++);
		}		
	}
	public static void main(String args[]){
		launch();
	}
}