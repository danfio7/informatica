package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Pallini2 extends Application{

	public void start(Stage finestra) throws Exception {
		Pane quadro = new Pane();
		int pallinoFinale= 120;
		int y;
		for(int x = 20 ; x < pallinoFinale; x+=20) {
			for(y = 20 ; y < pallinoFinale; y+=20) {
				Circle pallino = new Circle(7);
				quadro.getChildren().add(pallino);
				pallino.setCenterX(x);
				pallino.setCenterY(y);
			}
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
