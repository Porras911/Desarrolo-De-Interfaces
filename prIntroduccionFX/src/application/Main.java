package application;
	
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//	STACK PANEL		
			/*
			Button btn = new Button("Click aquí");
			btn.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					System.out.println("¡Hola mundo!"); 
				}
			});
			Label lbl = new Label("¡Hola Mundo!");
			
<<<<<<< HEAD
			StackPane panel = new StackPane();
			
			panel.setAlignment(lbl, Pos.TOP_CENTER);
			panel.setAlignment(btn, Pos.CENTER); 
			panel.getChildren().addAll(lbl, btn);
			*/
			//	FIN STACK PANEL
			
			//	VBox
			/*
			Button btn1 = new Button("Botón 1");
			Button btn2 = new Button("Botón 2");
			Button btn3 = new Button("Botón 3");
			
			HBox panel = new HBox(15);
			panel.setPadding(new Insets(15)); 
			panel.getChildren().addAll(btn1, btn2, btn3);
			*/
			
			//	BORDER PANE + VBOX
			/*
			Button btn1 = new Button("Botón 1");
			Button btn2 = new Button("Botón 2");
			Button btn3 = new Button("Botón 3");
			VBox panelVertical = new VBox(15);
			panelVertical.setPadding(new Insets(15)); 
			panelVertical.getChildren().addAll(btn1, btn2, btn3);
			
			BorderPane panel = new BorderPane();
			panel.setRight(panelVertical); 
			*/
			
			GridPane panel = new GridPane();
			
			Button btn1 = new Button("Botón 1");
			Button btn2 = new Button("Botón 2");
			Button btn3 = new Button("Botón 3");
			Button btn4 = new Button("Botón 4");
			
			panel.setVgap(15);
			panel.setHgap(15);
			panel.setPadding(new Insets(15)); 
			
			panel.add(btn1, 0, 0);
			panel.add(btn2, 1, 0);
			panel.add(btn3, 0, 1);
			panel.add(btn4, 1, 1); 
			
			Scene scene = new Scene(panel, 400, 300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introducción a JavaFX");
			primaryStage.getIcons().add(new Image("/application/folder.png"));
			primaryStage.show();
=======
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
				
				
>>>>>>> d0a78204ed370cdb587b51969438bec1590ce43b
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
