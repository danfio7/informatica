package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Coordinate extends Application{
	int raggio=180;
	double proporzione=0;
	double x=0;
	double y=0;
	Pane spazio = new Pane();
	Circle pallinoCentrale = new Circle(7);
	public void start(Stage finestra) {
		spazio.getChildren().add(pallinoCentrale);
		pallinoCentrale.setCenterX(200);
		pallinoCentrale.setCenterY(200);
		for(double angolo=0; angolo < 360; angolo+=10) {
			Circle pallino = new Circle(7);
			proporzione=(angolo*(2*Math.PI))/360;
			spazio.getChildren().add(pallino);
	        x=200+raggio * (Math.cos(proporzione));
	        y=200+raggio * (Math.sin(proporzione));
	        pallino.setCenterX(x);
			pallino.setCenterY(y);
			System.out.println("x="+x+" y="+y);
			
	    }
	    
		
	    
	    Scene scene = new Scene(spazio,400,400);
	    
	    finestra.setTitle("Coordinate"); 
		finestra.setScene(scene);
		finestra.show();
		
		//x=50
		//y=86,6
	}
	public static void main(String args[]){
		launch();
	}
}
