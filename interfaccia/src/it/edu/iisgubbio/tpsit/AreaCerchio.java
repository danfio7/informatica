package it.edu.iisgubbio.tpsit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AreaCerchio extends Application{
	TextField cRaggio = new TextField("");
	Label eRaggio = new Label("raggio=");
	Label eArea = new Label("");
	Button pCalcola = new Button("calcola area");
	Label eSviluppatore = new Label("Daniele Fiorucci, "+"Simone Luchetti, "+"Giorgio Rossi");

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(10); 
		griglia.setVgap(10);
		
		griglia.add(eRaggio, 0, 0);
		griglia.add(cRaggio, 1, 0);
		griglia.add(pCalcola, 0, 1, 2, 1);
		griglia.add(eArea, 0, 2, 2, 1);
		griglia.add(eSviluppatore, 0, 3);
		
		finestra.setTitle("Quadrato");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pCalcola.setPrefWidth(200);
	    pCalcola.setOnAction(e -> areaM());
	}
	public void areaM() {
		String raggioTesto;
		double raggio;
		double area;
		double circonferenza;
		double circonferenza2;
		raggioTesto = cRaggio.getText();
		raggio = Integer.parseInt(raggioTesto);
		circonferenza = 2 * raggio * 3.14;
		circonferenza2 = circonferenza * 2;
		area = raggio * raggio * 3.14;
		eArea.setText("area= "+area);
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
