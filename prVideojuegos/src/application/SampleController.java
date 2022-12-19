package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController {
	
	@FXML
	private TextField txtNombre;
	
	@FXML
	private ChoiceBox cbConsola;
	
	@FXML
	private TextField txtPrecio;
	
	@FXML
	private TextField txtPegi;
	
	@FXML
	private TableView <Videojuego> tableVj;
	
	@FXML
	private TableColumn <Videojuego, String> columnNombre;
	
	@FXML
	private TableColumn <Videojuego, String> columnConsola;
	
	@FXML
	private TableColumn <Videojuego, String> columnPrecio;
	
	@FXML
	private TableColumn <Videojuego, Integer> columnPegi;
	
	@FXML
	private Button btnAnadir;
	
	@FXML
	private Button btnBorrar;
	
	private ObservableList<Videojuego> listaVj =
		FXCollections.observableArrayList();
	
	public ObservableList<String> listaConsolas = 
		FXCollections.observableArrayList(
			"Play",
			"XBOX",
			"PC",
			"Nintendo Switch" 
		);
	
	@FXML
	private void initialize() {
		
		cbConsola.setItems(listaConsolas);
		
		columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columnPegi.setCellValueFactory(new PropertyValueFactory<>("pegi"));
		
		
		ObservableList listaVjBD=getVjBD();
		
		tableVj.setItems(listaVjBD); 
	}
	private ObservableList<Videojuego> getVjBD(){
		
		ObservableList<Videojuego> listaVjBD=FXCollections.observableArrayList();
		
		DatabaseConnection conn = new DatabaseConnection();
		Connection conexion = conn.getConnection();
		
		String query ="Select * from videojuegos";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Videojuego vj = new Videojuego(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getFloat("precio"),
						rs.getString("consola"),
						rs.getInt("pegi")
						);
				listaVjBD.add(vj);
				
			}
			
			
			
			
			
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		
		
		return listaVjBD;
	}
	
	@FXML
	public void anadirVj(ActionEvent event) {
		
		if (txtNombre.getText().isEmpty() ||
				cbConsola.getSelectionModel().isEmpty() ||
				txtPegi.getText().isEmpty() ||
				txtPrecio.getText().isEmpty()) {
				
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del Videojuego");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();
			
		} else {
			if (esNumero(txtPrecio.getText())) {
				Videojuego vj = new Videojuego(
						txtNombre.getText(),
						Float.parseFloat(txtPrecio.getText()),
						cbConsola.getValue().toString(),
						Integer.parseInt(txtPegi.getText())
						
				);
					
//				listaVj.add(l);
				
				txtNombre.clear();
				cbConsola.getSelectionModel().clearSelection();
				txtPegi.clear();
				txtPrecio.clear();
				
				DatabaseConnection dbConnection = new DatabaseConnection();
				Connection connection = dbConnection.getConnection();
				
				String query =" insert into videojuegos (nombre, precio, consola, pegi)"
						+ "VALUES (?, ?, ?, ?)";
				
				try {
					PreparedStatement ps = connection.prepareStatement(query);
					
					ps.setString(1, vj.getNombre());
					ps.setFloat(2, vj.getPrecio());
					ps.setString(3, vj.getConsola());
					ps.setInt(4, vj.getPegi());
					ps.executeUpdate();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//despues de 
				
				ObservableList listaVjBD=getVjBD();
				
				tableVj.setItems(listaVjBD); 
				
				
			} else {
				
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error al insertar");
				alerta.setHeaderText
					("No se ha introducido un número en las páginas");
				alerta.setContentText
					("Por favor, introduzca un número en las páginas");
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	public void borrarVj(ActionEvent event) { 
		
		int indiceSeleccionado = tableVj
									.getSelectionModel()
									.getSelectedIndex();
		
//		tableVj.getItems().remove(indiceSeleccionado);
		
		
		if(indiceSeleccionado<=-1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("no has seleccionado ningun Videojuego ");
			alerta.setContentText("por favor selecciona un Videojuego");
		
			
		}else {

			
			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection connection = dbConnection.getConnection();
			
			
			try {
				String query="delete from videojuegos where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Videojuego vj = tableVj.getSelectionModel().getSelectedItem();
				ps.setInt(1, vj.getId());
				ps.executeUpdate();
				

				tableVj.getSelectionModel().clearSelection();
				
				
				
				
				ObservableList listaVjBD=getVjBD();
				
				tableVj.setItems(listaVjBD); 
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean esNumero (String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}

