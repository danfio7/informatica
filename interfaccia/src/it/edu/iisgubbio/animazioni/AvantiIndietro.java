package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AvantiIndietro extends Application{
	Circle pallino;
	int x=0;
	boolean avanti=true;
	Timeline timeline;
	Pane quadro = new Pane();
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		griglia.add(quadro, 0, 0);

		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);

		Scene scene = new Scene(griglia,300,200);

		finestra.setTitle("Timer!"); 
		finestra.setScene(scene);
		finestra.show();

		timeline = new Timeline(new KeyFrame(
				Duration.millis(20), 
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		pallino = new Circle(7);
		quadro.getChildren().add(pallino);
		pallino.setCenterY(20);
		pallino.setCenterX(x);
		
		
		
		
	}
	private void aggiornaTimer(){ 
		if(x==290) {
			avanti=false;
		}
		if(x==0) {
			avanti=true;
		}
		if(avanti) {
			pallino.setCenterX(x++);
		} else {
			pallino.setCenterX(x--);
		}
		System.out.println(x);
		
		
	}

	public static void main(String args[]){
		launch();
	}
}
