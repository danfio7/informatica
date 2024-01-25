package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sconto extends Application{
	TextField cPrezzoPanino = new TextField("");
	TextField cNumeroPanini = new TextField("");
	TextField cSconto = new TextField("");
	Label ePrezzoPanino = new Label("prezzo panino");
	Label eNumeroPanini = new Label("numero panini");
	Label eSconto = new Label("sconto");
	Label eTot = new Label("");
	Label eSct = new Label("");
	CheckBox scontoPresente = new CheckBox("Applica sconto");
	
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 350, 200);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		finestra.setTitle("Sconto");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    Button pCalcolaTotale = new Button("calcola");
		pCalcolaTotale.setPrefWidth(300);
		
		griglia.add(ePrezzoPanino, 0, 0);
		griglia.add(eNumeroPanini, 0, 1);
		griglia.add(eSconto, 0, 2);
		griglia.add(pCalcolaTotale, 0, 4, 2, 1);
		griglia.add(cPrezzoPanino, 1, 0);
		griglia.add(cNumeroPanini, 1, 1);
		griglia.add(cSconto, 1, 2);
		griglia.add(eTot, 0, 5);
		griglia.add(eSct, 1, 5);
		griglia.add(scontoPresente, 0, 3);

		pCalcolaTotale.setOnAction(e -> calcolaSconto());
	}
	public void calcolaSconto()      {
		String prezzoPanino;
		String numeroPanini;
		String percentualeSconto;
		double prezPan;
		double numPan;
		double sconto;
		double tot;
		prezzoPanino = cPrezzoPanino.getText();
		prezPan = Double.parseDouble(prezzoPanino);
		numeroPanini = cNumeroPanini.getText();
		numPan = Double.parseDouble(numeroPanini);
		tot = numPan * prezPan;
		eTot.setText("totale="+tot);
		percentualeSconto = cSconto.getText();
		sconto = Double.parseDouble(percentualeSconto);
		tot = numPan * prezPan;
		if(scontoPresente.isSelected()) {
			 tot = numPan * prezPan;
	         sconto = tot * sconto / 100;
	         tot = tot - sconto;

	    }
        eTot.setText("totale="+tot);
        eSct.setText("sconto="+sconto);
	}
	
	public static void main(String[] args) {
		 launch(args);
	}
}


