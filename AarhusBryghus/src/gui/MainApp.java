package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gui.FredagsSalgPane;

public class MainApp extends Application {
		public static void main(String[] args) {
			Application.launch(args);
		}
		
		

		@Override
		public void start(Stage stage) {
			stage.setTitle("Aarhus Bryghus Salg");
			BorderPane pane = new BorderPane();
			this.initContent(pane);
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
		}

	// ------------------------------------------------------------------------
		private void initContent(BorderPane pane) {
			TabPane tabPane = new TabPane(); 
			this.initTabPane(tabPane);
			pane.setCenter(tabPane);
		}
			
		private void initTabPane(TabPane tabPane) {
			tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
			
			Tab tabFredagsBarSalg = new Tab("FredagsBarSalg");

			tabPane.getTabs().add(tabFredagsBarSalg);
			FredagsSalgPane fredagsSalgPane = new FredagsSalgPane();
			// tabFredagsBarSalg.setOnSelectionChanged(event -> fredagsSalgPane.updateContols());
			
		}
}
	
