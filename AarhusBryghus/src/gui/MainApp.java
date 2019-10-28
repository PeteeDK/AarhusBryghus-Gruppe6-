package gui;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Kasseapperat");
		
		
		//-------- Add TabPane
		TabPane tabPane = new TabPane(); 
		
		//-------- Add Vbox witch contains tabPane 
		VBox vBox = new VBox(); 
		vBox.getChildren().addAll(tabPane); 
		
		//-------- Add the tabs in the tabpane 
		Tab butikTb = new Tab("Butik");
		Tab fredagsbarTb = new Tab("Fredagsbar");
		Tab dataTb = new Tab("Data"); 
		
		tabPane.getTabs().addAll(butikTb,fredagsbarTb,dataTb);
		
		//------- makes tabs unclosable 
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		tabPane.prefWidthProperty().bind(primaryStage.widthProperty());
		
		
		//------- calls the tabs inside 
		
		new ButikTab(butikTb).open();
		new DataTab(dataTb).open();
		
		
		
		AnchorPane root = new AnchorPane(); 
		root.getChildren().addAll(vBox);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(800);
		primaryStage.setMaxHeight(610);
		primaryStage.setMaxWidth(810);
		primaryStage.show();
		
		
	}
		
	public static void main(String[] args) {
			launch(args);
	}
		
}

