package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Elenco extends Application{
	TextField tNumero = new TextField();
	TextField tTempo = new TextField();
	TextField tCoach = new TextField();
	TextField tRisultati = new TextField();
	Label eNumero = new Label("numero tempi");
	Label eTempo = new Label("tempo");
	Label eCoach = new Label("tempo coach");
	Label eRisultati = new Label("");
	Label eElenco = new Label("");
	Button pAggiungi = new Button("aggiungi tempo");
	Button pAlloca = new Button("crea vettore");
	Button pConfronta = new Button("confronta");
	Button pElenca = new Button("elenca");
	int tempi[];
	int numTempi;
	int pos;
	String elenco="";
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		griglia.add(tNumero,  1,  0);
	    griglia.add(eNumero,  0,  0);
	    griglia.add(tTempo, 1, 1);
	    griglia.add(eTempo,  0,  1);
	    griglia.add(tCoach, 1, 2);
	    griglia.add(eCoach,  0,  2);
	    griglia.add(pAlloca,  0,  3);
	    griglia.add(pAggiungi,  0,  4);
	    griglia.add(pConfronta,  0,  5);
	    griglia.add(pElenca,  0,  6);
	    griglia.add(eRisultati,  0,  7);
	    griglia.add(eElenco,  0,  8);
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,300,300);
	    
	    finestra.setTitle("Nuoto"); 
		finestra.setScene(scene);
		finestra.show();
		
		pAlloca.setOnAction(e -> alloca());
		pAggiungi.setOnAction(e -> inserisciTempo());
		pConfronta.setOnAction(e -> contaPessimi());
		pElenca.setOnAction(e -> elenca());
	}
	public void alloca() {
	      numTempi = Integer.parseInt(tNumero.getText());
	      tempi = new int[numTempi];
	      pos = 0;
	}
	public void inserisciTempo() {
	      if(pos < numTempi) {
	         tempi[pos++]=Integer.parseInt(tTempo.getText());
	         tTempo.setText("") ;
	      }
	}
	public void contaPessimi() {
	      int contatore = 0;
	      int coach = Integer.parseInt(tCoach.getText());
	      for(int indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] > coach) {
	            contatore++;
	            
	            
	         }
	      }
	      eRisultati.setText("" + contatore);
	}
	public void elenca() {
		String elenco="";
		
		for(int indice = 0; indice < tempi.length; indice++) {
	         if(elenco.equals("")) {
	        	 elenco+=("" + tempi[indice]);
	         } else {
	        	 elenco+=(", " + tempi[indice]);
	         }
	    }
		eElenco.setText(elenco);
	}
	public static void main(String args[]){
		launch();
	}
}
