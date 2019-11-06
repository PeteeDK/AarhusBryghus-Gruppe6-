package gui.window;

import controller.AnlægCtlr;
import model.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AfleverAnlægWindow extends Stage {
    private ProduktLinje anlæg;
    private Label lblError;
	private TextField txfBrugtFustagemængde;
	private TextField txfBrugtKulsyremængde;
	
    public AfleverAnlægWindow(String title, ProduktLinje anlæg) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.anlæg = anlæg;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
        
    }

    public AfleverAnlægWindow(String title) {
        this(title, null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
//        pane.setHgap(100);
        pane.setMaxSize(500, 500);
//        pane.setVgap(100);
        pane.setGridLinesVisible(false);

        
		Label lblFustage = new Label("Brugt fustagemængde");
		pane.add(lblFustage, 0, 1);

		txfBrugtFustagemængde = new TextField();
		pane.add(txfBrugtFustagemængde, 0, 2);
		txfBrugtFustagemængde.setPrefWidth(50);
		txfBrugtFustagemængde.setEditable(true);

        
		Label lblKulsyre = new Label("Brugt kulsyremængde:");
		pane.add(lblKulsyre, 0, 3);
		
		txfBrugtKulsyremængde = new TextField();
		pane.add(txfBrugtKulsyremængde, 0, 4);
		txfBrugtKulsyremængde.setPrefWidth(50);
		txfBrugtKulsyremængde.setEditable(true);

			
        
        Button btnOk = new Button("Ok");
        pane.add(btnOk, 0, 8);
        btnOk.setOnAction(event -> this.okAction());
        

        
        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    

	private void initControls() {
		return;
	}

	
    private void okAction() {
        double brugtKulsyremængde = Double.parseDouble(txfBrugtKulsyremængde.getText().trim());
        double brugtFustagemængde = Double.parseDouble(txfBrugtFustagemængde.getText().trim());
        if(brugtKulsyremængde < 0 || brugtFustagemængde < 0) {
        	return;
        }

        //tilføj til anlæg
        ((Anlæg) anlæg.getPrisObj().getProdukt()).setBrugtKulsyremængde(brugtKulsyremængde);
        ((Anlæg) anlæg.getPrisObj().getProdukt()).setBrugtFustagemængde(brugtFustagemængde);
        
        //opdater samlet beløb
        this.hide();
    }

}
