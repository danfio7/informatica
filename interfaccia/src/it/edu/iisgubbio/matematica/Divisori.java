package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application{
	TextField cDivisori = new TextField("");
	Label eNum = new Label("numero");
	Button pDiv = new Button("divisori");
	Label eDiv = new Label("");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia);
		
		pDiv.setPrefWidth(300);
		
		griglia.add(eNum, 0, 0);
		griglia.add(cDivisori, 1, 0);
		griglia.add(pDiv, 0, 1, 2, 1);
		griglia.add(eDiv, 0, 2);
		
		finestra.setTitle("Interesse composto");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pDiv.setOnAction(e -> calcolaDivisori());
	      
	}
	public void calcolaDivisori() {
		String numTesto;
		String divTesto="";
		double num;
		numTesto = cDivisori.getText();
		num = Double.parseDouble(numTesto);
		for(int cont = 2 ; cont < num; cont++) {
			if(num % cont == 0) {
				 if(divTesto.equals("")) {
					 divTesto+= ""+cont;
				 } else {
					 divTesto += ", "+ cont;
				   }
				
			}
		}
		eDiv.setText(divTesto);
	}
	public static void main(String[] args) {
		 launch(args);
	}

}
