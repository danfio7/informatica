package it.edu.iisgubbio.esercizi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimaInterfaccia2 extends Application {

	TextField cCasellaSinistra = new TextField();
	Button pUnisci = new Button();
	TextField cCasellaDestra = new TextField();
	Button pCopiaSinistra = new Button();
	Label eEtichettaUnita = new Label();
	Button pCopiaDestra = new Button();
	Label eEtichettaSinistraCopia = new Label();
	Button pPulisciAlto = new Button();
	Label eEtichettaDestraCopia = new Label();
	
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();

	    
	    pUnisci.setText("Unisci");
	    cCasellaSinistra.setText("");
	    cCasellaDestra.setText("");
	    pCopiaSinistra.setText("Copia");
	    eEtichettaUnita.setText("");
	    pCopiaDestra.setText("Copia");
	    eEtichettaSinistraCopia.setText("");
	    pPulisciAlto.setText("Pulisci");
	    eEtichettaDestraCopia.setText("");
	    
	    
	    griglia.add(cCasellaSinistra, 0, 0);
	    griglia.add(pUnisci, 1, 0);
	    griglia.add(cCasellaDestra, 2, 0);
	    griglia.add(pCopiaSinistra, 0, 1);
	    griglia.add(eEtichettaUnita, 1, 1);
	    griglia.add(pCopiaDestra, 2, 1);
	    griglia.add(eEtichettaSinistraCopia, 0, 2);
	    griglia.add(pPulisciAlto, 1, 2);
	    griglia.add(eEtichettaDestraCopia, 2, 2);
	    
	    pUnisci.setOnAction(e -> Unisci());
	    pCopiaSinistra.setOnAction(e -> CopiaSinistra());
	    pCopiaDestra.setOnAction(e -> CopiaDestra());
	    pPulisciAlto.setOnAction(e -> Pulisci());
	    
	    Scene scena = new Scene(griglia);
		
		finestra.setTitle("prima interfaccia");
	    finestra.setScene(scena);
	    finestra.show();
	   
	}
	public void Unisci() {
		 String unisciSinistra;
		 String unisciDestra;
		 unisciSinistra = cCasellaSinistra.getText();
		 unisciDestra = cCasellaDestra.getText();
		 eEtichettaUnita.setText(unisciSinistra + unisciDestra);
		 
	}
	
	public void CopiaSinistra() {
		String copiaSinistra;
		copiaSinistra = cCasellaSinistra.getText();
		eEtichettaSinistraCopia.setText(copiaSinistra);
		 
	}
	
	public void CopiaDestra() {
		String copiaDestra;
		copiaDestra = cCasellaDestra.getText();
		eEtichettaDestraCopia.setText(copiaDestra);
		 
	}
	
	public void Pulisci() {
		cCasellaSinistra.setText("");
		cCasellaDestra.setText("");
		eEtichettaSinistraCopia.setText("");
		eEtichettaDestraCopia.setText("");
		eEtichettaUnita.setText("");
		
		 
	}
	
	public static void main(String[] args) {
		 launch(args);
	}
}
