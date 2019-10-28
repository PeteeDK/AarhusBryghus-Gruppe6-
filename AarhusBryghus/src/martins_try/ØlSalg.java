package martins_try;

import javafx.scene.control.TextField;
import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class ØlSalg extends GridPane {
	private Button TilKurv;
	private ListView<String> oversigt;
	private ListView<String> kurveOversigt;
	private RadioButton salgssituation;
	
	// Typen skal ikke være String, skal matche Eriks kode!
	private ArrayList<String> fredagsØl = new ArrayList<>(); 
	private ArrayList<String> kurv = new ArrayList<>(); 
	private TextField antal; 
	
	
	public ØlSalg() {
		this.setGridLinesVisible(true);
		this.testData();
		TilKurv= new Button("Tilføj til kurv!");
		oversigt = new ListView<String>();
		kurveOversigt = new ListView<String>();
		salgssituation = new RadioButton(); 
		oversigt.getItems().setAll(fredagsØl); 
		this.add(oversigt, 0,0);
		this.add(kurveOversigt, 1,0);
		this.add(TilKurv, 2, 0);
		TilKurv.setOnAction(event -> this.tilføjTilKurv());
		antal = new TextField(); 
		this.add(antal, 3, 0);
	}
	
	public void testData() { // Skal i stedet være vores prislister fra controlleren
		fredagsØl.add("Humle");
		fredagsØl.add("Humle1");
		fredagsØl.add("Humle2");
		fredagsØl.add("Humle3");
		fredagsØl.add("Humle4");
		fredagsØl.add("Humle5");
	}
	
	public void tilføjTilKurv() {
		System.out.println("Test");
		String valgtØl = oversigt.getSelectionModel().getSelectedItem();
		int antalValgt = Integer.parseInt(antal.getText()); // skal flyttes lidt rundt og gemmes i produktlinje tror jeg
		kurv.add(valgtØl + antalValgt);
		kurveOversigt.getItems().setAll(kurv);
		
	}

}
