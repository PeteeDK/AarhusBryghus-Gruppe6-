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

public class BetalingPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps;
	private ListView<ProduktLinje> lvwProduklinjer;
	private Bestilling bestilling;
	private Label lblError;


	public BetalingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwProduklinjer = new ListView<>();
		this.add(lvwProduklinjer, 0, 1, 1, 3);
		lvwProduklinjer.setPrefWidth(200);
		lvwProduklinjer.setPrefHeight(200);
		lvwProduklinjer.getItems().setAll(Controller.getProduktlinjer());
		
		ChangeListener<ProduktLinje> listener = (ov, oldCompny, newCompany) -> this.selectedBetalingChanged();
		lvwProduklinjer.getSelectionModel().selectedItemProperty().addListener(listener);

		
		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 2);

		txfHours = new TextField();
		this.add(txfHours, 2, 2);
		txfHours.setEditable(false);

	
		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.BASELINE);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100);
		txaEmps.setEditable(false);

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


		if (lvwProduklinjer.getItems().size() > 0) {
			lvwProduklinjer.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		lvwProduklinjer.getItems().setAll(Controller.getProduktlinjer());

	}

	private void updateAction() {
		ProduktLinje produktlinje = lvwProduklinjer.getSelectionModel().getSelectedItem();
		if (produktlinje == null) {
			return;
		}

//		FredagsbarWindow dia = new FredagsbarWindow("Update Company", produktlinje);
//		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwProduklinjer.getSelectionModel().getSelectedIndex();
		lvwProduklinjer.getItems().setAll();
		lvwProduklinjer.getSelectionModel().select(selectIndex);
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
		ProduktLinje produktlinje = lvwProduklinjer.getSelectionModel().getSelectedItem();
		if (produktlinje != null) {
			txfName.setText(produktlinje.getPrisObj().getProdukt().getProduktNavn());
			txfHours.setText(""+produktlinje.getPrisObj().getPris());
			txaEmps.setText(""+produktlinje.getPris());
		} else {
			txfName.clear();
			txfHours.clear();
			txaEmps.clear();
		}
	}

}
