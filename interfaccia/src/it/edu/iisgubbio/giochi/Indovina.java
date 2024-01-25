package it.edu.iisgubbio.giochi;

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

public class Indovina extends Application{
	
	TextField cNumero = new TextField("");
	Label eRisultato = new Label("");
	Label eRicomincia = new Label("Ricominciamo?");
	int num;
	RadioButton ricomincia = new RadioButton("Si");
    RadioButton nonRicomincia = new RadioButton("No");
	GridPane griglia = new GridPane();
	
	public void start(Stage finestra) throws Exception {
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		Scene scena = new Scene(griglia, 250, 300);
		
		Label eNumero = new Label("numero:");
		Button pProva = new Button("prova");
		
		ToggleGroup Ricominciamo = new ToggleGroup();
		
		num =((int)(Math.random()*100) +1);
		
		pProva.setPrefWidth(300);
		
		griglia.add(eNumero, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pProva, 0, 1, 2, 1);
		griglia.add(eRisultato, 1, 2);
		griglia.add(eRicomincia, 0, 3, 2, 1);
		griglia.add(ricomincia , 0, 4);
		griglia.add(nonRicomincia , 0, 5);	
		
		eRicomincia.setVisible(false);
		ricomincia.setVisible(false);
		nonRicomincia.setVisible(false);
		
		ricomincia.setToggleGroup(Ricominciamo);
        nonRicomincia.setToggleGroup(Ricominciamo);


		finestra.setTitle("indovina");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pProva.setOnAction(e -> trovaNum());
	      
	}
	public void trovaNum() {
		String numeroTesto;
		int numIntero;
		numeroTesto = cNumero.getText();
		numIntero = Integer.parseInt(numeroTesto);
		if(numIntero > num){
			eRisultato.setText("Troppo grande"+num);
		} else {
			if(numIntero < num){
				eRisultato.setText("Troppo piccolo"+num);
			} else {
				eRisultato.setText("Hai indovinato!"+num);
				eRicomincia.setVisible(true);
				ricomincia.setVisible(true);
				nonRicomincia.setVisible(true);
			  }
		  }
		if(ricomincia.isSelected()){
			num =((int)(Math.random()*100) +1);
		}
		if(nonRicomincia.isSelected()){
			System. exit(0);
		}
	}
	
	public static void main(String[] args) {
		 launch(args);
	}

}
