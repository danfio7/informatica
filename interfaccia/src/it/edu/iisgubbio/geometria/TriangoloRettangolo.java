package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application{
	TextField cCateto1 = new TextField("");
	TextField cCateto2 = new TextField("");
	TextField cIpotenusa = new TextField("");
	Button pCateto1 = new Button("calcola cateto 1");
	Button pCateto2 = new Button("calcola cateto 2");
	Button pIpotenusa = new Button("calcola ipotenusa");
	Label eCateto1 = new Label("cateto 1");
	Label eCateto2 = new Label("cateto 2");
	Label eIpotenusa = new Label("ipotenusa");
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 470, 120);
		
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		finestra.setTitle("Triangolo Rettangolo");
	    finestra.setScene(scena);
	    finestra.show();
	   
		
		pCateto1.setPrefWidth(200);
		pCateto2.setPrefWidth(200);
		pIpotenusa.setPrefWidth(200);

		
		griglia.add(eCateto1, 0, 0);
		griglia.add(eCateto2, 0, 1);
		griglia.add(eIpotenusa, 0, 2);
		griglia.add(cCateto1, 1, 0);
		griglia.add(cCateto2, 1, 1);
		griglia.add(cIpotenusa, 1, 2);
		griglia.add(pCateto1, 2, 0);
		griglia.add(pCateto2, 2, 1);
		griglia.add(pIpotenusa, 2, 2);
		
		pCateto1.setOnAction(e -> calcolaCateto1());
		pCateto2.setOnAction(e -> calcolaCateto2());
		pIpotenusa.setOnAction(e -> calcolaIpotenusa());
	     
	}
	public void calcolaCateto1() {
		String cateto2;
		String ipotenusa;
		double cat2;
		double ipot;
		double cat1;
		cateto2 = cCateto2.getText();
		cat2 = Double.parseDouble(cateto2);
		ipotenusa = cIpotenusa.getText();
		ipot = Double.parseDouble(ipotenusa);
		cat1 = (Math.sqrt(((ipot * ipot) - (cat2 * cat2))));
		cCateto1.setText(""+cat1);
	}
	public void calcolaCateto2() {
		String cateto1;
		String ipotenusa;
		double cat1;
		double ipot;
		double cat2;
		cateto1 = cCateto1.getText();
		cat1 = Double.parseDouble(cateto1);
		ipotenusa = cIpotenusa.getText();
		ipot = Double.parseDouble(ipotenusa);
		cat2 = (Math.sqrt(((ipot * ipot) - (cat1 * cat1))));
		cCateto2.setText(""+cat2);
	}
	public void calcolaIpotenusa() {
		String cateto1;
		String cateto2;
		double cat1;
		double ipot;
		double cat2;
		cateto1 = cCateto1.getText();
		cat1 = Double.parseDouble(cateto1);
		cateto2 = cCateto2.getText();
		cat2 = Double.parseDouble(cateto2);
		ipot = (Math.sqrt(((cat1 * cat1) + (cat2 * cat2))));
		cIpotenusa.setText(""+ipot);
	}
	public static void main(String[] args) {
		 launch(args);
	}

}
