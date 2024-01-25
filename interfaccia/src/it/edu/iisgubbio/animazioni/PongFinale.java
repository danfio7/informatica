package it.edu.iisgubbio.animazioni;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PongFinale extends Application{
	int secondi=3;
	int contatoreCountdown=0;
	int velocitàRacchette=0;
	int velocitàPallino=0;
	int cont = 0;
	final int Y_RACCHETTA_SINISTRA = 160;
	final int Y_RACCHETTA_DESTRA = 160;
	int punteggio1=0;
	int punteggio2=0;
	double numeroRandom = 0;
	boolean sopra = true;
	double xPallino = 200;
	double yPallino = 210;
	boolean avanti;
	boolean alto;
	final int LARGHEZZA_AREA_GIOCO = 400;
	final int ALTEZZA_AREA_GIOCO = 350;
	final int LARGHEZZA_RACCHETTE = 10;
	final int ALTEZZA_RACCHETTE = 100;
	final int X_RACCHETTA_SINISTRA = 20;
	final int X_RACCHETTA_DESTRA = 370;
	final int RAGGIO_PALLINO = 7;
	Timeline timelinePallino;
	
	Timeline timelineCountdown = new Timeline(new KeyFrame(
			Duration.seconds(1),
			x -> countdown()));
	
	Label ePunteggio1 = new Label("");
	Label ePunteggio2 = new Label("");
	Label eDifficoltà = new Label("Seleziona la difficoltà!");
	Label eCountdown = new Label("");
	Label eAvviso = new Label("Attenzione: se cambi la difficoltà durante il gioco inizierà una nuova partita!");
	Label eRegole = new Label("Il primo che arriva a 10 punti vince!");
	Label eVittoria = new Label("");
	Image immagineMenu = new Image(getClass().getResourceAsStream("menu.png"));
    ImageView iM = new ImageView(immagineMenu);
    Image immagineFreccia = new Image(getClass().getResourceAsStream("frecciaIndietro.png"));
    ImageView iF = new ImageView(immagineFreccia);
    
	Button pFacile = new Button("Facile");
	Button pMedio = new Button("Medio");
	Button pDifficile = new Button("Difficile");
	Button pImpossibile = new Button("Impossibile");
	Button pMenù = new Button("");
	Button pIndietro = new Button("");
	Button pRicomincia = new Button("Ricomincia");
	
	Circle pallino = new Circle(RAGGIO_PALLINO);
	Circle cerchioCountdown = new Circle(30);
	
	Rectangle racchettaSinistra = new Rectangle(LARGHEZZA_RACCHETTE, ALTEZZA_RACCHETTE);
	Rectangle racchettaDestra = new Rectangle(LARGHEZZA_RACCHETTE, ALTEZZA_RACCHETTE);
	
	Line separazione = new Line(0, 63, 400, 63);
	
	Pane quadro = new Pane();
	
	public void start(Stage finestra) throws Exception {
		
		Scene scena = new Scene(quadro, LARGHEZZA_AREA_GIOCO, ALTEZZA_AREA_GIOCO);
		scena.getStylesheets().add("it/edu/iisgubbio/animazioni/Pong.css");
		quadro.getStyleClass().add("sfondo");
		pFacile.getStyleClass().add("bottoni");
		pMedio.getStyleClass().add("bottoni");
		pDifficile.getStyleClass().add("bottoni");
		pImpossibile.getStyleClass().add("bottoni");
		pRicomincia.getStyleClass().add("bottoni");
		racchettaSinistra.getStyleClass().add("coloreElementi");
		racchettaDestra.getStyleClass().add("coloreElementi");
		pallino.getStyleClass().add("coloreElementi");
		ePunteggio1.getStyleClass().add("coloreLabel");
		ePunteggio2.getStyleClass().add("coloreLabel");
		eRegole.getStyleClass().add("coloreLabel");
		eVittoria.getStyleClass().add("coloreLabel");
		cerchioCountdown.getStyleClass().add("coloreLabel");
		eAvviso.setId("avviso");
	    eCountdown.setId("countdown");
	    separazione.setId("separazione");
	    
		pMenù.getStyleClass().add("menu");
		pMenù.setGraphic(iM);
		iM.setPreserveRatio(true);
		iM.setFitHeight(18);
		pIndietro.getStyleClass().add("menu");
		pIndietro.setGraphic(iF);
		iF.setPreserveRatio(true);
		iF.setFitHeight(18);
		
		finestra.setTitle("Pong");
	    finestra.setScene(scena);
	    finestra.show();
	    
	    timelineCountdown.setCycleCount(Timeline.INDEFINITE);
	    
	    quadro.getChildren().add(eDifficoltà);
	    quadro.getChildren().add(pFacile);
	    quadro.getChildren().add(pMedio);
	    quadro.getChildren().add(pDifficile);
	    quadro.getChildren().add(pImpossibile);
	    
	    racchettaSinistra.setX(X_RACCHETTA_SINISTRA);
	    racchettaSinistra.setY(Y_RACCHETTA_SINISTRA);
	    
	    racchettaDestra.setX(X_RACCHETTA_DESTRA);
	    racchettaDestra.setY(Y_RACCHETTA_DESTRA);
	    
	    eDifficoltà.setLayoutX(97);
	    eDifficoltà.setLayoutY(50);
	    eDifficoltà.getStyleClass().add("coloreLabel");
	    
	    
	    pFacile.setLayoutX(80);
	    pFacile.setLayoutY(120);
	    pFacile.setId("facile");
	    
	    pMedio.setLayoutX(240);
	    pMedio.setLayoutY(120);
	    pMedio.setId("medio");
	    
	    pDifficile.setLayoutX(80);
	    pDifficile.setLayoutY(220);
	    pDifficile.setId("difficile");
	    
	    pImpossibile.setLayoutX(240);
	    pImpossibile.setLayoutY(220);
	    pImpossibile.setId("impossibile");
	    
	    pFacile.setOnAction(e -> facile());
	    pMedio.setOnAction(e -> medio());
	    pDifficile.setOnAction(e -> difficile());
	    pImpossibile.setOnAction(e -> impossibile());
	    pMenù.setOnAction(e -> menù());
	    pIndietro.setOnAction(e -> indietro());
	    pRicomincia.setOnAction(e -> menù());
	    
	    scena.setOnKeyPressed(e -> pigiato(e));
	      
	}
	
	private void facile(){
		quadro.getChildren().clear();
		velocitàRacchette=8;
		velocitàPallino=20;
		
		punteggio1=0;
		punteggio2=0;
		
		contatoreCountdown=0;
		secondi=3;
		
		quadro.getChildren().add(cerchioCountdown);
		quadro.getChildren().add(eCountdown);
		quadro.getChildren().add(eRegole);
		
		cerchioCountdown.setCenterX(200);
	    cerchioCountdown.setCenterY(175);
	    
	    eCountdown.setLayoutX(195);
	    eCountdown.setLayoutY(162);
	    
	    eRegole.setLayoutX(34);
	    eRegole.setLayoutY(50);
	    
	    timelineCountdown.play();
		
		xPallino=200;
    	yPallino=210;
    	racchettaSinistra.setY(Y_RACCHETTA_SINISTRA);
    	racchettaDestra.setY(Y_RACCHETTA_DESTRA);
    	  
	}
	
	private void medio(){
		quadro.getChildren().clear();
		velocitàRacchette=6;
		velocitàPallino=15;
		
		punteggio1=0;
		punteggio2=0;
		
		contatoreCountdown=0;
		secondi=3;
		
		quadro.getChildren().add(cerchioCountdown);
		quadro.getChildren().add(eCountdown);
		quadro.getChildren().add(eRegole);
		
		cerchioCountdown.setCenterX(200);
	    cerchioCountdown.setCenterY(175);
	    
	    eCountdown.setLayoutX(195);
	    eCountdown.setLayoutY(160);
	    
	    eRegole.setLayoutX(34);
	    eRegole.setLayoutY(50);
		
	    timelineCountdown.play();
	    
	    xPallino=200;
    	yPallino=210;
    	racchettaSinistra.setY(Y_RACCHETTA_SINISTRA);
    	racchettaDestra.setY(Y_RACCHETTA_DESTRA);
	    
	}
	
	private void difficile(){
		quadro.getChildren().clear();
		velocitàRacchette=4;
		velocitàPallino=10;
		
		punteggio1=0;
		punteggio2=0;
		
		contatoreCountdown=0;
		secondi=3;
		
		quadro.getChildren().add(cerchioCountdown);
		quadro.getChildren().add(eCountdown);
		quadro.getChildren().add(eRegole);
		
		cerchioCountdown.setCenterX(200);
	    cerchioCountdown.setCenterY(175);
	    
	    eCountdown.setLayoutX(195);
	    eCountdown.setLayoutY(160);
	    
	    eRegole.setLayoutX(34);
	    eRegole.setLayoutY(50);

	    timelineCountdown.play();
	    
	    xPallino=200;
    	yPallino=210;
    	racchettaSinistra.setY(Y_RACCHETTA_SINISTRA);
    	racchettaDestra.setY(Y_RACCHETTA_DESTRA);
	      
	}
	
	private void impossibile(){
		quadro.getChildren().clear();
		velocitàRacchette=2;
		velocitàPallino=5;
		
		punteggio1=0;
		punteggio2=0;
		
		contatoreCountdown=0;
		secondi=3;
		
		quadro.getChildren().add(cerchioCountdown);
		quadro.getChildren().add(eCountdown);
		quadro.getChildren().add(eRegole);
		
		cerchioCountdown.setCenterX(200);
	    cerchioCountdown.setCenterY(175);
	    
	    eCountdown.setLayoutX(195);
	    eCountdown.setLayoutY(160);
	    
	    eRegole.setLayoutX(34);
	    eRegole.setLayoutY(50);
		
	    timelineCountdown.play();
	    
	    xPallino=200;
    	yPallino=210;
    	racchettaSinistra.setY(Y_RACCHETTA_SINISTRA);
    	racchettaDestra.setY(Y_RACCHETTA_DESTRA);
	     
	}
	private void countdown(){
		eCountdown.setVisible(true);
		cerchioCountdown.setVisible(true);
		eRegole.setVisible(true);
		
		eCountdown.setText(""+ secondi);
		secondi-=1;	
		contatoreCountdown+=1;
		if(contatoreCountdown==4) {
			timelineCountdown.stop();

			eCountdown.setVisible(false);
			cerchioCountdown.setVisible(false);
			eRegole.setVisible(false);
			
			quadro.getChildren().add(ePunteggio1);
			quadro.getChildren().add(ePunteggio2);
			quadro.getChildren().add(pallino);
		    quadro.getChildren().add(racchettaSinistra);
		    quadro.getChildren().add(racchettaDestra);
		    quadro.getChildren().add(pMenù);
		    quadro.getChildren().add(separazione);
		    
		    ePunteggio1.setLayoutX(90);
		    ePunteggio1.setLayoutY(20);
		    
		    ePunteggio2.setLayoutX(295);
		    ePunteggio2.setLayoutY(20);
		    
		    pMenù.setLayoutX(12);
		    pMenù.setLayoutY(12);
		    
		    ePunteggio1.setText("" + punteggio1);
			ePunteggio2.setText("" + punteggio2);
		    
		    timelinePallino = new Timeline(new KeyFrame(
					Duration.millis(velocitàPallino),
					x -> movimentoPallino()));
			timelinePallino.setCycleCount(Timeline.INDEFINITE);
		    timelinePallino.play();
		    
		}
	}
	
	private void pigiato(KeyEvent evento) {
		if (evento.getText().equals("w")) {
			if ((racchettaSinistra.getY() )<=65) {
				
			}else {
				racchettaSinistra.setY(racchettaSinistra.getY() - velocitàRacchette);
			}
		} 
		if (evento.getText().equals("s")) {
			if ((racchettaSinistra.getY()+ALTEZZA_RACCHETTE)>=(ALTEZZA_AREA_GIOCO)) {
				
			}else {
				racchettaSinistra.setY(racchettaSinistra.getY() + velocitàRacchette);
			}
			
		}
		if (evento.getText().equals("o")) {
			if ((racchettaDestra.getY() )<=65) {
				
			}else {
				racchettaDestra.setY(racchettaDestra.getY() - velocitàRacchette);
			}
		}
		if (evento.getText().equals("l")) {
			if ((racchettaDestra.getY() + ALTEZZA_RACCHETTE)>=ALTEZZA_AREA_GIOCO) {
				
			}else {
				racchettaDestra.setY(racchettaDestra.getY() + velocitàRacchette);
			}
		}
	}
	
	private void movimentoPallino(){
		
		Bounds boundRacchettaSinistra = racchettaSinistra.getBoundsInParent();
        Bounds boundRacchettaDestra = racchettaDestra.getBoundsInParent();
        Bounds boundPallino = pallino.getBoundsInParent();
        
        if(boundPallino.intersects(boundRacchettaSinistra)) {
            avanti=true;
        }
        
        if(boundRacchettaDestra.intersects(boundPallino)) {
            avanti=false;
        }
        
        if(xPallino>=LARGHEZZA_AREA_GIOCO) {
        	avanti=(Math.random()>0.5);
        	sopra=(Math.random()>0.5);
        	xPallino=200;
        	yPallino=210;
        	punteggio1+=1;
        	ePunteggio1.setText(""+ punteggio1);
        }
        if(xPallino<=0) {
        	avanti=(Math.random()>0.5);
        	sopra=(Math.random()>0.5);
        	xPallino=200;
        	yPallino=210;
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
		if(yPallino<=70) {
			sopra=true;
		}
		if(sopra==false) {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterY(yPallino -= numeroRandom);
			
		} else {
			numeroRandom = (Math.random()*0.4)+0.8;
			pallino.setCenterY(yPallino += numeroRandom);
			
		}
		if(punteggio1==10) {
			pallino.setCenterX(400);
			pallino.setCenterY(400);
			quadro.getChildren().add(eVittoria);
			eVittoria.setText("Giocatore 1 ha vinto!");
			eVittoria.setLayoutX(100);
		    eVittoria.setLayoutY(120);
		    quadro.getChildren().add(pRicomincia);
		    pRicomincia.setLayoutX(158);
		    pRicomincia.setLayoutY(170);
		    timelinePallino.stop();
		}
		if(punteggio2==10) {
			pallino.setCenterX(400);
			pallino.setCenterY(400);
			quadro.getChildren().add(eVittoria);
			eVittoria.setText("Giocatore 2 ha vinto!");
			eVittoria.setLayoutX(100);
		    eVittoria.setLayoutY(120);
		    quadro.getChildren().add(pRicomincia);
		    pRicomincia.setLayoutX(158);
		    pRicomincia.setLayoutY(170);
		    timelinePallino.stop();
		}
	}
	private void menù(){
		timelinePallino.stop();
		quadro.getChildren().clear();
		
		quadro.getChildren().add(eDifficoltà);
	    quadro.getChildren().add(pFacile);
	    quadro.getChildren().add(pMedio);
	    quadro.getChildren().add(pDifficile);
	    quadro.getChildren().add(pImpossibile);
	    quadro.getChildren().add(pIndietro);
	    quadro.getChildren().add(eAvviso);
	    
	    eAvviso.setLayoutX(23);
	    eAvviso.setLayoutY(305);
	    
	    pIndietro.setLayoutX(12);
	    pIndietro.setLayoutY(12);      
	}
	private void indietro(){
		contatoreCountdown=0;
		secondi=3;
		quadro.getChildren().clear();
		
		quadro.getChildren().add(cerchioCountdown);
		quadro.getChildren().add(eCountdown);
		
		cerchioCountdown.setCenterX(200);
	    cerchioCountdown.setCenterY(175);
	    
	    eCountdown.setLayoutX(194);
	    eCountdown.setLayoutY(162);
	    
	    timelineCountdown.play();
		
	}
	public static void main(String args[]){
		launch();
	}
}
