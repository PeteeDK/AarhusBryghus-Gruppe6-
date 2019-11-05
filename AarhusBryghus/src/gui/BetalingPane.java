package gui;


import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Pris;
import model.ProduktLinje;
import model.Salg;

public class BetalingPane extends GridPane {
	private TextField txfSamletPris, txfIgnore;
	private TextArea txaSalgsinfo;
	private ListView<ProduktLinje> lvwProduktlinjer;
	private BestillingPane bestilling;
	private Label lblError;
	//TODO Der skal evt. være en knap helt i starten der hedder "nyt salg", hvor man opretter et salg og gemmer det i storage
	private Salg salg;
	private double samletPris;
   

	public BetalingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		Label lblKurv = new Label("Kurv");
		this.add(lblKurv, 0, 0);

		lvwProduktlinjer = new ListView<>();
		this.add(lvwProduktlinjer, 0, 1, 1, 3);
		lvwProduktlinjer.setPrefWidth(200);
		lvwProduktlinjer.setPrefHeight(200);
		lvwProduktlinjer.getItems().setAll(Controller.getProduktlinjer());

		
		Label lblSamletPris = new Label("Samlet pris / Resterende beløb:");
		this.add(lblSamletPris, 1, 1);

		txfSamletPris = new TextField();
		this.add(txfSamletPris, 2, 1);
		txfSamletPris.setEditable(false);

		//--- Hvis jer fjerner disse komponenter vil tingene ikke blive vist i vinduet -----------------
		Label lblHours = new Label("");
		this.add(lblHours, 1, 2);

		txfIgnore = new TextField();
		this.add(txfIgnore, 2, 2);
		txfIgnore.setEditable(false);
		txfIgnore.setText("Ignore");

		
		//----------------------------------------------------------------------------------------------
	
		Label lblSalgsinfo = new Label("Salgsinfo:");
		this.add(lblSalgsinfo, 1, 3);
		GridPane.setValignment(lblSalgsinfo, VPos.BASELINE);
		lblSalgsinfo.setPadding(new Insets(4, 0, 4, 0));

		txaSalgsinfo = new TextArea();
		this.add(txaSalgsinfo, 2, 3);
		txaSalgsinfo.setPrefWidth(200);
		txaSalgsinfo.setPrefHeight(100);
		txaSalgsinfo.setEditable(false); 

		//TODO Kan ikke finde en måde at vise indholdet af kurven automatisk, når man åbner fanen
		Button btnViskurv = new Button("Opdater");
		this.add(btnViskurv, 0, 5);
		btnViskurv.setOnAction(event -> this.opdater());

		Button btnTildelRabat = new Button("Tildel rabat");
		this.add(btnTildelRabat, 1, 5);
		btnTildelRabat.setOnAction(event -> this.tildelRabat());

		Button btnAngivBetalingsform = new Button("Angiv betalingsform");
		this.add(btnAngivBetalingsform, 2, 5);
		btnAngivBetalingsform.setOnAction(event -> this.angivBetalingsform());
		
		Button btnRegistrerSalg = new Button("Nyt salg");
		this.add(btnRegistrerSalg, 2, 9);
		btnRegistrerSalg.setOnAction(event -> this.nytSalg());
		
		
        lblError = new Label();
        this.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");


		if (lvwProduktlinjer.getItems().size() > 0) {
			lvwProduktlinjer.getSelectionModel().select(0); 
		}
	}

	
	private void nytSalg() {
		salg = Controller.createSalg();
		
		Controller.tømProduktlinjer();
		
		System.out.println("[BetalingsPane->nytSalg()]: "+Controller.getProduktlinjer());
	}


	private void angivBetalingsform() {

		if (salg == null ) {
			return;
		}

		BetalingsformWindow dia = new BetalingsformWindow("Angiv betalingsform samt beløb", salg);
		dia.showAndWait();

		System.out.println("[BetalingsPane -> angivBetalingsfor] "+salg);
		
        StringBuilder sb = new StringBuilder();
        sb.append("Id: " + salg.getId()+"\n");
        sb.append("ProduktLinjer: " + salg.getProduktLinjer()+"\n");
        sb.append("Fulde beløb/resterende beløb: " + salg.getFuldBeløb()+"\n");
        sb.append("Betalingsform: " + salg.getBetalingsform()+"\n");
        sb.append("Er betalt: " + salg.getErBetalt()+"\n");
        sb.append("Alle registrerede rabatter: " + Controller.getRabatter().toString()+"\n");
		
		txaSalgsinfo.setText(sb.toString());
		
		txfSamletPris.setText(""+salg.getFuldBeløb());
	}

	private void tildelRabat() {

		if (salg == null ) {
			return;
		}

		RabatWindow dia = new RabatWindow("Angiv rabat", salg);
		dia.showAndWait();

		txfSamletPris.setText(""+salg.getFuldBeløb());

		
		System.out.println("[BetalingsPane -> tildelRabat()] "+salg);
		
	}

	// -------------------------------------------------------------------------

	private void opdater() {
		salg = Controller.createSalg();

		//TODO Denne kan også blot blive kaldt fra controlleren med salg som argument
		for(ProduktLinje pl : Controller.getProduktlinjer()) {
			salg.addProduktLinje(pl);
		}

		samletPris = salg.getPris();

		lvwProduktlinjer.getItems().setAll(Controller.getProduktlinjer());

		txfSamletPris.setText(""+salg.getFuldBeløb());

		System.out.println("[BetalingsPane -> opdater()] Salgsenheder i storage:" + Controller.getSalgsEnheder());
		System.out.println("[BetalingsPane -> opdater()] Produktlinjer i storage:" + Controller.getProduktlinjer());

	}


	// -------------------------------------------------------------------------


	
	
	private void selectedBetalingChanged() {
		this.updateControls();
	}

	public void updateControls() {
		ProduktLinje produktlinje = lvwProduktlinjer.getSelectionModel().getSelectedItem();
		if (produktlinje != null) {
			
		} else {
			
		}
	}

}
