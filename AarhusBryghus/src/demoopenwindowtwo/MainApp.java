package demoopenwindowtwo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Gui Demo input window");
		GridPane pane = new GridPane();
		this.initContent(pane);

		movieWindow = new MovieInputWindow("Create a movie", stage);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

	}

	// -------------------------------------------------------------------------

	private TextField txfResult;
	private MovieInputWindow movieWindow;



	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a label to the pane (at col=0, row=0)
		Label lblName = new Label("Movie:");
		pane.add(lblName, 0, 0);

		// add a text field to the pane
		// (at col=1, row=0, extending 2 columns and 1 row)
		txfResult = new TextField();
		pane.add(txfResult, 1, 0, 2, 1);

		// add a button to the pane (at col=1, row=1)
		Button btnCreateMovie = new Button("Create movie");
		pane.add(btnCreateMovie, 1, 1);
		GridPane.setMargin(btnCreateMovie, new Insets(10, 10, 0, 10));

		// connect a method to the button
		btnCreateMovie.setOnAction(event -> this.createMovieAction());

	}

	// -----------------------------------------------------
		// Button actions

		private void createMovieAction() {
			movieWindow.showAndWait();
			if (movieWindow.getActualMovie() != null) {
				txfResult.setText(movieWindow.getActualMovie().toString());
			}

		

	}

}
