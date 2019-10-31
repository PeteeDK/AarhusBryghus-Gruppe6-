package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Salg;

public class MainApp extends Application {

	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Betalingssystem");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------
	
	
	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		Tab tabButiksSalg = new Tab("Bestilling");
		tabPane.getTabs().add(tabButiksSalg);

		Bestilling bestilling = new Bestilling();
		tabButiksSalg.setContent(bestilling);
		tabButiksSalg.setOnSelectionChanged(event -> bestilling.updateControls());

		
		Tab tabBetaling = new Tab("Betaling");
		tabPane.getTabs().add(tabBetaling);

		BetalingPane betaling = new BetalingPane();
		tabBetaling.setContent(betaling);
		tabBetaling.setOnSelectionChanged(event -> betaling.updateControls());

		
		Tab tabStatistik = new Tab("Statistik");
		tabPane.getTabs().add(tabStatistik);

		StatistikPane statistik = new StatistikPane();
		tabStatistik.setContent(statistik);
		tabStatistik.setOnSelectionChanged(event -> statistik.updateControls());

	}

}
