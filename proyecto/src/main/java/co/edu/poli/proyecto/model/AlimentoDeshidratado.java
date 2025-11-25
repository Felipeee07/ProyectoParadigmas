package co.edu.poli.proyecto.model;

import java.io.Serializable;

public class AlimentoDeshidratado extends Producto implements Serializable {


private double temperaturaEsperada;

public AlimentoDeshidratado() { super(); }

public AlimentoDeshidratado(String codigo, String nombre, String fechaCaducidad,
                            int cantidad, double temperaturaEsperada) {
    super(codigo, nombre, fechaCaducidad, cantidad);
    this.temperaturaEsperada = temperaturaEsperada;
}

@Override
public boolean esCaducado() {
    return super.esCaducado();
}

public double getTemperaturaEsperada() { return temperaturaEsperada; }
public void setTemperaturaEsperada(double temperaturaEsperada) {
    this.temperaturaEsperada = temperaturaEsperada;
}

@Override
public String toString() {
    return "AlimentoDeshidratado{" + super.toString() +
           ", temperaturaEsperada=" + temperaturaEsperada + "}";
}


}
