package it.edu.iisgubbio.esercizi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Span extends Application{
	Button pCiao = new Button("ciao");
	Button pDueColonne = new Button("2 colonne");
	Button pA = new Button("A");
	Button pB = new Button("B");
	public void start(Stage finestra) throws Exception {
		
		
		GridPane griglia = new GridPane();

		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		pCiao.setMaxWidth(180);
		pCiao.setMaxHeight(60);
		
		pCiao.setAlignment(Pos.CENTER);
		
		Scene scena = new Scene(griglia);
		
		finestra.setTitle("span");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    griglia.add(pCiao, 1, 0, 1, 2);
	    griglia.add(pDueColonne, 2, 0, 2, 1);
	    griglia.add(pA, 2, 1);
	    griglia.add(pB, 3, 1);
		
	    
	}
	public static void main(String[] args) {
		 launch(args);
	}
	
}

