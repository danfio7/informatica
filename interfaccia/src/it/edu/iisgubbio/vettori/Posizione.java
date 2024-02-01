package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Posizione extends Application{
	TextField tNumeri = new TextField();
	TextField tTrova = new TextField();
	Button pPosizione = new Button("pos");
	Label eRisultato = new Label("");
	String parti[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumeri,  0,  0, 2, 1);
	    griglia.add(tTrova,  0,  1);
	    griglia.add(pPosizione, 1, 1);
	    griglia.add(eRisultato,  0,  2, 2, 1);
	        
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,260,150);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		pPosizione.setOnAction(e -> trova());
	}
	public void trova() {
		int numeri[];
		int numeroTrovare = Integer.parseInt(tTrova.getText());
		int posizione=0;
		boolean trovato=false;
		String t = tNumeri.getText();
		if(t.equals("")) {
			eRisultato.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			for(int indice = 0; indice < parti.length && !trovato; indice++) {
				if(numeri[indice]==numeroTrovare) {
					trovato=true;
					posizione=indice;
				}
		    }
			if(trovato) {
				eRisultato.setText("il numero "+ numeroTrovare + " si trova nella posizione "+ posizione);
			}else {
				eRisultato.setText("il numero non è presente nel vettore");
			}
		}
	}
	public static void main(String args[]){
		launch();
	}
}
