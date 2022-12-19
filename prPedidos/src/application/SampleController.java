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
	private ChoiceBox cbCategoria;

	@FXML
	private TextField txtPrecio;

	@FXML
	private TableView<Pedido> tablePedidos;

	@FXML
	private TableColumn<Pedido, String> columnNombre;

	@FXML
	private TableColumn<Pedido, String> columnCategoria;

	@FXML
	private TableColumn<Pedido, String> columnPrecio;

	@FXML
	private TableColumn<Pedido, Integer> columnPegi;

	@FXML
	private Button btnAnadir;

	@FXML
	private Button btnBorrar;

	private ObservableList<Pedido> listaPedidos = FXCollections.observableArrayList();

	public ObservableList<String> listaCategoriass = FXCollections.observableArrayList("Videojuegos", "Informatica",
			"Electronica", "Otro");

	@FXML
	private void initialize() {

		cbCategoria.setItems(listaCategoriass);

		columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		columnPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

		ObservableList listaPedidosBD = getPedidosBD();

		tablePedidos.setItems(listaPedidosBD);
	}

	private ObservableList<Pedido> getPedidosBD() {

		ObservableList<Pedido> listaPedidosBD = FXCollections.observableArrayList();

		DatabaseConnection conn = new DatabaseConnection();
		Connection conexion = conn.getConnection();

		String query = "Select * from Pedidos";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio"),
						rs.getString("categoria")

				);
				listaPedidosBD.add(pedido);

			}

			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return listaPedidosBD;
	}

	@FXML
	public void anadirPedido(ActionEvent event) {

		if (txtNombre.getText().isEmpty() || cbCategoria.getSelectionModel().isEmpty() ||

				txtPrecio.getText().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Información incompleta");
			alerta.setHeaderText("Falta información del Pedido");
			alerta.setContentText("Por favor, introduce todos los campos");
			alerta.showAndWait();

		} else {
			if (esNumero(txtPrecio.getText())) {
				Pedido pedido = new Pedido(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()),
						cbCategoria.getValue().toString());

				txtNombre.clear();
				cbCategoria.getSelectionModel().clearSelection();
				;
				txtPrecio.clear();

				DatabaseConnection dbConnection = new DatabaseConnection();
				Connection connection = dbConnection.getConnection();

				String query = " insert into Pedidos (nombre, precio, categoria)" + "VALUES (?, ?, ?)";

				try {
					PreparedStatement ps = connection.prepareStatement(query);

					ps.setString(1, pedido.getNombre());
					ps.setFloat(2, pedido.getPrecio());
					ps.setString(3, pedido.getCategoria());
					ps.executeUpdate();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ObservableList listaPedidosBD = getPedidosBD();

				tablePedidos.setItems(listaPedidosBD);

			} else {

				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error al insertar");
				alerta.setHeaderText("No se ha introducido un precio");
				alerta.setContentText("Por favor, introduzca un precio");
				alerta.showAndWait();
			}
		}
	}

	@FXML
	public void borrarPedido(ActionEvent event) {

		int indiceSeleccionado = tablePedidos.getSelectionModel().getSelectedIndex();



		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error al borrar");
			alerta.setHeaderText("no has seleccionado ningun Pedido ");
			alerta.setContentText("por favor selecciona un Pedido");

		} else {

			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection connection = dbConnection.getConnection();

			try {
				String query = "delete from Pedidos where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Pedido pedido = tablePedidos.getSelectionModel().getSelectedItem();
				ps.setInt(1, pedido.getId());
				ps.executeUpdate();

				tablePedidos.getSelectionModel().clearSelection();

				ObservableList listaPedidosBD = getPedidosBD();

				tablePedidos.setItems(listaPedidosBD);
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean esNumero(String s) {
		try {
			Float.parseFloat(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
