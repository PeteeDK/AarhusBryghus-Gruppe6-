package gui;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DataTab {
	
	private Tab tab; 
	
	public DataTab(Tab tab) {
		this.tab = tab; 
	}
	
	public void open() {
		Label lb1 = new Label("Dagens salg"); 
		ListView<String> solgteVare = new ListView<>();
		Label lb2 = new Label("Brugte klip"); 
		ListView<String> brugteklip = new ListView<>(); 
		Label lb3 = new Label("Antal udlejet fustager"); 
		TextField txf1 = new TextField();
		txf1.setPromptText("Ingen udlejet");
		txf1.setEditable(false);
		
		Label lb4 = new Label("Samlet pris for solgte vare i DKK.");
		TextField txf2 = new TextField();
		txf2.setPromptText("samlet pris i DKK.");
		txf2.setEditable(false);
		
		
		HBox bgHbox = new HBox();
		VBox vb1 = new VBox();
		vb1.setPadding(new Insets(5,10,10,10));
		VBox vb2 = new VBox();
		vb2.setPadding(new Insets(5,10,10,10));
		VBox vb3 = new VBox();
		VBox vbInVb3top = new VBox();
		vbInVb3top.setPadding(new Insets(5,10,10,10));
		VBox vbInVb3buttom = new VBox();
		vbInVb3buttom.setPadding(new Insets(5,10,10,10));
		
		
		
		bgHbox.getChildren().addAll(vb1,vb2,vb3);
	
		vb1.getChildren().addAll(lb1,solgteVare);
		vb2.getChildren().addAll(lb2, brugteklip);
		vb3.getChildren().addAll(vbInVb3top,vbInVb3buttom);
		vbInVb3top.getChildren().addAll(lb3, txf1);
		vbInVb3buttom.getChildren().addAll(lb4,txf2);
		
		tab.setContent(bgHbox);
		
	}

}

