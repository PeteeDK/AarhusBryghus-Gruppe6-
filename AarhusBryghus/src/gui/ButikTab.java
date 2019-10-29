package gui;



import java.util.ArrayList;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Pris;


public class ButikTab {

	private Tab tab; 
	private ListView<Pris> produkter;
	private ListView<String> kurv; 
	private TextField antal; 
	
	private ArrayList<String> midlertigtkurv = new ArrayList<>();
	
	
	public ButikTab (Tab tab) {
		this.tab = tab; 
	}
	
	public void open() {
		
		Controller.initStorage();
	
		Label lb1 = new Label("Produkter"); 
		produkter = new ListView<>();
		produkter.getItems().setAll(Controller.getPriser("Butikspris"));
		
		
		
		antal = new TextField();
		antal.setPromptText("Antal");
		antal.setEditable(true);
		
		
		Button bnt1 = new Button("Tilføj produkt");
		bnt1.setOnAction(event -> this.tilføjOnAction());
		
		
		
		Button bnt2 = new Button("Slet produkt"); 
		Button bnt3 = new Button("Betal");
		bnt3.setOnAction(event -> this.betal());
		Button bnt4 = new Button("Tøm Kurv");
		Label lb2 = new Label("Kurv");
		kurv = new ListView<>();
		Label lb3 = new Label("Samlet pris");
		TextField txf2 = new TextField();
		txf2.setPromptText("Samlet pris");
		txf2.setEditable(false);
		
		HBox bgHbox = new HBox();
		VBox vb1 = new VBox(); 
		vb1.setPadding(new Insets(5,10,10,10));
		VBox vb2 = new VBox();
		vb2.setPadding(new Insets(22,10,10,10));
		VBox vb3 = new VBox();
		vb3.setPadding(new Insets(22,10,10,10));
		VBox vb4 = new VBox(); 
		vb4.setPadding(new Insets(5,10,10,10));
		
		bgHbox.getChildren().addAll(vb1,vb2,vb3,vb4);
		
		vb1.getChildren().addAll(lb1,produkter);
		vb2.getChildren().addAll(antal, bnt1, bnt2);
		vb3.getChildren().addAll(bnt3, bnt4);
		vb4.getChildren().addAll(lb2,kurv,lb3,txf2);
		
		tab.setContent(bgHbox);	
		
	}
	
	public void tilføjOnAction() {
		Pris valgtØl = produkter.getSelectionModel().getSelectedItem();
		int antalValgt = Integer.parseInt(antal.getText());
		midlertigtkurv.add(valgtØl + antalValgt);
        kurv.getItems().setAll(midlertigtkurv);
	}
	
	private void betal() {
		
		Betalingsforms bf = new Betalingsforms("Betalingsform"); 
		bf.showAndWait();
	}
	
	
	
}
