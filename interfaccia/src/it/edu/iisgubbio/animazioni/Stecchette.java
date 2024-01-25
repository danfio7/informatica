package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Stecchette extends Application{
	Pane quadro = new Pane();
	Rectangle stanghetta1 = new Rectangle();
	Rectangle stanghetta2 = new Rectangle();
	public void start(Stage finestra) throws Exception {
		
		Scene scena = new Scene(quadro, 400, 300);
		
		finestra.setTitle("Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    quadro.getChildren().add(stanghetta1);
	    stanghetta1.setWidth(10);
	    stanghetta1.setHeight(100);
	    stanghetta1.setX(10);
	    stanghetta1.setY(90);
	    quadro.getChildren().add(stanghetta2);
	    stanghetta2.setWidth(10);
	    stanghetta2.setHeight(100);
	    stanghetta2.setX(380);
	    stanghetta2.setY(90);
	    
	    
	    scena.setOnKeyPressed(e -> pigiato(e));
	}
	private void pigiato(KeyEvent evento) {
		if (evento.getText().equals("q")) {
			stanghetta1.setY(stanghetta1.getY() - 2);
		}
		if (evento.getText().equals("z")) {
			stanghetta1.setY(stanghetta1.getY() + 2);
		}
		if (evento.getCode() == KeyCode.UP) {
			stanghetta2.setY(stanghetta2.getY() - 2);
		}
		if (evento.getCode() == KeyCode.DOWN) {
			stanghetta2.setY(stanghetta2.getY() + 2);
		}
	}
	public static void main(String args[]){
		launch();
	}
}
