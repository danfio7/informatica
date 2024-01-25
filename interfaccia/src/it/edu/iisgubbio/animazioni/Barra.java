package it.edu.iisgubbio.animazioni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Barra extends Application{
	String appare="";
	String simboloA;
	String tempoTesto;
	double t;
	int cont=0;
	TextField cSimbolo = new TextField("");
	TextField cMillisec = new TextField("");
	Label eSimbolo = new Label("simbolo");
	Label eMillisec = new Label("millisecondi");
	Button pVia = new Button("via");
	Label eAppare = new Label("");
	Timeline timeline;
	boolean avanti=true;
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		griglia.add(eSimbolo,  0,  0);
		griglia.add(cSimbolo,  1,  0);
		griglia.add(eMillisec,  0,  1);
		griglia.add(cMillisec,  1,  1);
		griglia.add(pVia,  2,  0, 1, 2);
		griglia.add(eAppare,  0,  2, 3, 1);
		
		

		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		
		Scene scene = new Scene(griglia);

		finestra.setTitle("Timer!"); 
		finestra.setScene(scene);
		finestra.show();

		pVia.setPrefHeight(100);
		pVia.setOnAction(e -> timeline());
		
	}
	public void timeline() {
		tempoTesto = cMillisec.getText();
		t = Double.parseDouble(tempoTesto);
		simboloA = cSimbolo.getText();
		timeline = new Timeline(new KeyFrame(
				Duration.millis(t),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
	}
	private void aggiornaTimer(){
		String appare="";
		
		for(int contaSimboli=1; contaSimboli<=cont; contaSimboli++) {
			appare+=simboloA;
		}
		if(cont==20) {
			avanti=false;
		}
		if(cont==0) {
			avanti=true;
		}
		if(avanti==false) {
			cont--;
		} else {
			cont++;
		}
		
		eAppare.setText(appare);
	}

	public static void main(String args[]){
		launch();
	}
}
