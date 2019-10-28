package demo1listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ListView Demo1");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ListView<String> lvwNames;

	private ArrayList<String> names;

	private void initContent(GridPane pane) {

		initNames();

		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Names:");
		pane.add(lblName, 0, 0);

		// add a listView to the pane(at col=1, row=0)
		lvwNames = new ListView<String>();
		pane.add(lvwNames, 0, 1, 1, 5);
		lvwNames.setPrefWidth(200);
		lvwNames.setPrefHeight(200);
		lvwNames.getItems().setAll(this.initNames());

		ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
		lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

		lvwNames.getSelectionModel().clearSelection();

		// add a text field to the pane (at col=6, row=0, spanning 2 columns and
		// 1 row)
		txfName = new TextField();
		pane.add(txfName, 6, 0, 2, 1);

	}

	// -------------------------------------------------------------------------
	// Button actions

	private ArrayList<String> initNames() {
		names = new ArrayList<String>();
		names.add("Jane");
		names.add("Eva");
		names.add("Lene");
		names.add("Mette");
		names.add("Tine");
		names.add("Line");
		names.add("Lone");
		names.add("Alberte");
		names.add("Pia");

		return names;
	}

	// -------------------------------------------------------------------------
	// Selectionchange actions

	private void selectionChanged() {
		String newString = lvwNames.getSelectionModel().getSelectedItem();
		if (newString != null) {
			txfName.setText(newString);
		} else {
			txfName.clear();
		}

	}
}
