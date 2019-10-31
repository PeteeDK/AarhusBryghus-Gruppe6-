package gui;

import controller.Controller;
import model.*;
import javafx.beans.value.ChangeListener;
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


public class StatistikPane extends GridPane {
	private TextField txfAntal, txfSamletBeløb;
	private ListView<Pris> lvsProduktliste;
	private ListView<ProduktLinje> lvwKurveliste;
	private String arrangement, kategori;
	private ComboBox cmbPrisLister;
	private Label selected;
	private Label lblError;
	private TextArea txaDescription;
	private ComboBox cmbKategoriLister;
	private TextArea txaAnlæg;
	
	
	
	public StatistikPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblIntroduktion = new Label("Vælg en prisliste i comboBoxen, vælg ét produkt, \nangiv antal og tilføj til kurv. Tryk dernæst betal...");
		this.add(lblIntroduktion, 0, 0);
		
		Label lblProdukter = new Label("Produkter med priser");
		this.add(lblProdukter, 0, 1);
		
		lvsProduktliste = new ListView<>();
		this.add(lvsProduktliste, 0, 2, 1, 5);
		lvsProduktliste.setPrefWidth(50);
		lvsProduktliste.setPrefHeight(200);
		ChangeListener<Pris> listener = (ov, oldEmployee, newEmployee) -> this.selectedBestillingChanged();
		lvsProduktliste.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblAntal = new Label("Antal:");
		this.add(lblAntal, 1, 1);

		txfAntal = new TextField();
		this.add(txfAntal, 1, 2);
		txfAntal.setPrefWidth(50);
		txfAntal.setEditable(true);

		
		Button btnKurv = new Button("Tiføj til kurv");
		this.add(btnKurv, 2, 6);
		btnKurv.setOnAction(event -> this.tilføjTilKurv());

		
		//ComboBox - PrisListe 
		// - https://www.geeksforgeeks.org/javafx-combobox-with-examples/
		
		String prisliste[] = Controller.getArrangementer();
		cmbPrisLister = new ComboBox(FXCollections.observableArrayList(prisliste));
		selected = new Label(""); 
		
		Label lblPrisListe = new Label("Vælg prisliste:");
		this.add(lblPrisListe, 2, 0);
		
		TilePane tilePane1 = new TilePane(cmbPrisLister);
		this.add(tilePane1, 2, 1);

		comboPrisListeChanger();	
		
		//-----------------------------------------------------------------------

		//ComboBox - Kategori 
		
		String kategoriliste[] = Controller.getKategorier();
		cmbKategoriLister = new ComboBox(FXCollections.observableArrayList(kategoriliste));
		selected = new Label(""); 
		
		Label lblKategoriListe = new Label("Vælg Kategori:");
		this.add(lblKategoriListe, 3, 0);
		
		TilePane tilePane2 = new TilePane(cmbKategoriLister);
		this.add(tilePane2, 3, 1);

		comboKategoriListeChanger();	
		
		//-----------------------------------------------------------------------

		
		
		lvwKurveliste = new ListView<>();
		this.add(lvwKurveliste, 2, 2, 1, 3);
		lvwKurveliste.setPrefWidth(50);
		lvwKurveliste.setPrefHeight(150);
		
		Button btnKurvFjern = new Button("Fjern fra kurv");
		this.add(btnKurvFjern, 2, 5);
		btnKurvFjern.setOnAction(event -> this.fjernFraKurv());
		
		Label lblSamletBeløb = new Label("Samlet beløb:");
		this.add(lblSamletBeløb, 3, 6);

		txfSamletBeløb = new TextField();
		this.add(txfSamletBeløb, 3, 7);
		txfSamletBeløb.setPrefWidth(50);
		txfSamletBeløb.setEditable(false);
		

		Label lblRundvisningsInfo = new Label("RundvisningsInfo:");
		this.add(lblRundvisningsInfo, 0, 8);

        txaDescription = new TextArea();
        this.add(txaDescription, 0, 9);
        txaDescription.setPrefRowCount(7);
        txaDescription.setPrefWidth(150);
        txaDescription.setEditable(false);

        
		Label lblAnlægInfo = new Label("AnlægsInfo:");
		this.add(lblAnlægInfo, 3, 8);
        
        txaAnlæg = new TextArea();
        this.add(txaAnlæg, 3, 9);
        txaAnlæg.setPrefRowCount(7);
        txaAnlæg.setPrefWidth(150);
        txaAnlæg.setEditable(false);

        
        
        lblError = new Label();
        this.add(lblError, 0, 10);
        lblError.setStyle("-fx-text-fill: red");

        
		if (lvsProduktliste.getItems().size() > 0) {
			lvsProduktliste.getSelectionModel().select(0);
		}
	}

	
   

/**
 * Når man prøver at tilføje fx 47 rundvisninger til kurv popper et vindue op, hvor man angiver specifikationer
 * til at oprette studierabat-pris, der bliver beregnet i Salg. 
 * - Jeg prøvede om det virkede i et vindue. Det er nok en bedre idé at oprette et pane som var planen til at
 * at starte med. Kodemæssigt at tingene også højere samhørrighed i klassen, hvis man opretter en klasse for hver
 * af de store produkt-kategorier TODO Lav det til en pane
 */
	private void opretRundvisningMedStudierabat() {
		Pris pris = lvsProduktliste.getSelectionModel().getSelectedItem();
		if (pris == null || !pris.getProdukt().getKategori().equals("rundvisning")) {
			return;
		}

		int antal = 0;
		try {
	        antal = Integer.parseInt(txfAntal.getText().trim());
		} catch (NumberFormatException ex) {
			   // do nothing
        }
        if (antal < 0) {
        	lblError.setText("Antal skal være et positivt tal");
            return;
        }
		
		ProduktLinje rundvisning = Controller.createProduktLinje(pris, antal);
		
		RundvisningWindow dia = new RundvisningWindow("Specifikationer til rundvisning", rundvisning);
		dia.showAndWait();

		
        StringBuilder sb = new StringBuilder();
        sb.append("Kategori: " + rundvisning.getPrisObj().getProdukt().getKategori()+"\n");
        sb.append("Pris pr. person" + rundvisning.getPrisObj().getPris()+"\n");
        sb.append("Totale antal: " + rundvisning.getAntal()+"\n");
        sb.append(Controller.getRabatter().toString()+"\n");
		
		txaDescription.setText(sb.toString());

		infoUpdate();
		
	}


	private void opretAnlægMedTilbehør() {
		Pris pris = lvsProduktliste.getSelectionModel().getSelectedItem();
		if (pris == null || !pris.getProdukt().getKategori().equals("anlæg")) {
			return;
		}

		int antal = 0;
		try {
	        antal = Integer.parseInt(txfAntal.getText().trim());
		} catch (NumberFormatException ex) {
			   // do nothing
        }
        if (antal < 0) {
        	lblError.setText("Antal skal være et positivt tal");
            return;
        }
        
        //TODO Levering skal muligvis være en tilvalgsydelse, der tilføjes i AnlægWindow i stedet for at være et produkt i prislisten
		
		ProduktLinje anlæg = Controller.createProduktLinje(pris, antal);
		
		//det er kun muligt at tilføje fustager og kulsyrer til følgende produkter
		if(anlæg.getPrisObj().getProdukt().getProduktNavn().equals("1-hane") || anlæg.getPrisObj().getProdukt().getProduktNavn().equals("2-haner") ||
			anlæg.getPrisObj().getProdukt().getProduktNavn().equals("bar med flere haner")) {

			AnlægWindow dia = new AnlægWindow("Specifikationer til anlæg", anlæg);
			dia.showAndWait();
			
		}

		
        StringBuilder sb = new StringBuilder();
        sb.append("Kategori: " + anlæg.getPrisObj().getProdukt().getKategori()+"\n");
        sb.append("Pris på anlæg: " + anlæg.getPrisObj().getPris()+"\n");
        sb.append("Beregn forbrug/pant: " + ((Anlæg)anlæg.getPrisObj().getProdukt()).beregnForbrug()+"\n");
        sb.append("Tilføjede pris-enheder: " + ((Anlæg)anlæg.getPrisObj().getProdukt()).getTilbehør()+"\n");
        sb.append("Pris-enheder omsat til produkter: " + ((Anlæg)anlæg.getPrisObj().getProdukt()).getTilbehørsProdukter()+"\n");
        sb.append("Afleveret: " + ((Anlæg)anlæg.getPrisObj().getProdukt()).isAfleveret()+"\n");
		
        txaAnlæg.setText(sb.toString());

		infoUpdate();
		
	}

	
	
	
	private void fjernFraKurv() {
		ProduktLinje produktlinje = lvwKurveliste.getSelectionModel().getSelectedItem();
		if (produktlinje == null) {
			return;
		}
		Controller.removeProduktLinje(produktlinje);

		lvwKurveliste.getItems().setAll(Controller.getProduktlinjer());
				
		double samletPris = 0;
		
		for(ProduktLinje pl : Controller.getProduktlinjer()) {
			samletPris += pl.getPris();
		}
		
		txfSamletBeløb.setText(""+samletPris);

	}

	private void comboPrisListeChanger() {

        EventHandler<ActionEvent> event = 
                  new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                selected.setText(cmbPrisLister.getValue().toString()); 
        		arrangement = selected.getText();
        		lvsProduktliste.getItems().setAll(Controller.getPriser(arrangement));
            } 
        }; 
  
        cmbPrisLister.setOnAction(event); 
	}

	private void comboKategoriListeChanger() {

        EventHandler<ActionEvent> event = 
                  new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent e) 
            { 
                selected.setText(cmbKategoriLister.getValue().toString()); 
        		kategori = selected.getText();
        		lvsProduktliste.getItems().setAll(Controller.getPriserEfterArrangementOgKategori(arrangement, kategori));
            } 
        }; 
  
        cmbKategoriLister.setOnAction(event); 
	}
	

	private void tilføjTilKurv() {
		Pris pris = lvsProduktliste.getSelectionModel().getSelectedItem();
		if (pris == null) {
			return;
		}else if(pris.getProdukt().getKategori().equals("rundvisning")) {
        	opretRundvisningMedStudierabat();
        	return;
        }else if(pris.getProdukt().getKategori().equals("anlæg")) {
        	opretAnlægMedTilbehør();
        	return;
        }
		
		int antal = 0;
		try {
	        antal = Integer.parseInt(txfAntal.getText().trim());
		} catch (NumberFormatException ex) {
			   // do nothing
        }
        if (antal < 0) {
        	lblError.setText("Antal skal være et positivt tal");
            return;
        }
        
        if (pris != null && antal > 0) {
        	Controller.createProduktLinje(pris, antal);
        } 
        
        infoUpdate();

	}
	

	private void infoUpdate() {
		double samletPris = 0;
		
		for(ProduktLinje pl : Controller.getProduktlinjer()) {
			samletPris += pl.getPris();
		}

		lvwKurveliste.getItems().setAll(Controller.getProduktlinjer());

		txfSamletBeløb.setText(""+samletPris);
	}

	
	public void updateControls() {
		this.selectedBestillingChanged();
	}
	
	
	private void selectedBestillingChanged() {
		Pris p = lvsProduktliste.getSelectionModel().getSelectedItem();
		if (p != null) {
			txfAntal.setText("0");
		} else {
			txfAntal.clear();
		}
	}

}
