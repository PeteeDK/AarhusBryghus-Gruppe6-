package demo3listview;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		stage.setTitle("ListView Demo3");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private ListView<Person> lvwPersons;
	private ArrayList<Person> persons;

	
	

	private void initContent(GridPane pane) {
		initPersons();

		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);

		Label lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);

		txfName = new TextField();
		pane.add(txfName, 1, 0, 2, 1);

		// add a listView to the pane(at col=1, row=0)
		lvwPersons = new ListView<Person>();
		pane.add(lvwPersons, 1, 1, 1, 5);
		lvwPersons.setPrefWidth(200);
		lvwPersons.setPrefHeight(200);
		lvwPersons.getItems().setAll(persons);

		ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
		lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

		lvwPersons.getSelectionModel().clearSelection();

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 6, 0);

		// connect a method to the button
		btnAdd.setOnAction(event -> this.addAction());

		Button btnDelete = new Button("Delete");
		pane.add(btnDelete, 6, 3);

		// connect a method to the button
		btnDelete.setOnAction(event -> this.deleteAction());

	}

	

		

		// -------------------------------------------------------------------------
		// Button actions

		private void addAction() {
			String name = txfName.getText().trim();
			if (name.length() > 0) {
				Person p = new Person(name, "Hansen", "123@mail.com");
				persons.add(p);
				lvwPersons.getItems().setAll(persons);
			}
		}

		private void deleteAction() {
			int index = lvwPersons.getSelectionModel().getSelectedIndex();
			if (index >= 0) {
				persons.remove(index);
				txfName.clear();
				lvwPersons.getItems().setAll(persons);
			}
		}

		private void initPersons() {
			persons = new ArrayList<Person>();
			persons.add(new Person("Jens", "Jensen", "jj@eaaa.dk"));
			persons.add(new Person("Hans", "Hansen", "hh@eaaa.dk"));
			persons.add(new Person("Pia", "Peters", "pp@eaaa.dk"));

		}

		// -------------------------------------------------------------------------
		// Selectionchange actions

		private void selectionChanged() {
			Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
			if (newPerson != null) {
				txfName.setText(newPerson.getFirstName());
			} else {
				txfName.clear();
			}
		}
	}

