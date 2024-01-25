package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FiorucciDanieleRistorante extends Application{
	Label eNumHamburger = new Label("Numero hamburger:");
	Label ePrezzoHamburger = new Label("Prezzo hamburger:");
	Label ePrezzoPatatine = new Label("Prezzo patatine:");
	Label eNumPatatine= new Label("Numero Patatine:");
	Label eTotale= new Label("Totale:");
	Label eRisultato= new Label("??");
	TextField cNumHamb = new TextField("");
	TextField cNumPat = new TextField("");
	TextField cPrezzoHamb = new TextField("");
	TextField cPrezzoPat = new TextField("");
	CheckBox ckSalse = new CheckBox("salse +0.2€");
	CheckBox ckSconto = new CheckBox("sconto 10%");
	Button pCalcola = new Button("Calcola Prezzo");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia);
		
		scena.getStylesheets().add("it/edu/iisgubbio/verifica/FiorucciDanieleRistorante.css");
		griglia.setId("griglia");
		eNumHamburger.setId("numeri");
		eNumPatatine.setId("numeri");
		
		
		griglia.add(eNumHamburger, 0, 0);
		griglia.add(cNumHamb, 0, 1);
		griglia.add(eNumPatatine, 0, 2);
		griglia.add(cNumPat, 0, 3);
		griglia.add(ePrezzoHamburger, 1, 0);
		griglia.add(cPrezzoHamb, 1, 1);
		griglia.add(ePrezzoPatatine, 1, 2);
		griglia.add(cPrezzoPat, 1, 3);
		griglia.add(ckSalse, 0, 4);
		griglia.add(ckSconto, 1, 4);
		griglia.add(pCalcola, 0, 5, 2, 1);
		griglia.add(eTotale, 0, 6);
		griglia.add(eRisultato, 1, 6);
		
		
		finestra.setTitle("Paninoteca");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setOnAction(e -> calcolaSpesa());
	}
	public void calcolaSpesa() {
		String nHambTesto;
		String nPatTesto;
		String prezzoHambTesto;
		String prezzoPatTesto;
		int nHamb;
		int nPat;
		double prezzoPat;
		double prezzoHamb;
		double totPatatine=0;
		double totHamburger=0;
		double sconto;
		double tot;
		nHambTesto = cNumHamb.getText();
		nHamb = Integer.parseInt(nHambTesto);
		nPatTesto = cNumPat.getText();
		nPat = Integer.parseInt(nPatTesto);
		prezzoHambTesto = cPrezzoHamb.getText();
		prezzoHamb = Double.parseDouble(prezzoHambTesto);
		prezzoPatTesto = cPrezzoPat.getText();
		prezzoPat = Double.parseDouble(prezzoPatTesto);
		if(ckSalse.isSelected()) {
			for(int cont = 1 ; cont <= nPat; cont++) {
				totPatatine += 0.2;
			}
		}
		totPatatine += prezzoPat * nPat;
		totHamburger= nHamb * prezzoHamb;
		tot= totPatatine + totHamburger;
		if(ckSconto.isSelected()) {
			sconto=(tot*10)/100;
			tot=tot-sconto;
		}
		eRisultato.setText(""+tot);
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
