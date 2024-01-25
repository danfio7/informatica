package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Triangolo extends Application{
	TextField cLato1 = new TextField("");
	TextField cLato2 = new TextField("");
	TextField cLato3 = new TextField("");
	Button pTrovaTipo = new Button("trova tipo");
	Label eRisp = new Label("?");
	Label eRett = new Label("è rettangolo?");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 300, 300);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		finestra.setTitle("Triangoli");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    griglia.add(cLato1, 0, 0);
	    griglia.add(cLato2, 1, 0);
	    griglia.add(cLato3, 2, 0);
	    griglia.add(pTrovaTipo, 0, 1, 4, 1);
	    griglia.add(eRisp, 0, 3, 2, 1);
	    
	    pTrovaTipo.setPrefWidth(400);
	    
	    pTrovaTipo.setOnAction(e -> calcolaTotale());

	}
	public static void main(String[] args) {
		 launch(args);
	}
	public void calcolaTotale() {
		String lato1Testo;
		String lato2Testo;
		String lato3Testo;
		double lat1;
		double lat2;
		double lat3;
		lato1Testo = cLato1.getText();
		lat1 = Double.parseDouble(lato1Testo);
		lato2Testo = cLato2.getText();
		lat2 = Double.parseDouble(lato2Testo);
		lato3Testo = cLato3.getText();
		lat3 = Double.parseDouble(lato3Testo);
		if(lat1 < (lat2 + lat3) && lat2 < (lat1 + lat3) && lat3 < (lat2 + lat1)) {
			if((lat1 * lat1) + (lat2 * lat2) == (lat3 * lat3) || (lat3 * lat3) + (lat2 * lat2) == (lat1 * lat1) || (lat1 * lat1) + (lat3 * lat3) == (lat2 * lat2)) {
				eRett.setText("il triangolo è rettangolo");
			}else {
				eRett.setText("non è un triangolo rettangolo");
			}
			if(lat1 == lat2 && lat2 == lat3 && lat3 == lat1) {
				eRisp.setText(eRisp.getText() + " il triangolo è equilatero");
			} else {
				if(lat1 == lat2 || lat2 == lat3 || lat3 == lat1 ){
					eRisp.setText(eRisp.getText() + " il triangolo è isoscele");
				} else {
					eRisp.setText(eRisp.getText() + " il triangolo è scaleno");
				  }
			  }
		}else {
			eRisp.setText("non è un triangolo");
		}
		
	}

}
