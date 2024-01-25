package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pallini extends Application{
	public void start(Stage finestra) throws Exception {
		Pane quadro = new Pane();
		int pallinoFinale= 280;
		for(int cont = 10 ; cont < pallinoFinale; cont+=20) {
			Circle pallino = new Circle(7);
			quadro.getChildren().add(pallino);
			pallino.setCenterX(cont);
			pallino.setCenterY(20);
		}
		
		Scene scena = new Scene(quadro, 400, 400);
		
		finestra.setTitle("Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
