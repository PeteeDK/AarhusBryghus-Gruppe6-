package gui;

import controller.Controller;
import model.*;
import model.rabat.StudieRabat;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class AnlægWindow extends Stage {
    private ProduktLinje anlæg;
    private TextField txfAntalStuderende;
    private Label lblError;
    private LocalDate ld;
	private TextField txfDato;
	private DatePicker dp = new DatePicker();
	private TextField txfStudierabat;
	private ListView<Pris> lvwKulsyre;
	private ListView<Pris> lvwFustage;
	private ListView<Produkt> lvwTilbehør;
	
    public AnlægWindow(String title, ProduktLinje anlæg) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.anlæg = anlæg;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public AnlægWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
//        pane.setHgap(100);
        pane.setMaxSize(500, 500);
//        pane.setVgap(100);
        pane.setGridLinesVisible(false);

        
		Label lblKulsyre = new Label("Kulsyrer");
		pane.add(lblKulsyre, 0, 0);

		lvwKulsyre = new ListView<>();
		pane.add(lvwKulsyre, 0, 1, 1, 5);
		lvwKulsyre.setPrefWidth(200);
		lvwKulsyre.setPrefHeight(200);									//TODO Skal arrangement fra comboboxen sætte arrangementet i stedet for at hard-coder det
		lvwKulsyre.getItems().setAll(Controller.getPriserEfterArrangementOgKategori("butik", "kulsyre"));

        
		Label lblFustage = new Label("Fustager:");
		pane.add(lblFustage, 0, 7);
		
		lvwFustage = new ListView<>();
		pane.add(lvwFustage, 0, 8, 1, 5);
		lvwFustage.setPrefWidth(200);
		lvwFustage.setPrefHeight(200);
		lvwFustage.getItems().setAll(Controller.getPriserEfterArrangementOgKategori("butik", "fustage"));

		
		
		Label lblTilbehør = new Label("Tilbehør:");
		pane.add(lblTilbehør, 5, 7);
		
		lvwTilbehør = new ListView<>();
		pane.add(lvwTilbehør, 5, 8, 1, 5);
		lvwTilbehør.setPrefWidth(200);
		lvwTilbehør.setPrefHeight(200);
		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getPrisObj().getProdukt()).getTilbehørsProdukter());
        
        Button btnTilføjKulsyre = new Button("Tilføj kulsyre");
        pane.add(btnTilføjKulsyre, 3, 1);
        btnTilføjKulsyre.setOnAction(event -> this.tilføjKulsyre());
  
        Button btnTilføjFustage = new Button("Tilføj fustage");
        pane.add(btnTilføjFustage, 3, 3);
        btnTilføjFustage.setOnAction(event -> this.tilføjFustage());
        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    

    private void tilføjFustage() {
    	Pris fustage = lvwFustage.getSelectionModel().getSelectedItem();
		if (fustage == null) {
			return;
		}

		((Anlæg) anlæg.getPrisObj().getProdukt()).addTilbehør(fustage);

		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getPrisObj().getProdukt()).getTilbehørsProdukter());

    }

	private void tilføjKulsyre() {
    	Pris kulsyre = lvwKulsyre.getSelectionModel().getSelectedItem();
		if (kulsyre == null) {
			return;
		}

		((Anlæg) anlæg.getPrisObj().getProdukt()).addTilbehør(kulsyre);

		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getPrisObj().getProdukt()).getTilbehørsProdukter());

	}

	private void initControls() {
		return;
	}

    // -------------------------------------------------------------------------

    private void cancelAction() {
    	this.hide();
    }

    private void okAction() {

        int antalStuderende = 0;
        
        try {
            antalStuderende = Integer.parseInt(txfAntalStuderende.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (antalStuderende < 0 || antalStuderende > anlæg.getAntal()) {
            lblError.setText("Antallet af studerende kan ikke være negativt eller kan ikke være større end antallet af alle til rundvisningen");
            return;
        }
        
        double rabatProcent = 0;
        
        try {
        	rabatProcent = Double.parseDouble(txfStudierabat.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (rabatProcent < 0 || rabatProcent > 100) {
            lblError.setText("Studierabatprocenten kan ikke være negativ eller over 100%");
            return;
        }


        // Call controller methods
        if (anlæg != null && antalStuderende > 0) {
        	Controller.createStudieRabat(anlæg, antalStuderende, rabatProcent);	
        }

        this.hide();
    }

}
