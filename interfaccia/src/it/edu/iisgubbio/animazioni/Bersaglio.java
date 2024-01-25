package it.edu.iisgubbio.animazioni;



import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bersaglio extends Application{
	Pane spazio = new Pane();
	Timeline timeline;
	Circle pallinoVerde;
	Label ePunteggio1 = new Label("");
	int punteggio1=0;
	public void start(Stage finestra) {
		spazio.getChildren().add(ePunteggio1);
		spazio.addEventHandler(
				MouseEvent.MOUSE_CLICKED,
				e -> gestore(e)
		);
	    
		ePunteggio1.setLayoutX(100);
		ePunteggio1.setLayoutY(10);
		    
		timeline = new Timeline(new KeyFrame(
				Duration.seconds(2),
				x -> aggiornaTimer()));
		timeline.setCycleCount(Timeline.INDEFINITE);
	    timeline.play();
	    Scene scene = new Scene(spazio,400,400);
	    
	    finestra.setTitle("Coordinate"); 
		finestra.setScene(scene);
		finestra.show();
		
		
	}
	private void gestore(MouseEvent e) {
		double distanza=Math.sqrt((e.getX()-pallinoVerde.getCenterX())*(e.getX()-pallinoVerde.getCenterX())+(e.getY()-pallinoVerde.getCenterY())*(e.getY()-pallinoVerde.getCenterY()));
		if(e.getButton().equals(MouseButton.PRIMARY)) {
			if(pallinoVerde.getRadius()>=distanza) {
				punteggio1++;
			}
		}
		ePunteggio1.setText(""+punteggio1);
		System.out.println(punteggio1);
	}
	private void aggiornaTimer(){
		spazio.getChildren().clear();
		spazio.getChildren().add(ePunteggio1);
		pallinoVerde = new Circle(15);
		spazio.getChildren().add(pallinoVerde);
		pallinoVerde.setCenterX(Math.random()*350);
		pallinoVerde.setCenterY(Math.random()*350);
		
	
	}
	public static void main(String args[]){
		launch();
	}
}
