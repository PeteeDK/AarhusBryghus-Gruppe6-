package gui;

import model.Salg;
import model.rabat.AftaltPrisRabat;
import model.rabat.ProcentvisRabat;
import model.rabat.Rabat;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RabatWindow extends Stage {
    private Salg salg;
    private TextField txfBeløb;
    private Label lblError;
	private ToggleGroup rabatform;
	private Rabat rabat = null;
	private TextField txfResterendeBeløb; 
	private TextField txfFratrækkePris;
	private TextField txfProcentvisRabat; 


	
    public RabatWindow(String title, Salg salg) {
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

    public RabatWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDato = new Label("Vælg rabatform:");
        pane.add(lblDato, 0, 0);

        Label lblFratrækketPris = new Label("Fratrække beløb (Aftalt pris):");
        pane.add(lblFratrækketPris, 0, 1);

        txfFratrækkePris = new TextField();
        pane.add(txfFratrækkePris, 1, 1);
        txfFratrækkePris.setPrefWidth(50); 
        txfFratrækkePris.setText(""+0);
        

        Label lblProcentvisRabat = new Label("Tildel procentvis rabat:");
        pane.add(lblProcentvisRabat, 0, 2);

        txfProcentvisRabat = new TextField();
        pane.add(txfProcentvisRabat, 1, 2);
        txfProcentvisRabat.setPrefWidth(50); 
        txfProcentvisRabat.setText(""+0);
         
        //------radiobuttons------------------------------------
        
		HBox box = new HBox();
		rabatform = new ToggleGroup();
		String[] betalingsformer = { "      " , "Fratrække beløb", "Procentvisrabat" };
		RadioButton rb;
		for (int i = 0; i < betalingsformer.length; i++) {
			rb = new RadioButton();
			rb.setToggleGroup(rabatform);
			rb.setText(betalingsformer[i]);
			box.getChildren().add(rb);
		}
		pane.add(box, 0, 4, 4, 1);
		rabatform.getToggles().get(0).setSelected(true);

		rabatform.selectedToggleProperty().addListener(event -> toggleRadioButton());

		//--------------------------------------------------------

        
        Label lblResterendeBeløb = new Label("Resterende beløb:");
        pane.add(lblResterendeBeløb, 3, 0);

        txfResterendeBeløb = new TextField();
        pane.add(txfResterendeBeløb, 3, 1);
        txfResterendeBeløb.setPrefWidth(50);
        txfResterendeBeløb.setEditable(false);
        
        txfResterendeBeløb.setText(""+salg.getFuldBeløb());
        
        Button btnTildelRabat = new Button("Tildel rabat");
        pane.add(btnTildelRabat, 3, 6);
        GridPane.setHalignment(btnTildelRabat, HPos.RIGHT);
        btnTildelRabat.setOnAction(event -> this.tildelRabat());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }


    private void tildelRabat() {
    	if(rabat == null) {
    		return;
    	}
    	
    	System.out.println("BetalingsformWindow -> registrerBetaling(): "+salg.getFuldBeløb());

    	//det er ikke strategy pattern, det er polymorfi, men det virker lige så godt
    	salg.setRabat(rabat);
    	
		this.hide();
		
    }

    
	
	private void toggleRadioButton() {
		RadioButton rb = (RadioButton) rabatform.getSelectedToggle();
		
		switch(rb.getText()){
			case "Fratrække beløb":
				rabat = new AftaltPrisRabat(Double.parseDouble(txfFratrækkePris.getText().trim()));
				break;
			case "Procentvisrabat":
				rabat = new ProcentvisRabat(Double.parseDouble(txfProcentvisRabat.getText().trim()));
				break;
			default:
		}
		
		txfResterendeBeløb.setText(""+rabat.tildelRabat(salg.getFuldBeløb()));
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
