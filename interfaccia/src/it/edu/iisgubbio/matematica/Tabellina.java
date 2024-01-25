package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tabellina extends Application{
	Label eNum = new Label("numero");
	TextField cNumero = new TextField("");
	Button pTab = new Button("tabellina");
	Label eTab = new Label("");

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		griglia.setId("griglia");
		
		Scene scena = new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/matematica/Tabellina.css");
		
		pTab.setPrefWidth(300);
		
		griglia.add(eNum, 0, 0);
		griglia.add(cNumero, 1, 0);
		griglia.add(pTab, 0, 1, 2, 1);
		griglia.add(eTab, 0, 2, 2, 1);

		finestra.setTitle("Tabellina");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pTab.setOnAction(e -> calcolaTab());
	      
	}
	public void calcolaTab() {
		String sequenza;
		String num;
		sequenza = "0";
		int n, cont;
		cont = 1;
		num = cNumero.getText();
		n = Integer.parseInt(num);
		for(cont = 1 ; cont <= 10; cont++) {
		      sequenza += ", " + n * cont;
		      eTab.setText(sequenza);
		   }
	}
	
	public static void main(String[] args) {
		 launch(args);
	}
}
