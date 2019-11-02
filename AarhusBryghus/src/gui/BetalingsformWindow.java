package gui;

import controller.Controller;
import model.Rundvisning;
import model.Salg;
import model.betalingsform.*;
import model.rabat.StudieRabat;
import model.Pris;
import model.Produkt;
import model.Produkt.*;
import model.ProduktLinje;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class BetalingsformWindow extends Stage {
    private Salg salg;
    private TextField txfBeløb;
    private Label lblError;
    private LocalDate ld;
	private TextField txfDato;
	private ToggleGroup betalingsform;
	private Labeled lblTxt;
	private IBetalingsform ib = null;
	private ListView<Produkt> lvwKlippekort;
	private TextField txfResterendeBeløb;
	private double resterendeBeløb;
	private double beløb; 


	
    public BetalingsformWindow(String title, Salg salg) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.salg = salg;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public BetalingsformWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDato = new Label("Vælg betalingsform:");
        pane.add(lblDato, 0, 0);

        //------radiobuttons------------------------------------
        
		VBox box = new VBox();
		betalingsform = new ToggleGroup();
		String[] betalingsformer = { "Dankort", "MobilePay", "Kontant", "Regning", "Klip (klippekort)" };
		RadioButton rb;
		for (int i = 0; i < betalingsformer.length; i++) {
			rb = new RadioButton();
			rb.setToggleGroup(betalingsform);
			rb.setText(betalingsformer[i]);
			box.getChildren().add(rb);
		}
		pane.add(box, 0, 1, 4, 1);
		betalingsform.getToggles().get(0).setSelected(true);

		betalingsform.selectedToggleProperty().addListener(event -> toggleRadioButton());

		//--------------------------------------------------------
        
		lvwKlippekort = new ListView<>();
		pane.add(lvwKlippekort, 0, 5, 1, 3);
		lvwKlippekort.setPrefWidth(100);
		lvwKlippekort.setPrefHeight(100);
		lvwKlippekort.getItems().setAll(Controller.getSolgteKlippekort());

	
		
        Label lblBeløb = new Label("Beløb:");
        pane.add(lblBeløb, 3, 0);

        txfBeløb = new TextField();
        pane.add(txfBeløb, 3, 1);
        txfBeløb.setPrefWidth(50); 
        

        Label lblResterendeBeløb = new Label("Resterende beløb:");
        pane.add(lblResterendeBeløb, 5, 0);

        txfResterendeBeløb = new TextField();
        pane.add(txfResterendeBeløb, 5, 1);
        txfResterendeBeløb.setPrefWidth(50);
        txfResterendeBeløb.setEditable(false);
        
        txfResterendeBeløb.setText(""+salg.getFuldBeløb());
        
        Button btnRegistrerBetaling = new Button("Registrer betaling");
        pane.add(btnRegistrerBetaling, 4, 6);
        GridPane.setHalignment(btnRegistrerBetaling, HPos.RIGHT);
        btnRegistrerBetaling.setOnAction(event -> this.registrerBetaling());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    
	
	private void toggleRadioButton() {
		RadioButton rb = (RadioButton) betalingsform.getSelectedToggle();
		
		
		switch(rb.getText()){
			case "Dankort":
				ib = new Dankort();
				break;
			case "MobilePay":
				ib = new MobilePay();
				break;
			case "Kontant":
				ib = new Kontant();
				break;
			case "Regning":
				ib = new Regning();
				break;
			case "Klip (klippekort)":
				//TODO Skal håndtere at man kan vælge solgte(fra produktLinjer) klippekort fra listView
				ib = (IBetalingsform) lvwKlippekort.getSelectionModel().getSelectedItem();
				break;
			default:
		}
		
	}

    private void registrerBetaling() {
    	if(ib == null || Controller.getProduktlinjer().isEmpty()) {
    		return;
    	}
    	beløb = Double.parseDouble(txfBeløb.getText().trim());
    	salg.betaling(ib, beløb);
    	
    	System.out.println("BetalingsformWindow -> registrerBetaling(): "+salg.getFuldBeløb());

//    	if(resterendeBeløb < 0) {
//        	lblError.setText("Man kan ikke betale over det resterende beløb");
//            return;
//		}else if(resterendeBeløb == 0) {
//			salg.setFuldbeløb(0);
//			salg.setErBetalt(true);
//		}
		
		this.hide();
		
    }

    
	private void initControls() {
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
    	this.hide();
    }

    private void okAction() {

        int antalStuderende = 0;
        
        try {
            antalStuderende = Integer.parseInt(txfBeløb.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }

//        if (antalStuderende < 0 || antalStuderende > salg.getAntal()) {
//            lblError.setText("Antallet af studerende kan ikke være negativt eller kan ikke være større end antallet af alle til rundvisningen");
//            return;
//        }
        
        double rabatProcent = 0;
        
//        try {
//        	rabatProcent = Double.parseDouble(txfStudierabat.getText().trim());
//        } catch (NumberFormatException ex) {
//            // do nothing
//        }
//        if (rabatProcent < 0 || rabatProcent > 100) {
//            lblError.setText("Studierabatprocenten kan ikke være negativ eller over 100%");
//            return;
//        }


        // Call controller methods
//        if (salg != null && antalStuderende > 0) {
//        	Controller.createStudieRabat(salg, antalStuderende, rabatProcent);	
//        }

        this.hide();
    }

}
