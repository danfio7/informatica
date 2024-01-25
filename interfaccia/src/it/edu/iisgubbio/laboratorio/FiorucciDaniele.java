package it.edu.iisgubbio.laboratorio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FiorucciDaniele extends Application{
	TextField cN = new TextField("");
	TextField cM = new TextField("");
	Button pCalcolaSomma = new Button("calcola somma");
	Button pContaPrimi = new Button("quanti primi");
	Button pFattoriale = new Button("disposizioni");
	Label eSomma = new Label("");
	Label ePrimi = new Label("");
	Label eFattoriale = new Label("");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 200, 300);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		finestra.setTitle("Verifica");
	    finestra.setScene(scena);
	    finestra.show();
	   	
	    griglia.add(cN, 0, 0);
		griglia.add(cM, 0, 1);
		griglia.add(pCalcolaSomma, 0, 2);
		griglia.add(pContaPrimi, 0, 3);
		griglia.add(pFattoriale, 0, 4);
		griglia.add(eSomma, 0, 5);
		griglia.add(ePrimi, 0, 6);
		griglia.add(eFattoriale, 0, 7);
		
		pCalcolaSomma.setOnAction(e -> somma());
		pContaPrimi.setOnAction(e -> primi());
		pFattoriale.setOnAction(e -> fattoriale());
	}
	public void somma()      {
		String nTesto;
		String mTesto;
		int n;
		int m;
		int mag;
		int min;
		int somma=0;
		nTesto = cN.getText();
		n = Integer.parseInt(nTesto);
		mTesto = cM.getText();
		m = Integer.parseInt(mTesto);
		if (n>m) {
			mag=n;
			min=m;
		} else {
			mag=m;
			min=n;
		}
		for(int cont = min ; cont <= mag; cont++) {
			somma+=cont;
		}
		eSomma.setText(""+somma);
	}
	public void primi()      {
		String nTesto;
		String mTesto;
		int n;
		int m;
		int mag;
		int min;
		int nPrimi=0;
		int divisori=0;
		boolean primi=false;
		nTesto = cN.getText();
		n = Integer.parseInt(nTesto);
		mTesto = cM.getText();
		m = Integer.parseInt(mTesto);
		if (n>m) {
			mag=n;
			min=m;
		} else {
			mag=m;
			min=n;
		}
		for(int cont = min ; cont <= mag; cont++) {
			for(int contDiv= 1 ; contDiv <= cont; contDiv++) {
				if (cont % contDiv == 0) {
					divisori=divisori+1;
				}
				
			}
			if(divisori>2) {
				primi=false;
			} else {
				primi=true;
			}
			if(primi==true) {
				nPrimi=nPrimi+1;
			}
		}
		ePrimi.setText(""+nPrimi);
		
		
	}
	public void fattoriale()      {
		String nTesto;
		String mTesto;
		int n;
		int m;
		int mag;
		int min;
		int differenza;
		int divisione;
		int fattMag=1;
		int fattDiff=1;
		nTesto = cN.getText();
		n = Integer.parseInt(nTesto);
		mTesto = cM.getText();
		m = Integer.parseInt(mTesto);
		if (n>m) {
			mag=n;
			min=m;
		} else {
			mag=m;
			min=n;
		}
		differenza=mag-min;
		for(int cont = 1 ; cont <= mag; cont++) {
			fattMag=fattMag*cont;
		}
		for(int cont = 1 ; cont <= differenza; cont++) {
			fattDiff=fattDiff*cont;
		}
		divisione=fattMag/fattDiff;
		eFattoriale.setText(""+divisione);
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
