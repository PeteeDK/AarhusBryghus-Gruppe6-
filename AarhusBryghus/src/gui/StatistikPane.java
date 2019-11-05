package gui;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Pris;
import model.ProduktLinje;
import model.Rundvisning;
import model.Salg;

public class StatistikPane extends GridPane {


	private Label lblError;
	private LocalDate ld;
	private DatePicker dp = new DatePicker();	
	private LocalDate startDato;
	private LocalDate slutDato;
	private GridPane root;
	private TextField txfSlutDato;
	private TextField txfStartDato;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
	
	
	public StatistikPane() { 
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);
		
		Label lblStartDato = new Label("Vælg startdato: yyyy-mm-dd");
		this.add(lblStartDato, 0, 0);
        
		txfStartDato = new TextField();
		this.add(txfStartDato, 0, 1);
		txfStartDato.setPrefWidth(50);
		txfStartDato.setEditable(true);
		
		Label lblSlutDato = new Label("Vælg startdato: yyyy-mm-dd");
		this.add(lblSlutDato, 0, 2);
        
		txfSlutDato = new TextField();
		this.add(txfSlutDato, 0, 3);
		txfSlutDato.setPrefWidth(50);
		txfSlutDato.setEditable(true);
	

		Button btnViskurv = new Button("Registrere datoer:"); 
		this.add(btnViskurv, 0, 4);
		btnViskurv.setOnAction(event -> this.registrereDatoer());
		
		Button btnKlippekort = new Button("Klippekort udstedt mellem startdato og slutdato");
		this.add(btnKlippekort, 0, 5);
		btnKlippekort.setOnAction(event -> this.klippekortUdstedt());

		Button btnTildelRabat = new Button("Klip brugt mellem startdato og slutdato");
		this.add(btnTildelRabat, 0, 6);
		btnTildelRabat.setOnAction(event -> this.klipBrugt());

		Button btnAngivBetalingsform = new Button("Ikke afleverede anlæg");
		this.add(btnAngivBetalingsform, 0, 7);
		btnAngivBetalingsform.setOnAction(event -> this.ikkeAfleveredeAnlæg());
		
		Button btnDagensSalg = new Button("Dagens salg");
		this.add(btnDagensSalg, 0, 8);
		btnDagensSalg.setOnAction(event -> this.periodensSalg());

		
		
		
        lblError = new Label();
        this.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");


	}
	


	private void periodensSalg() {
		if(startDato == null || slutDato == null || startDato.isAfter(slutDato)) {
			return;
		}
		
		SalgForPeriodeWindow dia = new SalgForPeriodeWindow("Registeret salg i mellem start og slutdato", startDato, slutDato);
		dia.showAndWait(); 
	}



	private void registrereDatoer() {
		startDato = LocalDate.parse(txfStartDato.getText().trim(), formatter);
		slutDato = LocalDate.parse(txfSlutDato.getText().trim(), formatter);
		System.out.println("[StatistikPane -> registrereDatoer] startDato: " + startDato + ", slutDato: " + slutDato);
	}


	private void okAction() {
		
	}




	private void ikkeAfleveredeAnlæg() {
		if(startDato == null || slutDato == null || startDato.isAfter(slutDato)) {
			return;
		}
		
		IkkeAfleveredeAnlægWindow dia = new IkkeAfleveredeAnlægWindow("Ikke afleverede anlæg i perioden", startDato, slutDato);
		dia.showAndWait(); 

	}

	private void klipBrugt() {
		if(startDato == null || slutDato == null || startDato.isAfter(slutDato)) {
			return;
		}
		
		KlipWindow dia = new KlipWindow("Brugte klip i periode", startDato, slutDato);
		dia.showAndWait();

	}

	private void klippekortUdstedt() {
		if(startDato == null || slutDato == null || startDato.isAfter(slutDato)) {
			return;
		}
		
		KlippekortWindow dia = new KlippekortWindow("Specifikationer til rundvisning", startDato, slutDato);
		dia.showAndWait();

		
	}




	private void selectedBetalingChanged() {
		this.updateControls();
	}

	public void updateControls() {
	}

}
