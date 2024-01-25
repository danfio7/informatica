package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rombo extends Application{
	TextField cDiagonaleMag = new TextField("");
	TextField cDiagonaleMin = new TextField("");
	Label eArea = new Label("");
	Label eLato = new Label("");
	Label ePerimetro = new Label("");

	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		
		Scene scena = new Scene(griglia);
		
		Label eDiagonaleMag = new Label("Diagonale maggiore");
		Label eDiagonaleMin = new Label("Diagonale minore");
		Button pArea = new Button("calcola area");
		Button pPerimetro = new Button("calcola perimetro");
		
		pArea.setPrefWidth(300);
		pPerimetro.setPrefWidth(300);
		
		griglia.add(eDiagonaleMag, 0, 0);
		griglia.add(eDiagonaleMin, 0, 1);
		griglia.add(cDiagonaleMag, 1, 0);
		griglia.add(cDiagonaleMin, 1, 1);
		griglia.add(pArea, 0, 2, 2, 1);
		griglia.add(eArea, 0, 3);
		griglia.add(pPerimetro, 0, 4, 2, 1);
		griglia.add(ePerimetro, 0, 5);

		finestra.setTitle("Rombo");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    pArea.setOnAction(e -> calcolaArea());
	    pPerimetro.setOnAction(e -> calcolaPerimetro());
	      
	}
	public void calcolaArea() {
		String diagonaleMag;
		String diagonaleMin;
		double diagMag;
		double diagMin;
		double area;
		diagonaleMag = cDiagonaleMag.getText();
		diagMag = Double.parseDouble(diagonaleMag);
		diagonaleMin = cDiagonaleMin.getText();
		diagMin = Double.parseDouble(diagonaleMin);
		area = (diagMag * diagMin) / 2;
		eArea.setText("Area= "+area);
	}
	public void calcolaPerimetro() {
		String diagonaleMag;
		String diagonaleMin;
		double diagMag;
		double diagMin;
		double lato;
		double perimetro;
		diagonaleMag = cDiagonaleMag.getText();
		diagMag = Double.parseDouble(diagonaleMag);
		diagonaleMin = cDiagonaleMin.getText();
		diagMin = Double.parseDouble(diagonaleMin);
		lato = (Math.sqrt((diagMag/2) * (diagMag/2) + (diagMin/2) * (diagMin/2)));
		perimetro = lato * 4;
		ePerimetro.setText("Perimetro= "+perimetro);
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
