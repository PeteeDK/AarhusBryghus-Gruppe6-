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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
//------------ComboBox-----------------------
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 


public class Bestilling extends GridPane {
	private TextField txfAntal, txfSamletBeløb;
	private ListView<Pris> lvsProduktliste;
	private ListView<ProduktLinje> lvwKurveliste;
	private ProduktLinje p;	//only for test
	private String arrangement;
	private ComboBox cmbPrisLister;
	private Label selected;
	private double dSamletBeløb;
	private String sSamletBeløb;
	private Label lblError;
	
	
	
	public Bestilling() {
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

//		Button btnUpdate = new Button("Update");
//		hbxButtons.getChildren().add(btnUpdate);
//		btnUpdate.setOnAction(event -> this.updateAction());
//
//		Button btnDelete = new Button("Delete");
//		hbxButtons.getChildren().add(btnDelete);
//		btnDelete.setOnAction(event -> this.deleteAction());

		
		//ComboBox - https://www.geeksforgeeks.org/javafx-combobox-with-examples/
		
		String prisliste[] = Controller.getArrangementer();
		cmbPrisLister = new ComboBox(FXCollections.observableArrayList(prisliste));
		selected = new Label(""); 	

		Label lblPrisListe = new Label("Vælg prisliste:");
		this.add(lblPrisListe, 2, 0);
		
		TilePane tilePane = new TilePane(cmbPrisLister);
		this.add(tilePane, 2, 1);

		comboPrisListeChanger();	

		
		//Kurv - listView
		
		//TODO Kan ikke blive bedre. Jeg går over til Scene-builder
		lvwKurveliste = new ListView<>();
		this.add(lvwKurveliste, 2, 2, 1, 6);
		lvwKurveliste.setPrefWidth(50);
		lvwKurveliste.setMaxWidth(200);
		lvwKurveliste.setPrefHeight(150);
//		ChangeListener<ProduktLinje> kurvlistener = (ov, oldEmployee, newEmployee) -> this.selectedProduktlinjeChanged();
//		lvwKurveliste.getSelectionModel().selectedItemProperty().addListener(kurvlistener);
		
		Button btnKurvFjern = new Button("Fjern fra kurv");
		this.add(btnKurvFjern, 2, 5);
		btnKurvFjern.setOnAction(event -> this.fjernFraKurv());
		
		Label lblSamletBeløb = new Label("Samlet beløb:");
		this.add(lblSamletBeløb, 3, 6);

		txfSamletBeløb = new TextField();
		this.add(txfSamletBeløb, 3, 7);
		txfSamletBeløb.setPrefWidth(50);
		txfSamletBeløb.setEditable(false);
		
        lblError = new Label();
        this.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");
		
		
		if (lvsProduktliste.getItems().size() > 0) {
			lvsProduktliste.getSelectionModel().select(0);
		}
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


	private void tilføjTilKurv() {
		Pris pris = lvsProduktliste.getSelectionModel().getSelectedItem();
		if (pris == null) {
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
        	p = Controller.createProduktLinje(pris, antal);
            System.out.println("[Bestilling - tilføjTilKurv()] " + p);
        } 
        
		double samletPris = 0;
		
		for(ProduktLinje pl : Controller.getProduktlinjer()) {
			samletPris += pl.getPris();
		}

		lvwKurveliste.getItems().setAll(Controller.getProduktlinjer());

		txfSamletBeløb.setText(""+samletPris);

	}
	


	// -------------------------------------------------------------------------


//	private void updateAction() {
//		Pris p = lvsButiksSalg.getSelectionModel().getSelectedItem();
//		if (p == null) {
//			return;
//		}
//
//		ButiksSalgWindow dia = new ButiksSalgWindow("Update Butiks-salg pris", p);
//		dia.showAndWait();
//
//		// Wait for the modal dialog to close
//
//		int selectIndex = lvsButiksSalg.getSelectionModel().getSelectedIndex();
//		lvsButiksSalg.getItems().setAll(this.initAllButiksSalgList());
//		lvsButiksSalg.getSelectionModel().select(selectIndex);
//	}
//
//	private void deleteAction() {
//		Pris p = lvsButiksSalg.getSelectionModel().getSelectedItem();
//		if (p == null) {
//			return;
//		}
//
//		Alert alert = new Alert(AlertType.CONFIRMATION);
//		alert.setTitle("Delete Employee");
//		// alert.setContentText("Are you sure?");
//		alert.setHeaderText("Are you sure?");
//		Optional<ButtonType> result = alert.showAndWait();
//
//		// Wait for the modal dialog to close
//
//		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//			Controller.deleteEmployee(p);
//			lvsButiksSalg.getItems().setAll(this.initAllButiksSalgList());
//			this.updateControls();
//		}
//
//	}

	// -------------------------------------------------------------------------
	
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
