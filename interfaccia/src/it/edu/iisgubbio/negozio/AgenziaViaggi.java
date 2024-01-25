package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AgenziaViaggi extends Application{
	TextField cPers = new TextField("");
	TextField cPart = new TextField("");
	TextField cCostoAutobus = new TextField("");
	Button pBiglietto = new Button("calcola biglietto");
	Label eCB = new Label("");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		Scene scena = new Scene(griglia);
		
		Label ePersPerAutobus = new Label("persone per autobus");
		Label ePartecipanti = new Label("partecipanti");
		Label eCosto = new Label("costo autobus");
		Label eCostoBiglietto = new Label("costo biglietto");
		
		pBiglietto.setPrefWidth(300);
		
		griglia.add(ePersPerAutobus, 0, 0);
		griglia.add(ePartecipanti, 0, 1);
		griglia.add(cPers, 1, 0);
		griglia.add(cPart, 1, 1);
		griglia.add(eCosto, 0, 2);
		griglia.add(cCostoAutobus, 1, 2);
		griglia.add(pBiglietto, 0, 3, 2, 1);
		griglia.add(eCostoBiglietto, 0, 4);
		griglia.add(eCB, 1, 4);

		finestra.setTitle("Agenzia Viaggi");
	    finestra.setScene(scena);
	    finestra.show(); 
	    
	    pBiglietto.setOnAction(e -> calcolaBiglietto());
	}
	public void calcolaBiglietto() {
		String personeTesto;
		String partecipantiTesto;
		String costoTesto;
		int pers;
		int part;
		int costo;
		double biglietto;
		int numAutobus;
		personeTesto = cPers.getText();
		pers = Integer.parseInt(personeTesto);
		partecipantiTesto = cPart.getText();
		part = Integer.parseInt(partecipantiTesto);
		costoTesto = cCostoAutobus.getText();
		costo = Integer.parseInt(costoTesto);
		numAutobus = part / pers;
		if(part % pers != 0){
			biglietto = (((numAutobus)+1)*costo)/part;
		} else {
			biglietto = (numAutobus*costo)/ part;
		  }
		eCB.setText(""+ biglietto +"€");
	}
	public static void main(String[] args) {
		 launch(args);
	}
}

