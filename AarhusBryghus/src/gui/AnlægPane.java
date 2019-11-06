package gui;

import java.time.LocalDate;

import controller.AnlægCtlr;
import controller.BestillingCtlr;
import gui.window.AfleverAnlægWindow;
import gui.window.AnlægWindow;
import gui.window.RundvisningWindow;
import gui.window.SampakningerWindow;
import gui.window.UdlejeAnlægWindow;
import model.*;
import model.produkter.Sampakninger;
import storage.Storage;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
//------------ComboBox-----------------------
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 


public class AnlægPane extends GridPane {
	private TextField txfAntal;
	private ListView<Pris> lvsProduktliste;
	private ListView<ProduktLinje> lvwIkkeAfleveredeAnlæg;
	private ListView<ProduktLinje> lvwKurveliste;
	private String arrangement, kategori;
	private ComboBox cmbPrisLister;
	private Label selected;
	private Label lblError;  
	private TextArea txaDescription;
	private ComboBox cmbKategoriLister;
	private TextArea txaAnlæg;
	 
	 
	
	public AnlægPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblIntroduktion = new Label("");
		this.add(lblIntroduktion, 0, 0);
		
		Label lblProdukter = new Label("Kurv");
		this.add(lblProdukter, 0, 1);
		
		lvwKurveliste = new ListView<>();
		this.add(lvwKurveliste, 0, 2, 1, 5);
		lvwKurveliste.setPrefWidth(200);
		lvwKurveliste.setPrefHeight(200);

		Button btnKurv = new Button("Opdater kurv");
		this.add(btnKurv, 0, 7);
		btnKurv.setOnAction(event -> this.infoUpdate());


		Label lblIkkeAfleveret = new Label("Ikke afleverede anlæg");
		this.add(lblIkkeAfleveret, 2, 1);
		
		lvwIkkeAfleveredeAnlæg = new ListView<>();
		this.add(lvwIkkeAfleveredeAnlæg, 2, 2, 1, 5);
		lvwIkkeAfleveredeAnlæg.setPrefWidth(200);
		lvwIkkeAfleveredeAnlæg.setPrefHeight(200);

		Button btnIkkeAfleveret = new Button("Opdater liste");
		this.add(btnIkkeAfleveret, 2, 7);
		btnIkkeAfleveret.setOnAction(event -> this.opdaterIkkeAfleveredeAnlæg());


		
		Label lblPriserForAnlæg = new Label("Priser for anlæg");
		this.add(lblPriserForAnlæg, 4, 1);
		
		lvsProduktliste = new ListView<>();
		this.add(lvsProduktliste, 4, 2, 1, 5);
		lvsProduktliste.setPrefWidth(200);
		lvsProduktliste.setPrefHeight(200);

		
		//ComboBox - PrisListe 
		// - https://www.geeksforgeeks.org/javafx-combobox-with-examples/
		
		String prisliste[] = AnlægCtlr.getArrangementer();
		cmbPrisLister = new ComboBox(FXCollections.observableArrayList(prisliste));
		selected = new Label(""); 
		
		Label lblPrisListe = new Label("Vælg prisliste:");
		this.add(lblPrisListe, 5, 0);
		
		TilePane tilePane1 = new TilePane(cmbPrisLister);
		this.add(tilePane1, 5, 1);

		comboPrisListeChanger();	

		
		Button btnAflever = new Button("Aflever anlæg");
		this.add(btnAflever, 5, 3);
		btnAflever.setOnAction(event -> this.afleverAnlæg());

		Button btnUdlej = new Button("Udlej anlæg");
		this.add(btnUdlej, 5, 4);
		btnUdlej.setOnAction(event -> this.tilføjTilKurv());
		
				
		Label lblAntal = new Label("Antal:");
		this.add(lblAntal, 5, 6);

		txfAntal = new TextField();
		this.add(txfAntal, 5, 7);
		txfAntal.setMaxWidth(50);
		txfAntal.setEditable(true);
		
        
        lblError = new Label(); 
        this.add(lblError, 0, 10);
        lblError.setStyle("-fx-text-fill: red");

        
		if (lvsProduktliste.getItems().size() > 0) {
			lvsProduktliste.getSelectionModel().select(0);
		}
	}
	
	
	private void afleverAnlæg() {
		ProduktLinje plAnlæg = lvwIkkeAfleveredeAnlæg.getSelectionModel().getSelectedItem();
		
		Anlæg anlæg = (Anlæg) plAnlæg.getPrisObj().getProdukt();
		//valider om det er de rigtige produkter
		if(anlæg.getProduktNavn().equals("1-hane") || anlæg.getProduktNavn().equals("2-haner") || anlæg.getProduktNavn().equals("bar med flere haner")) {
			
			//åbne vindue

			AfleverAnlægWindow dia = new AfleverAnlægWindow("Aflever anlæg", plAnlæg);
			dia.showAndWait();
	 		

		((Anlæg) anlæg).setAfleveret(true);
			
		//tilføj til produktlinjer
		AnlægCtlr.addProduktLinje(plAnlæg);
		
		infoUpdate();
		
		}
		return;
		
	}


	private void opdaterIkkeAfleveredeAnlæg() {
		lvwIkkeAfleveredeAnlæg.getItems().setAll(AnlægCtlr.getIkkeAfleveredeAnlæg());
	}


	private void infoUpdate() {
		double samletPris = 0;

		//TODO Denne kunne også bare blive kaldt fra Controlleren
		for(ProduktLinje pl : BestillingCtlr.getProduktlinjer()) {
			samletPris += pl.getPris();
		}

		lvwKurveliste.getItems().setAll(BestillingCtlr.getProduktlinjer());

	}

	
	
	private void comboPrisListeChanger() {

        EventHandler<ActionEvent> event = 
                  new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                selected.setText(cmbPrisLister.getValue().toString()); 
        		arrangement = selected.getText();
        		lvsProduktliste.getItems().setAll(AnlægCtlr.getPriserEfterArrangementOgKategori(arrangement, "anlæg"));
            } 
        }; 
  
        cmbPrisLister.setOnAction(event); 
	}
	
	
	
	
	
	private void fjernFraKurv() {
		ProduktLinje produktlinje = lvwKurveliste.getSelectionModel().getSelectedItem();
		if (produktlinje == null) {
			return;
		}
		BestillingCtlr.removeProduktLinje(produktlinje);

		lvwKurveliste.getItems().setAll(BestillingCtlr.getProduktlinjer());
		
		//TODO kan evt. laves til en metode i controlleren, der hedder Controller.getSamletPris()
		double samletPris = 0;
		
		for(ProduktLinje pl : BestillingCtlr.getProduktlinjer()) {
			samletPris += pl.getPris();
		}
		

	}


	private void tilføjTilKurv() {
		Pris pris = lvsProduktliste.getSelectionModel().getSelectedItem();
		
		int antal = Integer.parseInt(txfAntal.getText().trim());
		
		if(antal < 1) {
			return;
		}

		if(pris.getProdukt().getProduktNavn().equals("1-hane") || pris.getProdukt().getProduktNavn().equals("2-haner") || pris.getProdukt().getProduktNavn().equals("bar med flere haner")) {
			UdlejeAnlægWindow dia = new UdlejeAnlægWindow("Udleje anlæg", pris);
			dia.showAndWait(); 
		}
		
		ProduktLinje anlæg = AnlægCtlr.createProduktLinje(pris, antal);
		
		
		
        infoUpdate();

	}
	


	
	public void updateControls() {
	}
	
	

}
