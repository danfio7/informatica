package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InteresseComposto extends Application{
	TextField cCapitale = new TextField("");
	TextField cInteresse = new TextField("");
	TextField cAnni = new TextField("");
	Label eCapitale = new Label("capitale iniziale");
	Label eInteresse = new Label("tasso d'interesse");
	Label eAnni = new Label("numero di anni");
	Label eRisultato = new Label("");
	Button pCalcola = new Button("calcola interesse");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		Scene scena = new Scene(griglia);
		
		pCalcola.setPrefWidth(300);
		
		griglia.add(eCapitale, 0, 0);
		griglia.add(cCapitale, 1, 0);
		griglia.add(eInteresse, 0, 1);
		griglia.add(cInteresse, 1, 1);
		griglia.add(eAnni, 0, 2);
		griglia.add(cAnni, 1, 2);
		griglia.add(pCalcola, 0, 3, 2, 1);
		griglia.add(eRisultato, 0, 4, 2, 1);


		finestra.setTitle("Interesse composto");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setOnAction(e -> calcolaInteresse());
	      
	}
	public void calcolaInteresse() {
		String capitale;
		String anniTesto;
		String interesseTesto;
		int cont, anni;
		double cap, tot, interesseLetto, interesse;
		capitale = cCapitale.getText();
		anniTesto = cAnni.getText();
		anni = Integer.parseInt(anniTesto);
		interesseTesto = cInteresse.getText();
		interesseLetto = Integer.parseInt(interesseTesto);
		capitale = cCapitale.getText();
		cap = Double.parseDouble(capitale);
		tot = cap;
		for(cont = 1 ; cont <= anni; cont++) {
			interesse = (tot * interesseLetto)/100;
			tot = tot + interesse;
		}
		eRisultato.setText(" " + tot);
		
	}
	public static void main(String[] args) {
		 launch(args);
	}

}
