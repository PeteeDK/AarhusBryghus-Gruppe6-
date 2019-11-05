package gui;

import controller.Controller;
import controller.StatistikCtlr;
import model.Salg;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class SalgForPeriodeWindow extends Stage {
    private Label lblError; 
    private LocalDate startDato;
	private LocalDate slutDato;
	private ListView<Salg> lvwSalg;

	
    public SalgForPeriodeWindow(String title, LocalDate startDato, LocalDate slutDato) {
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

    public SalgForPeriodeWindow(String title) {
        this(title, null, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblStudieRabat = new Label("Salg registreret mellem " + startDato + " og " + slutDato);
        pane.add(lblStudieRabat, 0, 0);

		lvwSalg = new ListView<>();
		pane.add(lvwSalg, 0, 2, 1, 3);
		lvwSalg.setPrefWidth(100);
		lvwSalg.setPrefHeight(100);
		lvwSalg.getItems().setAll(StatistikCtlr.getDagensSalgMellemStartOgSlut(startDato, slutDato));

        
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
