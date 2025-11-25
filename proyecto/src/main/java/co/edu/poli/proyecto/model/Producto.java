package co.edu.poli.proyecto.model;

import java.io.Serializable;

/**
 * Representa un producto dentro del inventario del sistema.
 * Cada producto tiene un código único, un nombre, fecha de caducidad y cantidad disponible.
 * Esta clase es serializable, lo que permite guardar y cargar objetos de tipo {@code Producto}.
 */
public class Producto implements Serializable {

    /** Código único del producto. */
    private String codigo;

    /** Nombre del producto. */
    private String nombre;

    /** Fecha de caducidad del producto (formato: yyyy-MM-dd o similar). */
    private String fechaCaducidad;

    /** Cantidad disponible del producto en el inventario. */
    private int cantidad;

    /**
     * Constructor vacío de la clase {@code Producto}.
     */
    public Producto() {}

    /**
     * Constructor con parámetros de la clase {@code Producto}.
     *
     * @param codigo Código único del producto
     * @param nombre Nombre del producto
     * @param fechaCaducidad Fecha de caducidad del producto
     * @param cantidad Cantidad disponible
     */
    public Producto(String codigo, String nombre, String fechaCaducidad, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.cantidad = cantidad;
    }

    /**
     * Verifica si el producto está caducado.
     * <p>Actualmente este método siempre devuelve {@code false}.</p>
     *
     * @return {@code true} si el producto está caducado, {@code false} en caso contrario
     */
    public boolean esCaducado() {
        return false;
    }

    /**
     * Obtiene el código del producto.
     *
     * @return El código del producto
     */
    public String getCodigo() { return codigo; }

    /**
     * Establece el código del producto.
     *
     * @param codigo Nuevo código del producto
     */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene la fecha de caducidad del producto.
     *
     * @return La fecha de caducidad
     */
    public String getFechaCaducidad() { return fechaCaducidad; }

    /**
     * Establece la fecha de caducidad del producto.
     *
     * @param fechaCaducidad Nueva fecha de caducidad
     */
    public void setFechaCaducidad(String fechaCaducidad) { this.fechaCaducidad = fechaCaducidad; }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return La cantidad disponible
     */
    public int getCantidad() { return cantidad; }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidad Nueva cantidad disponible
     */
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    /**
     * Devuelve una representación en {@code String} del producto.
     *
     * @return Cadena con los datos del producto
     */
    @Override
    public String toString() {
        return "Producto{codigo='" + codigo + "', nombre='" + nombre +
               "', fechaCaducidad='" + fechaCaducidad + "', cantidad=" + cantidad + "}";
    }
}
