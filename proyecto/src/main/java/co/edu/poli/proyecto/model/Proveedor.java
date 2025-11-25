package co.edu.poli.proyecto.model;

import java.io.Serializable;

/**
 * Representa un proveedor dentro del sistema.
 * Cada proveedor tiene un identificador único, un nombre y un lugar de origen.
 * Esta clase es serializable, lo que permite guardar y cargar objetos de tipo {@code Proveedor}.
 */
public class Proveedor implements Serializable {

    /** Identificador único del proveedor. */
    private String id;

    /** Nombre del proveedor. */
    private String nombre;

    /** Lugar de origen del proveedor. */
    private String lugarOrigen;

    /**
     * Constructor vacío de la clase {@code Proveedor}.
     */
    public Proveedor() {}

    /**
     * Constructor con parámetros de la clase {@code Proveedor}.
     *
     * @param id Identificador único del proveedor
     * @param nombre Nombre del proveedor
     * @param lugarOrigen Lugar de origen del proveedor
     */
    public Proveedor(String id, String nombre, String lugarOrigen) {
        this.id = id;
        this.nombre = nombre;
        this.lugarOrigen = lugarOrigen;
    }

    /**
     * Obtiene el identificador del proveedor.
     *
     * @return El id del proveedor
     */
    public String getId() { return id; }

    /**
     * Establece el identificador del proveedor.
     *
     * @param id Nuevo id del proveedor
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return El nombre del proveedor
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre Nuevo nombre del proveedor
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene el lugar de origen del proveedor.
     *
     * @return El lugar de origen
     */
    public String getLugarOrigen() { return lugarOrigen; }

    /**
     * Establece el lugar de origen del proveedor.
     *
     * @param lugarOrigen Nuevo lugar de origen
     */
    public void setLugarOrigen(String lugarOrigen) { this.lugarOrigen = lugarOrigen; }

    /**
     * Devuelve una representación en {@code String} del proveedor.
     *
     * @return Cadena con los datos del proveedor
     */
    @Override
    public String toString() {
        return "Proveedor{id='" + id + "', nombre='" + nombre +
               "', lugarOrigen='" + lugarOrigen + "'}";
    }
}
