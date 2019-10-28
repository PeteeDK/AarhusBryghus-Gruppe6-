package demoradiobutton;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Radiobutton Demo");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private Label lblTxt;
	private ToggleGroup group;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		HBox box = new HBox();
		group = new ToggleGroup();
		String[] colors = { "Red", "Blue", "Green", "Yellow" };
		Color[] color = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };
		RadioButton rb;
		for (int i = 0; i < colors.length; i++) {
			rb = new RadioButton();
			rb.setToggleGroup(group);
			rb.setText(colors[i]);
			rb.setUserData(color[i]);
			box.getChildren().add(rb);
		}
		pane.add(box, 0, 0, 4, 1);
		group.getToggles().get(0).setSelected(true);

		group.selectedToggleProperty().addListener(event -> toggleRadioButton());

		// add a label to the pane (at col=0, row=0)
		lblTxt = new Label("Radiobutton example");
		lblTxt.setTextFill(color[0]);
		pane.add(lblTxt, 3, 1);

	}

	// -------------------------------------------------------------------------
	// RadioButtonsactions

	private void toggleRadioButton() {
		Color color = (Color) group.getSelectedToggle().getUserData();
		lblTxt.setTextFill(color);
	}
}
