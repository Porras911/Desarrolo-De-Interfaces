package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleController {
	@FXML
	private TextField nameF;
	
	@FXML
	private PasswordField passF;
	
	@FXML
	private Button submitB;
	
	@FXML
	private Label msg;
	
	@FXML
	public void mostrarMensaje(ActionEvent action) {
		 msg.setText("Bienvenido: "+nameF.getText());
		 nameF.setText("");
		 passF.setText("");
	 }
	
}
