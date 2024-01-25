package it.edu.iisgubbio.negozio;

import java.awt.Image;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Kebab3 extends Application{
	Label eTot = new Label("");
	Label eCarne = new Label("carne");
	Label ePrezzoC = new Label("");
	Label ePrezzoV = new Label("");
	Label ePrezzoS = new Label("");
	Label eVerdura = new Label("verdura");
	Label eSalse = new Label("salse");
	Button pTot = new Button("totale");
	ComboBox<String> cbCarne = new ComboBox<>();
	ComboBox<String> cbVerdura = new ComboBox<>();
	ComboBox<String> cbSalse = new ComboBox<>();
	String carne = cbCarne.getValue();
	public void start(Stage finestra) throws Exception {
		
		GridPane griglia = new GridPane();
		griglia.add(eCarne, 0, 0);
		griglia.add(cbCarne, 0, 1);
		griglia.add(ePrezzoC, 1, 1);
		griglia.add(eVerdura, 0, 2);
		griglia.add(cbVerdura, 0, 3);
		griglia.add(ePrezzoV, 1, 3);
		griglia.add(eSalse, 0, 4);
		griglia.add(cbSalse, 0, 5);
		griglia.add(ePrezzoS, 1, 5);
		griglia.add(pTot, 0, 6);
		griglia.add(eTot, 0, 7);

		griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
		
		cbCarne.setOnAction(e->prezzoCarne());
		cbCarne.getItems().add("pollo");
		cbCarne.getItems().add("maiale");
		cbCarne.getItems().add("vitello");
		cbCarne.getItems().add("tofu");
		
		cbVerdura.setOnAction(e->prezzoVerdura());
		cbVerdura.getItems().add("insalata");
		cbVerdura.getItems().add("cipolla");
		cbVerdura.getItems().add("pomodoro");
		cbVerdura.getItems().add("carota");
		
		cbSalse.setOnAction(e->prezzoSalse());
		cbSalse.getItems().add("mayonese");
		cbSalse.getItems().add("piccante");
		cbSalse.getItems().add("yogurt");
		cbSalse.getItems().add("tzatziki");
		
		Scene scene = new Scene(griglia, 200, 300);

		finestra.setTitle("Timer!"); 
		finestra.setScene(scene);
		finestra.show();
		
		pTot.setOnAction(e -> totale());
		
	}
	public void totale() {
		double tot=1;
        String carne = cbCarne.getValue();
        switch(carne){
        	case "pollo":
        		tot+=3.0;
        		break;
        	case "maiale":
        		tot=tot+2.5;
        		break;
        	case "vitello":
        		tot=tot+4.0;
        		break;
        	case "tofu":
        		tot=tot+3.0;
        		break;
        	default:
        		eTot.setText("");
        }
        String verdura = cbVerdura.getValue();
        switch(verdura){
        	case "insalata":
        		tot+=0.5;
        		break;
        	case "cipolla":
        		tot=tot+0.5;
        		break;
        	case "pomodoro":
        		tot=tot+1.0;
        		break;
        	case "carota":
        		tot=tot+1.0;
        		break;
        	default:
        		eTot.setText("");
        }
        String salse = cbSalse.getValue();
        switch(salse){
        	case "mayonese":
        		tot+=0.5;
        		break;
        	case "piccante":
        		tot=tot+1.0;
        		break;
        	case "yogurt":
        		tot=tot+0.5;
        		break;
        	case "tzatziki":
        		tot=tot+0.5;
        		break;
        	default:
        		eTot.setText("");
        }
		eTot.setText(""+tot);
    }
	public void prezzoCarne() {
		String prezzoCarne = cbCarne.getValue();
		switch(prezzoCarne){
    	case "pollo":
    		ePrezzoC.setText("3.0");
    		break;
    	case "maiale":
    		ePrezzoC.setText("2.5");
    		break;
    	case "vitello":
    		ePrezzoC.setText("4.0");
    		break;
    	case "tofu":
    		ePrezzoC.setText("3.0");
    		break;
    	default:
    		ePrezzoC.setText("");
		}
    }
	public void prezzoVerdura() {
		String prezzoVerdura = cbVerdura.getValue();
		switch(prezzoVerdura){
    	case "insalata":
    	case "cipolla":
    		ePrezzoV.setText("0.5");
    		break;
    	default:
    		ePrezzoV.setText("1.0");
		}
    }
	public void prezzoSalse() {
		String prezzoSalse = cbSalse.getValue();
		switch(prezzoSalse){
    	case "piccante":
    		ePrezzoS.setText("1.0");
    		break;
    	default:
    		ePrezzoS.setText("0.5");
		}
    }
	public static void main(String args[]){
		launch();
	}
}
