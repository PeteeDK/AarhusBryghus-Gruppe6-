package martins_try;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
		TabPane tabpane = new TabPane(); 
		Tab salg = new Tab("Salg");
		tabpane.getTabs().add(salg); 
		salg.setContent(new ØlSalg());
		pane.setCenter(tabpane);
	}
}