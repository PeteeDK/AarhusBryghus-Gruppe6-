package gui;

import controller.Controller;
import model.*;
import model.produkter.Sampakninger;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SampakningerWindow extends Stage {
    private Produkt produkt;
    private Label lblError;
	private ListView<Pris> lvwFlasker;
	private ListView<Produkt> lvwTilføjetTilSampakninger;
	
    public SampakningerWindow(String title, Produkt produkt) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.produkt = produkt;

        //opretter sampakninger og gemmer i storage
        
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public SampakningerWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
//        pane.setHgap(100);
        pane.setMaxSize(500, 500);
//        pane.setVgap(100);
        pane.setGridLinesVisible(false);

        
		Label lblFlasker = new Label("Vælg flasker der skal i:");
		pane.add(lblFlasker, 0, 0);

		lvwFlasker = new ListView<>();
		pane.add(lvwFlasker, 0, 1, 1, 5);
		lvwFlasker.setPrefWidth(200);
		lvwFlasker.setPrefHeight(200);									//TODO Skal arrangement fra comboboxen sætte arrangementet i stedet for at hard-coder det
		lvwFlasker.getItems().setAll(Controller.getPriserEfterArrangementOgKategori("butik", "flaske"));

		Label lblIntroduktion = new Label("(Sampakningerne indeholder det samme)");
		pane.add(lblIntroduktion, 5, 0);
		
		Label lblTilføjetTilSampakning = new Label("Tilføj til sampakning:");
		pane.add(lblTilføjetTilSampakning, 5, 1);
		
		lvwTilføjetTilSampakninger = new ListView<>();
		pane.add(lvwTilføjetTilSampakninger, 5, 2, 1, 5);
		lvwTilføjetTilSampakninger.setPrefWidth(200);
		lvwTilføjetTilSampakninger.setPrefHeight(200);
		lvwTilføjetTilSampakninger.getItems().setAll(((Sampakninger) produkt).getIndholdEnheder());
        
		initGlas();
		
        Button btnTilføjFlaske = new Button("Tilføj flask");
        pane.add(btnTilføjFlaske, 3, 1);
        btnTilføjFlaske.setOnAction(event -> this.tilføjFlaske());
  
        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }
    
    private void initGlas() {
		//tilføjer glas til hver sampakning som er gemt i storage
		while(((Sampakninger) produkt).getAntalGlas() != 0) {
			((Sampakninger) produkt).addIndhold(Controller.getGlas());
			lvwTilføjetTilSampakninger.getItems().setAll(((Sampakninger) produkt).getIndholdEnheder());
		}

    }


	private void tilføjFlaske() {
    	Pris flaske = lvwFlasker.getSelectionModel().getSelectedItem();
		if (flaske == null) {
			return;
		}
		
		((Sampakninger) produkt).addIndhold(flaske.getProdukt());

		lvwTilføjetTilSampakninger.getItems().setAll(((Sampakninger) produkt).getIndholdEnheder());

	}

	private void initControls() {
		return;
	}

    // -------------------------------------------------------------------------

    private void cancelAction() {
    	this.hide();
    }

    private void okAction() {

        this.hide();
    }

}
