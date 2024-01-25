package it.edu.iisgubbio.negozio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Kebab extends Application{
	Button pTotale = new Button("totale");
	Label eTot = new Label("?");
	CheckBox ckCarne = new CheckBox("carne [4.00€]");
	CheckBox ckFormaggio = new CheckBox("formaggio [1.00€]");
	CheckBox ckPomodoro = new CheckBox("pomodoro [1.00€]");
	CheckBox ckSalsa = new CheckBox("salsa [0.50€]");
	CheckBox ckCipolla = new CheckBox("cipolla [0.50€]");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 200, 200);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		finestra.setTitle("Kebab");
	    finestra.setScene(scena);
	    finestra.show();
	   	
		pTotale.setPrefWidth(200);

		griglia.add(ckCarne, 0, 0);
		griglia.add(ckFormaggio, 0, 1);
		griglia.add(ckPomodoro, 0, 2);
		griglia.add(ckSalsa, 0, 3);
		griglia.add(ckCipolla, 0, 4);
		griglia.add(pTotale, 0, 5);
		griglia.add(eTot, 1, 5);
		
		pTotale.setOnAction(e -> calcoloKebab());
	}
	public void calcoloKebab()      {
		double tot;
		tot = 0;
		if(ckCarne.isSelected()){
			tot = (tot + 4.00);
			eTot.setText(""+tot);
			}
		if(ckFormaggio.isSelected()) {
			tot = (tot + 1.00);
			eTot.setText(""+ tot);
			}
		if(ckPomodoro.isSelected()) {
			tot = (tot + 1.00);
			eTot.setText(""+tot);
			}
		if(ckSalsa.isSelected()) {
			tot = (tot + 0.50);
			eTot.setText(""+tot);
			}
		
		if(ckCipolla.isSelected()) {
			tot = (tot+ 0.50);
			eTot.setText(""+tot);
			
		}

		
	}
	public static void main(String[] args) {
		 launch(args);
	}

}
