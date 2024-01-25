package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Primi extends Application{
	TextField cNum = new TextField("");
	Label eNum = new Label("numero");
	Button pCalcola = new Button("primi");
	Label ePrimi = new Label("");

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia);
		
		pCalcola.setPrefWidth(300);
		
		griglia.add(eNum, 0, 0);
		griglia.add(cNum, 1, 0);
		griglia.add(pCalcola, 0, 1, 2, 1);
		griglia.add(ePrimi, 0, 2);
		
		finestra.setTitle("Interesse composto");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setOnAction(e -> calcolaDivisori());
	      
	}
	public void calcolaDivisori() {
		String numTesto;
		double num;
		int div=0;
		numTesto = cNum.getText();
		num = Double.parseDouble(numTesto);
		for(int cont = 2 ; cont < num; cont++) {
			if(num % cont==0) {
				div= div +1;
			}
		}
		if(div>=1) {
			ePrimi.setText("Il numero non è primo");
		} else {
			ePrimi.setText("Il numero è primo");
		  }
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
