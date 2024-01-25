package it.edu.iisgubbio.date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Bisestile extends Application{
	Label eAnno = new Label("anno");
	Label eBisestile = new Label("");
	TextField cAnno = new TextField("");
	Button pBisestile = new Button("Bisestile?");
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		
		Scene scena = new Scene(griglia, 200, 100);
		
		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		finestra.setTitle("Anni");
	    finestra.setScene(scena);
	    finestra.show();
	   	
		pBisestile.setPrefWidth(200);

		griglia.add(eAnno, 0, 0);
		griglia.add(pBisestile, 0, 1);
		griglia.add(cAnno, 1, 0);
		griglia.add(eBisestile, 1, 1);
		
		pBisestile.setOnAction(e -> calcoloBisestileOK());
	}
	public void calcoloBisestile()      {
		String annoTesto;
		int anno;
		annoTesto = cAnno.getText();
		anno = Integer.parseInt(annoTesto);
		if((anno % 4) == 0 && (anno % 100) != 0 || (anno % 400) == 0){
			eBisestile.setText("Si");
		} else{
			eBisestile.setText("No");
		}
		
	}
	public void calcoloBisestileOK()      {
		String annoTesto;
		int anno;
		annoTesto = cAnno.getText();
		anno = Integer.parseInt(annoTesto);
		if((anno % 4) == 0){
			if((anno % 100) == 0){
				if((anno % 400) == 0){
					eBisestile.setText("Si");
				} else {
					eBisestile.setText("No");
				} 
			} else {
				eBisestile.setText("Si");
			}
		} else {
			eBisestile.setText("No");
		}
		
	}
	public static void main(String[] args) {
		 launch(args);
	}
}
