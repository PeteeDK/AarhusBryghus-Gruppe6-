package gui;

import java.util.ArrayList;
import java.util.Observable;

import controller.Controller;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Pris;
import model.PrisListe;
import model.Produkt;
import storage.Storage;

public class FredagsSalgPane extends Stage {
	
	private Button TilKurv;
	private ListView<Pris>lvwButiksSalg;
	private ListView<String> kurveOversigt;
	private RadioButton salgssituation;
    
	
	
	
	private void initContent(GridPane pane) {
		
		Scene scene = new Scene(pane);
		this.setScene(scene);
		GridPane pane = new GridPane(); 
		
		pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10); 
		
		HBox hbox1 = new HBox(); 
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		VBox vbox3 = new VBox();
		
		pane.add(hbox1, 0, 0);
		hbox1.getChildren().add(vbox1);
		hbox1.getChildren().add(vbox2);
		hbox1.getChildren().add(vbox3);
		
		pane.add(vbox1, 0, 1);
		vbox1.getChildren().add(lvwButiksSalg);
		
		lvwButiksSalg = new ListView<>(); 
		lvwButiksSalg.getItems().setAll(Controller.getPriser());
		

	}
	
	

}