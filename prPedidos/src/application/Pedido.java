package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pedido {
	   private int id;
	    private SimpleStringProperty nombre;
	    private SimpleFloatProperty precio;
	    private SimpleStringProperty categoria;
	    
		public Pedido(int id, String nombre, float precio, String categoria) {
			super();
			this.id = id;
		    this.nombre = new SimpleStringProperty(nombre);
	        this.precio = new SimpleFloatProperty (precio);
	        this.categoria = new SimpleStringProperty(categoria);
		}
		public Pedido(String nombre, float precio, String categoria) {
			super();
			  this.nombre = new SimpleStringProperty(nombre);
		        this.precio = new SimpleFloatProperty (precio);
		        this.categoria = new SimpleStringProperty(categoria);
		}
		public int getId() {
	        return id;
	    }

	    public String getNombre() {
	        return nombre.get();
	    }
	    public void setNombre(String nombre) {
	        this.nombre = new SimpleStringProperty(nombre);
	    }
	    public float getPrecio() {
	        return precio.get();
	    }
	    public void setPrecio(float precio) {
	        this.precio = new SimpleFloatProperty (precio);
	    }
	    public String getCategoria() {
	        return categoria.get();
	    }
	    public void setConsola(String consola) {
	        this.categoria = new SimpleStringProperty(consola);
	    }
	   
	    
	    
}
