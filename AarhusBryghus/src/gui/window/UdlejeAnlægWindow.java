package gui.window;

import controller.AnlægCtlr;
import model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class UdlejeAnlægWindow extends Stage {
    private Pris anlæg;
    private Label lblError;
    private LocalDate ld;
	private ListView<Pris> lvwKulsyre;
	private ListView<Pris> lvwFustage;
	private ListView<Produkt> lvwTilbehør;
	private ToggleGroup udlejningsStatus;
	private boolean levering;
	private RadioButton rb;
	
    public UdlejeAnlægWindow(String title, Pris anlæg) {
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

    public UdlejeAnlægWindow(String title) {
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
		lvwKulsyre.getItems().setAll(AnlægCtlr.getPriserEfterArrangementOgKategori("butik", "kulsyre"));

        
		Label lblFustage = new Label("Fustager:");
		pane.add(lblFustage, 0, 7);
		
		lvwFustage = new ListView<>();
		pane.add(lvwFustage, 0, 8, 1, 5);
		lvwFustage.setPrefWidth(200);
		lvwFustage.setPrefHeight(200);
		lvwFustage.getItems().setAll(AnlægCtlr.getPriserEfterArrangementOgKategori("butik", "fustage"));

		
		
		Label lblTilbehør = new Label("Tilbehør:");
		pane.add(lblTilbehør, 5, 7);
		
		lvwTilbehør = new ListView<>();
		pane.add(lvwTilbehør, 5, 8, 1, 5); 
		lvwTilbehør.setPrefWidth(200);
		lvwTilbehør.setPrefHeight(200);
		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getProdukt()).getTilbehørsProdukter());
        
        Button btnTilføjKulsyre = new Button("Tilføj kulsyre");
        pane.add(btnTilføjKulsyre, 3, 1);
        btnTilføjKulsyre.setOnAction(event -> this.tilføjKulsyre());
  
        Button btnTilføjFustage = new Button("Tilføj fustage");
        pane.add(btnTilføjFustage, 3, 3);
        btnTilføjFustage.setOnAction(event -> this.tilføjFustage());

        Button btnFjern = new Button("Fjern tilbehør");
        pane.add(btnFjern, 4, 5);
        btnFjern.setOnAction(event -> this.fjernTilbehør());
        
        Button btnOk = new Button("Ok");
        pane.add(btnOk, 3, 5);
        btnOk.setOnAction(event -> this.okAction());

        
        
        //TODO Skal kunden også angive sine info her
        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

	
    private void fjernTilbehør() {
    	Pris tilbehør = lvwFustage.getSelectionModel().getSelectedItem();
		if (tilbehør == null) {
			return;
		}

		((Anlæg) anlæg.getProdukt()).removeTilbehør(tilbehør);

		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getProdukt()).getTilbehørsProdukter());
    }


	private void tilføjFustage() {
    	Pris fustage = lvwFustage.getSelectionModel().getSelectedItem();
		if (fustage == null) {
			return;
		}

		((Anlæg) anlæg.getProdukt()).addTilbehør(fustage);

		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getProdukt()).getTilbehørsProdukter());

    }

	private void tilføjKulsyre() {
    	Pris kulsyre = lvwKulsyre.getSelectionModel().getSelectedItem();
		if (kulsyre == null) {
			return;
		}

		((Anlæg) anlæg.getProdukt()).addTilbehør(kulsyre);

		lvwTilbehør.getItems().setAll(((Anlæg) anlæg.getProdukt()).getTilbehørsProdukter());

	}

	private void initControls() {
		return;
	}

    // -------------------------------------------------------------------------


    private void okAction() {
    	
        this.hide();
    }

}
