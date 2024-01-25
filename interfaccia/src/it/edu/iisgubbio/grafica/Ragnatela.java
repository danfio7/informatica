package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class Ragnatela extends Application{
	public void start(Stage finestra) throws Exception {
		Pane quadro = new Pane();
		int x;
		for(x = 200 ; x >= 0; x=x-20) {
			Line linea = new Line(0, 200-x,x+20, 0);
			quadro.getChildren().add(linea);
		}
		
		Scene scena = new Scene(quadro, 200, 200);
		
		finestra.setTitle("Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
