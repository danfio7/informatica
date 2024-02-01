package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InvertiMescola extends Application{
		TextField tNumeri = new TextField();
		TextField tTrova = new TextField();
		Button pInverti = new Button("inverti");
		Button pMescola = new Button("mescola");
		Label eInvertito = new Label("");
		Label eMescolato = new Label("");
		String parti[];
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumeri,  0,  0, 2, 1);
		griglia.add(pInverti,  0,  1);
		griglia.add(pMescola, 1, 1);
		griglia.add(eInvertito,  0,  2, 2, 1);
		griglia.add(eMescolato,  0,  3, 2, 1);
		        
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		    
		Scene scene = new Scene(griglia,260,150);
		    
		finestra.setTitle("Somma"); 
		finestra.setScene(scene);
		finestra.show();
			
		pInverti.setOnAction(e -> inverti());
		pMescola.setOnAction(e -> mescola());
	}
	public void inverti() {
		int numeri[];
		int indice;
		int i=0;
		int scambiatore=0;
		String vettore="";
		String t = tNumeri.getText();
		if(t.equals("")) {
			eInvertito.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
		for(indice = 0; indice < parti.length; indice++) {
			numeri[indice] = Integer.parseInt(parti[indice]);
		}
		
		for(i=0; i<(numeri.length)/2; i++) {
			scambiatore=numeri[i];
			numeri[i]=numeri[numeri.length-1-i];
			numeri[numeri.length-1-i]=scambiatore;
			
		}
		for(indice = 0; indice < parti.length; indice++) {
			vettore+=" "+numeri[indice];
		}
		eInvertito.setText(vettore);
		}
	}
	public void mescola() {
		int numeri[];
		int indice;
		int numeroRandom=0;
		int lunghezza=0;
		int a=0;
		String vettoreStampato="";
		String t = tNumeri.getText();
		if(t.equals("")) {
			eInvertito.setText("inserisci i numeri");
		}else {
			parti =t.split(" ");
			numeri = new int [parti.length];
		for(indice = 0; indice < parti.length; indice++) {
			numeri[indice] = Integer.parseInt(parti[indice]);
		}
		lunghezza=numeri.length;
		indice=0;
		for(int indice2 = 0; indice2 < parti.length; indice2++) {
			numeroRandom=(int)(Math.random()*lunghezza);
			a=numeri[indice2];
			numeri[indice2]=numeri[numeroRandom];
			numeri[numeroRandom]=a;
		}
		for(indice = 0; indice < parti.length; indice++) {
			vettoreStampato+=" "+numeri[indice];
		}
		
		eMescolato.setText(vettoreStampato);
		}
	}
	public static void main(String args[]){
			launch();
	}

}

