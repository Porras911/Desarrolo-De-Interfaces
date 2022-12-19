package application;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Videojuego {

    private int id;
    private SimpleStringProperty nombre;
    private SimpleFloatProperty precio;
    private SimpleStringProperty consola;
    private SimpleIntegerProperty pegi;

    public Videojuego(String nombre, float precio, String consola,
            int pegi) {
        super();
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleFloatProperty (precio);
        this.consola = new SimpleStringProperty(consola);
        this.pegi = new SimpleIntegerProperty (pegi);
    }

    public Videojuego(int id, String nombre, float precio, String consola,
            int pegi) {
        super();
        this.id = id;
        this.nombre = new SimpleStringProperty(nombre);
        this.precio = new SimpleFloatProperty (precio);
        this.consola = new SimpleStringProperty(consola);
        this.pegi = new SimpleIntegerProperty (pegi);
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
    public String getConsola() {
        return consola.get();
    }
    public void setConsola(String consola) {
        this.consola = new SimpleStringProperty(consola);
    }
    public int getPegi() {
        return pegi.get();
    }
    public void setPegi(int pegi) {
        this.pegi = new SimpleIntegerProperty (pegi);
    }


}