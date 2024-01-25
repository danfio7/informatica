package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fattoriale extends Application{
	TextField cFattoriale = new TextField("");
	Button pCalcola = new Button("!");
	Label eFattoriale = new Label("");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia, 270, 50);
		
		griglia.add(cFattoriale, 0, 0);
		griglia.add(pCalcola, 1, 0);
		griglia.add(eFattoriale, 2, 0);
		
		finestra.setTitle("Fattoriale");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setOnAction(e -> calcolaDivisori());
	}
	public void calcolaDivisori() {
		String fattorialeTesto;
		int fattoriale, fatt = 1;
		fattorialeTesto = cFattoriale.getText();
		fattoriale = Integer.parseInt(fattorialeTesto);
		for(int cont = 1 ; cont <= fattoriale; cont++) {
			fatt = fatt * cont;
		}
		eFattoriale.setText(""+ fatt);
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
