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
import model.ProduktLinje;
import model.Salg;

public class Rundvisning extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps;
	private Bestilling bestilling;
	private Label lblError;
	private TextArea txaDescription;
	private TextField txfAntal;


	public Rundvisning() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Beskrivelse");
		this.add(lblComp, 0, 0);

        txaDescription = new TextArea();
        this.add(txaDescription, 0, 1);
        txaDescription.setPrefRowCount(7);
        txaDescription.setPrefWidth(270);
        txaDescription.setEditable(false);
        txaDescription.setText("Rundvisningsinfo....");

        
		Label lblAntal = new Label("Antal:");
		this.add(lblAntal, 1, 0);

		txfAntal = new TextField();
		this.add(txfAntal, 1, 1);
		txfAntal.setPrefWidth(50);
		txfAntal.setEditable(true);

        
		Button btnKurv = new Button("....");
		this.add(btnKurv, 2, 6);
		btnKurv.setOnAction(event -> this.tilføjTilKurv());


		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 4, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

//		Button btnUpdate = new Button("Update");
//		hbxButtons.getChildren().add(btnUpdate);
//		btnUpdate.setOnAction(event -> this.updateAction());
//
//		Button btnDelete = new Button("Delete");
//		hbxButtons.getChildren().add(btnDelete);
//		btnDelete.setOnAction(event -> this.deleteAction());
		
        lblError = new Label();
        this.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");


	}

	// -------------------------------------------------------------------------

	private void tilføjTilKurv() {
		// TODO Auto-generated method stub
		return;
	}

	
	
	
	private void createAction() {

	}

	private void updateAction() {
	}

//	private void deleteAction() {
//		ProduktLinje produktlinje = lvwProduklinjer.getSelectionModel().getSelectedItem();
//		if (produktlinje == null) {
//			return;
//		}
//
//		if (produktlinje.employeesCount() == 0) {
//			Alert alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("Delete Company");
//			// alert.setContentText("Are you sure?");
//			alert.setHeaderText("Are you sure?");
//			Optional<ButtonType> result = alert.showAndWait();
//			if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
//				Controller.deleteCompany(produktlinje);
//				lvwProduklinjer.getItems().setAll(Controller.getCompanies());
//				this.updateControls();
//			}
//
//		} else {
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("Delete Company");
//			alert.setHeaderText("Can't delete a company that has emlpoyees");
//			// wait for the modal dialog to close
//			alert.show();
//		}
//	}

	// -------------------------------------------------------------------------

	
	private void selectedBetalingChanged() {
		this.updateControls();
	}

	public void updateControls() {
	}

}
