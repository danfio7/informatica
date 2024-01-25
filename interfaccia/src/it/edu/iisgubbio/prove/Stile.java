package it.edu.iisgubbio.prove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Stile extends Application{

	TextField cBase = new TextField("");
	TextField cAltezza = new TextField("");
	Label ePerimetro = new Label("perimetro");
	Label eArea = new Label("area");
	Label eErrore = new Label("");
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia, 250, 130);
		scena.getStylesheets().add("it/edu/iisgubbio/prove/Stile.css");
		
		Label eBase = new Label("base");
		Label eAltezza = new Label("altezza");
		
		ePerimetro.setId("perimetro");
		
		griglia.add(eBase, 0, 0);
		griglia.add(eAltezza, 0, 1);
		griglia.add(cBase, 1, 0);
		griglia.add(cAltezza, 1, 1);
		griglia.add(ePerimetro, 1, 3);
		griglia.add(eArea, 0, 3);
		griglia.add(eErrore, 0, 4);
		
		finestra.setTitle("CSS");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    cBase.setOnAction(e -> calcolaAreaPerimetro());
	    cAltezza.setOnAction(e -> calcolaAreaPerimetro());
	    
	}
	public void calcolaAreaPerimetro() {
		String baseStringa;
		String altezzaStringa;
		double base;
		double altezza;
		double perimetro;
		double area;
		baseStringa = cBase.getText();
		base = Double.parseDouble(baseStringa);
		altezzaStringa = cAltezza.getText();
		altezza = Double.parseDouble(altezzaStringa);
		if(baseStringa!="" || altezzaStringa!=""){
			perimetro = (base + altezza) * 2;
			ePerimetro.setText("perimetro= "+perimetro);
			area = base * altezza;
			eArea.setText("area= "+area);
		} else {
			eErrore.setText("Una delle caselle è vuota");
		  }
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
