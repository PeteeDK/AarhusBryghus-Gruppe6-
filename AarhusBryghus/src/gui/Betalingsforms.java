package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Betalingsforms extends Stage {
	
	public Betalingsforms(String title) {
		
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);
		
		this.setTitle(title);
		GridPane pane = new GridPane();
		
		Scene scene = new Scene(pane);
		this.setScene(scene);
		
		pane.setPadding(new Insets(30));
		pane.setHgap(10);
		pane.setVgap(10);
		
		Button bnt1 = new Button("Dankort");
		Button bnt2 = new Button("MobilePay"); 
		
		HBox hb1 = new HBox(); 
		pane.add(hb1, 0, 0);
		hb1.getChildren().addAll(bnt1, bnt2); 
		
	}

}
