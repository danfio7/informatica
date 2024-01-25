package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caso extends Application{
	TextField tElementi = new TextField();
	TextField tMin = new TextField();
	TextField tMax = new TextField();
	Label eElementi = new Label("elementi");
	Label eMin = new Label("min");
	Label eMax = new Label("max");
	Label eRisultati = new Label("");
	Label ePari = new Label("");
	Label eSomma = new Label("");
	Label e2e3 = new Label("");
	Label eMinore = new Label("");
	Button pGenera = new Button("genera");
	Button pStampa = new Button("stampa");
	Button pPari = new Button("pari");
	Button pSomma = new Button("somma");
	Button p2e3 = new Button("2e3");
	Button pMinore = new Button("min");
	int tempi[];
	int numElementi;
	int pos;
	String elenco="";
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(eElementi,  0,  0);
	    griglia.add(tElementi,  1,  0);
	    griglia.add(eMin, 0, 1);
	    griglia.add(tMin,  1,  1);
	    griglia.add(eMax, 0, 2);
	    griglia.add(tMax,  1,  2);
	    griglia.add(pGenera,  0,  3);
	    griglia.add(pStampa,  1,  3);
	    griglia.add(eRisultati,  0,  4);
	    griglia.add(pPari,  0,  5);
	    griglia.add(ePari,  1,  5);
	    griglia.add(pSomma,  0,  6);
	    griglia.add(eSomma,  1,  6);
	    griglia.add(p2e3,  0,  7);
	    griglia.add(e2e3,  1,  7);
	    griglia.add(pMinore,  0,  8);
	    griglia.add(eMinore,  1,  8);
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,280,300);
	    
	    finestra.setTitle("Caso"); 
		finestra.setScene(scene);
		finestra.show();
		
		pGenera.setOnAction(e -> alloca());
		pStampa.setOnAction(e -> stampa());
		pPari.setOnAction(e -> pari());
		pSomma.setOnAction(e -> somma());
		p2e3.setOnAction(e -> dueEtre());
		pMinore.setOnAction(e -> minore());
	}
	public void alloca() {
		int min;
		int max;
		int intervallo;
		int random=0;
		min = Integer.parseInt(tMin.getText());
		max = Integer.parseInt(tMax.getText());
		numElementi = Integer.parseInt(tElementi.getText());
	    tempi = new int[numElementi];
	    pos = 0;
	    intervallo = (max-min)+1;
	    for(int indice = 0; indice < tempi.length; indice++) {
	    	random = (int)(Math.random()*intervallo)+min;
	    	tempi[pos++]=random;
	    	
	    }
	    
	}
	public void stampa() {
		String elenco="";
		
		for(int indice = 0; indice < tempi.length; indice++) {
	         if(elenco.equals("")) {
	        	 elenco+=("" + tempi[indice]);
	         } else {
	        	 elenco+=(", " + tempi[indice]);
	         }
	    }
		eRisultati.setText(elenco);
	}
	public void somma() {
		int somma=0;
		for(int indice = 0; indice < tempi.length; indice++) {
	         somma+=tempi[indice];
	    }
		eSomma.setText(""+somma);
	}
	public void pari() {
		int contaPari=0;
		for(int indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] % 2 ==0) {
	            contaPari++;  
	         }
	    }
		ePari.setText(""+contaPari);
	}
	public void dueEtre() {
		int sommaMultipli=0;
		for(int indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] % 2 == 0 && tempi[indice] % 3 == 0) {
	            sommaMultipli+=tempi[indice];
	         }
	    }
		e2e3.setText(""+sommaMultipli);
	}
	public void minore() {
		int minimo=0;
		int indice=0;
		minimo=tempi[indice];
		for(indice=1; indice < tempi.length; indice++) {
	         if(tempi[indice]<=minimo) {
	            minimo=tempi[indice];  
	         }
	    }
		eMinore.setText(""+minimo);
	}
	public static void main(String args[]){
		launch();
	}

}
