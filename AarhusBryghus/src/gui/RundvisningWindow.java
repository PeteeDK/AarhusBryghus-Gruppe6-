package gui;

import controller.Controller;
import model.Rundvisning;
import model.rabat.StudieRabat;
import model.Pris;
import model.ProduktLinje;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.time.LocalDate;

public class RundvisningWindow extends Stage {
    private ProduktLinje rundvisning;
    private TextField txfAntalStuderende;
    private Label lblError;
    private LocalDate ld;
	private TextField txfDato;
	private DatePicker dp = new DatePicker();
	private TextField txfStudierabat;
	
    public RundvisningWindow(String title, ProduktLinje rundvisning) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL); 
        this.setResizable(false); 
  
        this.rundvisning = rundvisning; 

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public RundvisningWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblAntalStuderende = new Label("Angiv antal studerende:");
        pane.add(lblAntalStuderende, 0, 0);

        txfAntalStuderende = new TextField();
        pane.add(txfAntalStuderende, 0, 1);
        txfAntalStuderende.setPrefWidth(200);
 
        Label lblStudieRabat = new Label("Angiv studierabat:");
        pane.add(lblStudieRabat, 0, 2);

        txfStudierabat = new TextField();
        pane.add(txfStudierabat, 0, 3);
        txfStudierabat.setPrefWidth(200);

        Label lblDato = new Label("Vælg dato:");
        pane.add(lblDato, 0, 4);
        
        Button btnDato = new Button("Sæt dato");
        pane.add(btnDato, 0, 5);
        GridPane.setHalignment(btnDato, HPos.LEFT);
        btnDato.setOnAction(event -> this.kalender());
        
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 6);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void kalender() {

    	GridPane root = new GridPane();
    	root.getChildren().add(dp);
    	
    	Scene scene = new Scene(root, 250, 200);
    	this.setScene(scene);
    	
    	dp.setOnAction(e -> {
    		ld = dp.getValue(); 
    		System.out.println("[Rundvisning -> kørDatePicker()] "+ld);
    		Rundvisning r = (Rundvisning) rundvisning.getPrisObj().getProdukt();
    		r.setDato(ld); 
    	});
    	
    	Button btnCancel = new Button("OK");
        root.add(btnCancel, 0, 5);
        btnCancel.setOnAction(event -> this.okAction());	
	}
     

    private void initControls() {
        if (rundvisning.getPrisObj().getProdukt() != null) {
            txfAntalStuderende.setText(""+0);
            txfAntalStuderende.setText(""+0);
        } else {
            txfAntalStuderende.clear();
            txfAntalStuderende.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
    	this.hide();
    }

    private void okAction() {
    	
    	if(ld == null) {
    		return;
    	}

        int antalStuderende = 0;
        
        try {
            antalStuderende = Integer.parseInt(txfAntalStuderende.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (antalStuderende < 0 || antalStuderende > rundvisning.getAntal()) {
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
        if (rundvisning != null && antalStuderende > 0) {
            rundvisning.setStudieRabat(Controller.createStudieRabat(rundvisning, antalStuderende, rabatProcent));	
        }
        
        System.out.println("RundvisningWindow -> okAction(): "+rundvisning.getPris());
        
        this.hide();
    }

}
