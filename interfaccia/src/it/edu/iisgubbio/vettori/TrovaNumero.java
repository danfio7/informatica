package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TrovaNumero extends Application{
	TextField tNumeri = new TextField();
	TextField tTrova = new TextField();
	Button pTrova = new Button("trova");
	Button pRipete = new Button("ripete");
	Label eRisultato = new Label("");
	Label eRipetizione = new Label("");
	String parti[];
	int numeri[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumeri,  0,  0);
	    griglia.add(tTrova,  0,  1);
	    griglia.add(pTrova, 0, 2);
	    griglia.add(eRisultato,  0,  3);
	    griglia.add(pRipete,  0,  4);
	    griglia.add(eRipetizione,  0,  5);
	    
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		pTrova.setOnAction(e -> trova());
		pRipete.setOnAction(e -> ripete());
	}
	public void trova() {
		
		int quantiNumeri=0;
		int ripete=0;
		int numeroTrovare = Integer.parseInt(tTrova.getText());
		String t = tNumeri.getText();
		if(t.equals("")) {
			eRisultato.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			for(int indice = 0; indice < parti.length; indice++) {
				if(numeri[indice]==numeroTrovare) {
					quantiNumeri++;
				}
		    }
			if(quantiNumeri>0) {
				eRisultato.setText("il numero "+ numeroTrovare + " è presente "+ quantiNumeri +" volte");
			}else {
				eRisultato.setText("il numero "+ numeroTrovare + " non è presente");
			}
			
			
			
		}
	}
	public void ripete() {
		int ripete=0;
		int indice;
		boolean ripetizionePresente=false;
		for(indice = 1; indice < parti.length && ripetizionePresente; indice++) {
			if(numeri[indice]==ripete) {
				ripetizionePresente=true;
				ripete=numeri[indice];
			}
	    }
		if(ripetizionePresente) {
			eRipetizione.setText("il numero "+ripete+ " si ripete di seguito");
		}else {
			eRipetizione.setText("non ci sono numeri che si ripetono di seguito");
		}
	}
			
			
			
		
	public static void main(String args[]){
		launch();
	}
}
