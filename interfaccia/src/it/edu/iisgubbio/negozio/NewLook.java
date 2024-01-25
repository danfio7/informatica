package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewLook extends Application{
	TextField cKmPercorsi = new TextField("");
	Label eKm = new Label("km");
	Label eIndossa = new Label("Cosa indossa?");
	Label eDispendio = new Label("dispendio calorico");
	Label eRisultato = new Label("");
	RadioButton rNuoto = new RadioButton("nuoto");
    RadioButton rBici = new RadioButton("bici");
    RadioButton rCorsa = new RadioButton("corsa");
    CheckBox ckBracciale = new CheckBox("bracciale");
    CheckBox ckCavigliera = new CheckBox("cavigliera");
    Button pCalcola = new Button("calcola dispendio calorico");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 270, 300);
		scena.getStylesheets().add("it/edu/iisgubbio/negozio/NewLook.css");
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		griglia.setId("griglia");
		
		pCalcola.setPrefWidth(250);
		
		griglia.add(cKmPercorsi, 0, 0);
		griglia.add(eKm, 1, 0);
		griglia.add(rNuoto, 0, 1);
		griglia.add(rBici, 0, 2);
		griglia.add(rCorsa, 0, 3);
		griglia.add(eIndossa, 0, 4, 2, 1);
		griglia.add(ckBracciale, 0, 5);
		griglia.add(ckCavigliera, 0, 6);
		griglia.add(pCalcola, 0, 7, 2, 1);
		griglia.add(eDispendio, 0, 8);
		griglia.add(eRisultato, 1, 8);
		
		finestra.setTitle("New Look");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    ToggleGroup sport = new ToggleGroup();
	    rNuoto.setToggleGroup(sport);
        rBici.setToggleGroup(sport);
        rCorsa.setToggleGroup(sport);
        
        pCalcola.setOnAction(e -> calcoloDispendio());
	   
	}
	public void calcoloDispendio(){
		String kmTesto;
		double dispendio;
		int km;
		kmTesto = cKmPercorsi.getText();
		km = Integer.parseInt(kmTesto);
		if(rNuoto.isSelected()) {
			dispendio = km * 21;
			if(ckBracciale.isSelected()) {
				dispendio = dispendio * 1.18;
				eRisultato.setText("" + dispendio);
			}
			if(ckCavigliera.isSelected()) {
				dispendio = dispendio * 1.35;
				eRisultato.setText("" + dispendio);
			}
			eRisultato.setText("" + dispendio);
		}
		if(rBici.isSelected()) {
			dispendio = km * 7;
			if(ckBracciale.isSelected()) {
				dispendio = dispendio * 1.18;
				eRisultato.setText("" + dispendio);
			}
			if(ckCavigliera.isSelected()) {
				dispendio = dispendio * 1.35;
				eRisultato.setText("" + dispendio);
			}
			eRisultato.setText("" + dispendio);	
		}
		if(rCorsa.isSelected()) {
			dispendio = km * 12;
			if(ckBracciale.isSelected()) {
				dispendio = dispendio * 1.18;
				eRisultato.setText("" + dispendio);
			}
			if(ckCavigliera.isSelected()) {
				dispendio = dispendio * 1.35;
				eRisultato.setText("" + dispendio);
			}
			eRisultato.setText("" + dispendio);
		}
		 
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
	
}


