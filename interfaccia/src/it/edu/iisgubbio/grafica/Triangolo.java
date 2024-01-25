package it.edu.iisgubbio.grafica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Triangolo extends Application{
	TextField cNum = new TextField("");
	Label eNum = new Label("numero");
	Button pVai = new Button("vai!");
	Pane quadro = new Pane();
	int y;
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		griglia.add(eNum, 0, 0);
		griglia.add(cNum, 1, 0);
		griglia.add(pVai, 2, 0);
		griglia.add(quadro, 0, 1, 3, 1);
		
		Scene scena = new Scene(griglia, 400, 400);
		
		finestra.setTitle("Pallini");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pVai.setOnAction(e -> inserisciPallini());
	}
	public void inserisciPallini() {
		String numTesto;
		int numX;
		int numY;
		quadro.getChildren().clear();
		numTesto = cNum.getText();
		numX = Integer.parseInt(numTesto);
		numY = Integer.parseInt(numTesto);
		for(int y = 20 ; y <=(numY*20) ; y=y+20) {
			for(int x = 20 ; x <=(numX*20); x+=20) {
				Circle pallino = new Circle(7);
				quadro.getChildren().add(pallino);
				pallino.setCenterX(x);
				pallino.setCenterY(y);
				
			}
			numX--;
		}
		
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
