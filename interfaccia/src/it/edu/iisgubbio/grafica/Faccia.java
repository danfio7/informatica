package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Faccia extends Application{
	
	public void start(Stage finestra) throws Exception {
		Pane quadro = new Pane();
		Circle faccia = new Circle(100);
		faccia.setFill( Color.PINK );
		faccia.setCenterX(100);
		faccia.setCenterY(100);
		Circle occhioDx = new Circle(25);
		occhioDx.setCenterX(50);
		occhioDx.setCenterY(70);
		Circle occhioSx = new Circle(25);
		occhioSx.setCenterX(150);
		occhioSx.setCenterY(70);
		
		Line boccaDx = new Line(100, 130, 50, 160);
		Line boccaSx = new Line(100, 130, 150, 160);
		Line stanghettaCentrale = new Line(65, 70, 135, 70);
		stanghettaCentrale.setStrokeWidth(3);
		boccaDx.setStrokeWidth(3);
		boccaSx.setStrokeWidth(3);
		boccaDx.setStroke(Color.RED);
		boccaSx.setStroke(Color.RED);
		
		quadro.getChildren().add(faccia);
		quadro.getChildren().add(boccaDx);
		quadro.getChildren().add(boccaSx);
		quadro.getChildren().add(occhioSx);
		quadro.getChildren().add(occhioDx);
		quadro.getChildren().add(stanghettaCentrale);
		
		
		Scene scena = new Scene(quadro, 200, 200);
		
		finestra.setTitle("Fattoriale");
	    finestra.setScene(scena);
	    finestra.show();
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
