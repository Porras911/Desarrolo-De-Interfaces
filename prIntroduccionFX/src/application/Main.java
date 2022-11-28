package application;
	
import java.awt.image.BufferedImage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
//			Button btn = new Button("Click aqui");
//			btn.setOnAction(new EventHandler<ActionEvent>() {
//				
//				@Override
//				public void handle(ActionEvent arg0) {
//					System.out.println("Jellow");
//				}
//			});
//			
//				Label lbl = new Label("ILLO");
//				
//				StackPane panel = new StackPane();
//				
//				panel.setAlignment(lbl ,Pos.TOP_CENTER);
//				panel.setAlignment(btn ,Pos.CENTER);
//				panel.getChildren().addAll(btn,lbl);
				Button btn = new Button("Click aqui");
				Button btn1 = new Button("Click aqui");
				Button btn2 = new Button("Click aqui");
				VBox panel = new VBox(15);
				panel.setPadding(new Insets(15));
				panel.getChildren().addAll(btn,btn1,btn2);
				Scene escene = new Scene(panel, 400, 400);
				primaryStage.getIcons().add(new Image ("/application/folder.png"));
				primaryStage.setScene(escene);
				primaryStage.setTitle("Primera Interfaz");
				primaryStage.show();
				
				
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
