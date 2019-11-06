package gui.window;

import controller.Controller;
import controller.StatistikCtlr;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class KlipWindow extends Stage {
    private Label lblError;
    private LocalDate ld; 
	private DatePicker dp = new DatePicker();
	private LocalDate startDato;
	private LocalDate slutDato;
	private ListView<String> lvwBrugteKlip;
	private boolean brugt;
	private ToggleGroup brugtStatus; 


	
    public KlipWindow(String title, LocalDate startDato, LocalDate slutDato) {
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

    public KlipWindow(String title) {
        this(title, null, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblStudieRabat = new Label("Klippekort udstedt mellem " + startDato + " og " + slutDato);
        pane.add(lblStudieRabat, 0, 0);

		lvwBrugteKlip = new ListView<>();
		pane.add(lvwBrugteKlip, 0, 2, 1, 3);
		lvwBrugteKlip.setPrefWidth(100);
		lvwBrugteKlip.setPrefHeight(100);
		//true = "klip der er brugt" og false = "klip der ikke er brugt"
		lvwBrugteKlip.getItems().setAll(StatistikCtlr.getBrugteKlipMellemStartOgSlut(startDato, slutDato, brugt));

        //------radiobuttons------------------------------------
        
		HBox box = new HBox();
		brugtStatus = new ToggleGroup();
		String[] brugtStatusser = { "    ", "Brugte klip", "Ikke brugte klip" };
		RadioButton rb;
		for (int i = 0; i < brugtStatusser.length; i++) {
			rb = new RadioButton();
			rb.setToggleGroup(brugtStatus);
			rb.setText(brugtStatusser[i]);
			box.getChildren().add(rb);
		}
		pane.add(box, 0, 1, 4, 1);
		brugtStatus.getToggles().get(0).setSelected(true);

		brugtStatus.selectedToggleProperty().addListener(event -> toggleRadioButton());

		//--------------------------------------------------------

		
		
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

	private void toggleRadioButton() {
		RadioButton rb = (RadioButton) brugtStatus.getSelectedToggle();
		
		switch(rb.getText()){
			case "Brugte klip":
				brugt = true;
				break;
			case "Ikke brugte klip":
				brugt = false;
				break;
			default:
		}
		lvwBrugteKlip.getItems().setAll(StatistikCtlr.getBrugteKlipMellemStartOgSlut(startDato, slutDato, brugt));
	}

	private void initControls() {
    }

    // -------------------------------------------------------------------------



}
