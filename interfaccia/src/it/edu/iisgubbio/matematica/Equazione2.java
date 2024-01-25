package it.edu.iisgubbio.matematica;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Equazione2 extends Application{

	TextField cA = new TextField("");
	TextField cB= new TextField("");
	TextField cC = new TextField("");
	Button pCalcola = new Button("calcola equazione");
	Label eA = new Label("x²");
	Label eB = new Label("x");
	Label eSecondoMembro = new Label("=0");
	Label eRisultato = new Label("");
	Label eRisultato2 = new Label("");
	Label eTipo = new Label("");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 530, 150);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(5); 
		griglia.setVgap(5);
		
		finestra.setTitle("Equazioni");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    Image i = new Image(getClass().getResourceAsStream("polliceInSu.png"));
        ImageView iw = new ImageView(i);
        iw.setFitHeight(40);
        iw.setPreserveRatio(true);
        pCalcola.setGraphic(iw);
	    
	    griglia.add(cA, 0, 0);
	    griglia.add(eA, 1, 0);
	    griglia.add(cB, 2, 0);
	    griglia.add(eB, 3, 0);
	    griglia.add(cC, 4, 0);
	    griglia.add(eSecondoMembro, 5, 0);
	    griglia.add(pCalcola, 0, 1, 6, 1);
	    griglia.add(eRisultato, 0, 3, 6, 1);
	    
	    pCalcola.setPrefWidth(505);
	    pCalcola.setOnAction(e -> calcolaSoluzioni());

	}
	public void calcolaSoluzioni() {
		String aTesto;
		String bTesto;
		String cTesto;
		double a;
		double b;
		double c;
		double x1;
		double x2;
		double delta;
		aTesto = cA.getText();
		a = Double.parseDouble(aTesto);
		bTesto = cB.getText();
		b = Double.parseDouble(bTesto);
		cTesto = cC.getText();
		c = Double.parseDouble(cTesto);
		delta = ((b * b) - 4 * a * c);
		if(b == 0 && c == 0) {
			eRisultato.setText("L'equazione è di secondo grado monomia, x=0");
		} else {
			if(a == 0) {
				eRisultato.setText("L'equazione è di primo grado,");
			} else {
				if(b == 0) {
					x1 = ((-(b) + Math.sqrt(delta))/(2 * a));
					x2 = ((-(b) - Math.sqrt(delta))/(2 * a));
					eRisultato.setText("L'equazione è di secondo grado, pura, x1= "+ x1 + " x2=" + x2);
				} else {
					if(c == 0) {
						x1 = ((-(b) + Math.sqrt(delta))/(2 * a));
						x2 = ((-(b) - Math.sqrt(delta))/(2 * a));
						eRisultato.setText("L'equazione è di secondo grado, spuria, x1= "+ x1 +" x2= "+ x2);
					} else {
						if(delta == 0) {
							x1 = (-b / (2 * a));
							eRisultato.setText("L'equazione ha 2 soluzioni reali e coincidenti, x1="+ x1 +" x2=" + x1);
						} else {
							if(delta > 0) {
								x1 = ((-(b) + Math.sqrt(delta))/(2 * a));
								x2 = ((-(b) - Math.sqrt(delta))/(2 * a));
								eRisultato.setText("x1="+ x1 + " x2="+ x2);
							} else {
								eRisultato.setText("L'equazione è impossibile");
							}
						}
					}
				}
			}
		}	
	}
	public static void main(String[] args) {
		 launch(args);
	}
}