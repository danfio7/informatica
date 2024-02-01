package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RicercaBinaria extends Application{
	TextField tNumeri = new TextField();
	TextField tTrova = new TextField();
	Button pTrova = new Button("trova");
	Label eRisultato = new Label("");
	String parti[];
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumeri,  0,  0);
	    griglia.add(tTrova,  0,  1);
	    griglia.add(pTrova, 0, 2);
	    griglia.add(eRisultato,  0,  3);
	        
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		pTrova.setOnAction(e -> trova());
	}
	public void trova() {
		int numeri[];
		int inizio = 0;
		int metà;
		int cercato = Integer.parseInt(tTrova.getText());
		int fine;
		boolean trovato=false;
		String t = tNumeri.getText();
		if(t.equals("")) {
			eRisultato.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
			fine = (numeri.length)-1;
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			while(inizio<=fine) {
				metà=(fine+inizio)/2;
				if(numeri[metà]==cercato) {
					trovato=true;
					break;
				}else {
					if(numeri[metà]<cercato){
						inizio=metà+1;
					}else {
						fine=metà-1;
					}
				}
			}
		}
		if(trovato) {
			eRisultato.setText("il numero "+ cercato+" è presente");
		}else {
			eRisultato.setText("il numero "+ cercato+" non è presente");
		}
	}
	public static void main(String args[]){
		launch();
	}
}
