package co.edu.poli.proyecto.model;

import java.io.Serializable;

public class Inventario implements Serializable {

private String id;
private int capacidadMaxima;
private int cantidadProductos;

public Inventario() {}

public Inventario(String id, int capacidadMaxima, int cantidadProductos) {
    this.id = id;
    this.capacidadMaxima = capacidadMaxima;
    this.cantidadProductos = cantidadProductos;
}

public String getId() { return id; }
public void setId(String id) { this.id = id; }

public int getCapacidadMaxima() { return capacidadMaxima; }
public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

public int getCantidadProductos() { return cantidadProductos; }
public void setCantidadProductos(int cantidadProductos) { this.cantidadProductos = cantidadProductos; }

@Override
public String toString() {
    return "Inventario{id='" + id + "', capacidadMaxima=" + capacidadMaxima +
           ", cantidadProductos=" + cantidadProductos + "}";
}

}
