package it.edu.iisgubbio.animazioni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer extends Application{
	Label timer = new Label("timer");
	Button pStart = new Button("start");
	Button pPausa = new Button("pausa");
	int n=100;
	Timeline timeline;
	public void start(Stage finestra) throws Exception {
	    GridPane griglia = new GridPane();
	    griglia.add(pStart,  0,  0);
	    griglia.add(pPausa, 1, 0);
	    griglia.add(timer, 0, 1, 2, 1);
	    
	    griglia.setPadding(new Insets(10, 10, 10, 10));
		griglia.setHgap(22); 
		griglia.setVgap(10);
	    
	    Scene scene = new Scene(griglia,200,100);
	    
	    scene.getStylesheets().add("it/edu/iisgubbio/animazioni/Timer.css");
	    timer.setAlignment(Pos.CENTER);
	    
	    finestra.setTitle("Timer!"); 
	    finestra.setScene(scene);
	    finestra.show();
	    timeline = new Timeline(new KeyFrame(
	      Duration.millis(16), // ogni quanto va chiamata la funzione
	      x -> aggiornaTimer()));
	    timeline.setCycleCount(Timeline.INDEFINITE);
	    
	    pStart.setOnAction(e -> timeline.play());
	    pPausa.setOnAction(e -> fermati());
	  }
	  private void aggiornaTimer(){
	    timer.setText(""+ (n--));
	  }
	  
	  private void fermati() {
		  timeline.pause();
	  }
	    
	  public static void main(String args[]){
	    launch();
	  }
}
