package gui;

import controller.Controller;
import controller.StatistikCtlr;
import model.Rundvisning;
import model.rabat.StudieRabat;
import model.Pris;
import model.Produkt;
import model.ProduktLinje;
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

public class IkkeAfleveredeAnlægWindow extends Stage {
    private Label lblError;
	private DatePicker dp = new DatePicker();
	private LocalDate startDato;
	private LocalDate slutDato;
	private ListView<Produkt> lvwIkkeAfleveredeAnlæg; 

	
    public IkkeAfleveredeAnlægWindow(String title, LocalDate startDato, LocalDate slutDato) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL); 
        this.setResizable(false); 
  
        this.startDato = startDato;
        this.slutDato = slutDato;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public IkkeAfleveredeAnlægWindow(String title) {
        this(title, null, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblStudieRabat = new Label("Ikke afleverede anlæg mellem " + startDato + " og " + slutDato);
        pane.add(lblStudieRabat, 0, 0);

		lvwIkkeAfleveredeAnlæg = new ListView<>();
		pane.add(lvwIkkeAfleveredeAnlæg, 0, 2, 1, 3);
		lvwIkkeAfleveredeAnlæg.setPrefWidth(100);
		lvwIkkeAfleveredeAnlæg.setPrefHeight(100);
		lvwIkkeAfleveredeAnlæg.getItems().setAll(StatistikCtlr.getIkkeAfleveredeAnlægMellemStartOgSlut(startDato, slutDato));

        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }
 
    private void initControls() {
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
    }


}
