package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rimbalzo3 extends Application{
	Timeline timeline;
	Label ePunteggio1 = new Label("");
	Label ePunteggio2 = new Label("");
	int cont = 0;
	double numeroRandom = 0;
	boolean sopra = true;
	double xPallino = 300;
	double yPallino = 150;
	boolean avanti;
	boolean alto;
	final int LARGHEZZA_AREA_GIOCO = 400;
	final int ALTEZZA_AREA_GIOCO = 300;
	final int LARGHEZZA_STECCHETTA = 10;
	final int ALTEZZA_STECCHETTA = 100;
	final int X_STECCHETTA_SINISTRA = 20;
	final int X_STECCHETTA_DESTRA = 370;
	final int Y_STECCHETTA_SINISTRA = 90;
	final int Y_STECCHETTA_DESTRA = 90;
	final int RAGGIO_PALLINO = 7;
	int punteggio1=0;
	int punteggio2=0;
	Circle pallino = new Circle(RAGGIO_PALLINO);
	Rectangle stecchettaSinistra = new Rectangle(LARGHEZZA_STECCHETTA, ALTEZZA_STECCHETTA);
	Rectangle stecchettaDestra = new Rectangle();
	Line rete = new Line();
	Pane quadro = new Pane();
	GridPane griglia = new GridPane();
	public void start(Stage finestra) throws Exception {
		Scene scena = new Scene(quadro);
		griglia.setPadding(new Insets(10, 10, 10, 10));
		
		scena.getStylesheets().add("it/edu/iisgubbio/animazioni/Pong.css");
		quadro.getStyleClass().add("sfondo");
		stecchettaSinistra.setId("stecchette");
		stecchettaDestra.setId("stecchette");
		pallino.setId("stecchette");
		ePunteggio1.setId("stecchette");
		ePunteggio2.setId("stecchette");
		
		quadro.getChildren().add(ePunteggio1);
		quadro.getChildren().add(ePunteggio2);
		quadro.getChildren().add(pallino);
	    quadro.getChildren().add(stecchettaSinistra);
	    quadro.getChildren().add(rete);
	    quadro.getChildren().add(stecchettaDestra);
	    quadro.setPrefSize(LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		
		finestra.setTitle("Pong");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    ePunteggio1.setLayoutX(70);
	    ePunteggio1.setLayoutY(30);
	    
	    ePunteggio2.setLayoutX(320);
	    ePunteggio2.setLayoutY(30);
	    
	    stecchettaSinistra.setWidth(LARGHEZZA_STECCHETTA);
	    stecchettaSinistra.setHeight(ALTEZZA_STECCHETTA);
	    stecchettaSinistra.setX(X_STECCHETTA_SINISTRA);
	    stecchettaSinistra.setY(Y_STECCHETTA_SINISTRA);
	    
	    stecchettaDestra.setWidth(LARGHEZZA_STECCHETTA);
	    stecchettaDestra.setHeight(ALTEZZA_STECCHETTA);
	    stecchettaDestra.setX(X_STECCHETTA_DESTRA);
	    stecchettaDestra.setY(Y_STECCHETTA_DESTRA);
	    
	    
	    scena.setOnKeyPressed(e -> pigiato(e));
	    
	    timeline = new Timeline(new KeyFrame(
				Duration.millis(5),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.play();
	}
	private void pigiato(KeyEvent evento) {
		if (evento.getText().equals("w")) {
			if ((stecchettaSinistra.getY() )<=0) {
				
			}else {
				stecchettaSinistra.setY(stecchettaSinistra.getY() - 5);
			}
		} 
		if (evento.getText().equals("s")) {
			if ((stecchettaSinistra.getY()+ALTEZZA_STECCHETTA)>=(ALTEZZA_AREA_GIOCO)) {
				
			}else {
				stecchettaSinistra.setY(stecchettaSinistra.getY() + 5);
			}
			
		}
		if (evento.getCode() == KeyCode.UP) {
			if ((stecchettaDestra.getY() )<=0) {
				
			}else {
				stecchettaDestra.setY(stecchettaDestra.getY() - 5);
			}
		}
		if (evento.getCode() == KeyCode.DOWN) {
			if ((stecchettaDestra.getY() + ALTEZZA_STECCHETTA)>=ALTEZZA_AREA_GIOCO) {
				
			}else {
				stecchettaDestra.setY(stecchettaDestra.getY() + 5);
			}
		}
	}
	private void aggiornaTimer(){
		
		Bounds b1 = stecchettaSinistra.getBoundsInParent();
        Bounds b2 = pallino.getBoundsInParent();
        Bounds b3 = stecchettaDestra.getBoundsInParent();
        if(b2.intersects(b1)) {
            avanti=true;
        }
        if(b3.intersects(b2)) {
            avanti=false;
        }
        if(xPallino>=LARGHEZZA_AREA_GIOCO) {
        	avanti=(Math.random()>0.5);
        	sopra=(Math.random()>0.5);
        	xPallino=200;
        	yPallino=150;
        	punteggio1+=1;
        	ePunteggio1.setText(""+ punteggio1);
        }
        if(xPallino<=0) {
        	avanti=(Math.random()>0.5);
        	sopra=(Math.random()>0.5);
        	xPallino=200;
        	yPallino=150;
        	punteggio2+=1;
        	ePunteggio2.setText(""+ punteggio2);
        }
		if(avanti==false) {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterX( xPallino -= numeroRandom);
		} else {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterX(xPallino += numeroRandom);
		}
		if(yPallino>=ALTEZZA_AREA_GIOCO) {
			sopra=false;
		}
		if(yPallino<=0) {
			sopra=true;
		}
		if(sopra==false) {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterY(yPallino -= numeroRandom);
		} else {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterY(yPallino += numeroRandom);
		}		
	}
	public static void main(String args[]){
		launch();
	}
}


