package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Somma extends Application{
	TextField tNum = new TextField();
	Button pSomma = new Button("somma");
	Label eRisultato = new Label("");
	Button pVerifica = new Button("verifica");
	Label eCrescente = new Label("");
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNum,  0,  0);
	    griglia.add(pSomma,  0,  1);
	    griglia.add(eRisultato, 0, 3);
	    griglia.add(pVerifica,  0,  2);
	    griglia.add(eCrescente, 0, 4);
	    
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
		
		pSomma.setOnAction(e -> somma());
		pVerifica.setOnAction(e -> verifica());
	}

	public void somma() {
		String parti[];
		int numeri[];
		String t = tNum.getText();
		if(t.equals("")) {
			eRisultato.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
			int somma = 0;
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
		    }
			for(int indice = 0; indice < parti.length; indice++) {
				somma += numeri[indice];
		    }
			eRisultato.setText(""+somma);
			
			
		}
	}
		public void verifica() {
			String parti[];
			int numeri[];
			String t = tNum.getText();
			parti =t.split(" ");
			boolean coppiaErrata=false;
			int coppieErrate=0;
			numeri = new int [parti.length];
			for(int indice = 0; indice < parti.length; indice++) {
				numeri[indice] = Integer.parseInt(parti[indice]);
				
		    }
			for(int indice2 = 0; indice2 < parti.length-1; indice2++) {
				if(numeri[indice2]>numeri[indice2+1]) {
					coppiaErrata=true;
					coppieErrate++;
				}
		        
		    }
			if(coppiaErrata) {
				if(coppieErrate==(parti.length-1)) {
					eCrescente.setText("è decrescente");
				}else {
					eCrescente.setText("non è crescente");
				}
				System.out.println(coppieErrate);
				System.out.println(parti.length-1);
				
			}else {
				eCrescente.setText("è crescente");
			}
				
			
			
	}
	public static void main(String args[]){
		launch();
	}
}
