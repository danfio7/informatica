package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FiorucciDanieleNumeri extends Application{
	Label ePrimoNum= new Label("Primo num");
	Label eSecondoNum= new Label("Secondo num");
	TextField cPrimoNum = new TextField("");
	TextField cSecondoNum = new TextField("");
	Button pCalcola = new Button("calcola");
	Label eRisultato = new Label("risultato");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia);
		
		griglia.add(ePrimoNum, 0, 0);
		griglia.add(cPrimoNum, 1, 0);
		griglia.add(eSecondoNum, 0, 1);
		griglia.add(cSecondoNum, 1, 1);
		griglia.add(pCalcola, 0, 2);
		griglia.add(eRisultato, 1, 2);
		
		
		finestra.setTitle("Paninoteca");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setOnAction(e -> calcolaMcm());
	    
	}
	public void calcolaMcm(){
		String primoNumTesto;
		String secondoNumTesto;
		int primoNum;
		int secondoNum;
		int nMag;
		int nMin;
		int mcm=0;
		primoNumTesto = cPrimoNum.getText();
		primoNum = Integer.parseInt(primoNumTesto);
		secondoNumTesto = cSecondoNum.getText();
		secondoNum = Integer.parseInt(secondoNumTesto);
		if(primoNum>secondoNum) {
			nMag=primoNum;
			nMin=secondoNum;
		} else {
			nMag=secondoNum;
			nMin=primoNum;
		}
		for(int cont = nMin ; cont < (nMag * nMin); cont++) {
			if (cont % nMag==0 && cont % nMin==0 ) {
				mcm = cont;
			}
			
		}
		eRisultato.setText(""+mcm);
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
