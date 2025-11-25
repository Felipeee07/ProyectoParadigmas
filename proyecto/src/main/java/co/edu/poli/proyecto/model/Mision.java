package co.edu.poli.proyecto.model;

import java.io.Serializable;

/**
 * Representa una misión dentro del sistema.
 * Cada misión tiene un identificador único, descripción, fecha de inicio y fecha de fin.
 * Esta clase es serializable, lo que permite guardar y cargar objetos de tipo {@code Mision}.
 */
public class Mision implements Serializable {

    /** Identificador único de la misión. */
    private String id;

    /** Descripción de la misión. */
    private String descripcion;

    /** Fecha de inicio de la misión (formato: yyyy-MM-dd o similar). */
    private String fechaInicio;

    /** Fecha de fin de la misión (formato: yyyy-MM-dd o similar). */
    private String fechaFin;

    /**
     * Constructor vacío de la clase {@code Mision}.
     */
    public Mision() {}

    /**
     * Constructor con parámetros de la clase {@code Mision}.
     *
     * @param id Identificador único de la misión
     * @param descripcion Descripción de la misión
     * @param fechaInicio Fecha de inicio de la misión
     * @param fechaFin Fecha de fin de la misión
     */
    public Mision(String id, String descripcion, String fechaInicio, String fechaFin) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Obtiene el identificador de la misión.
     *
     * @return El id de la misión
     */
    public String getId() { return id; }

    /**
     * Establece el identificador de la misión.
     *
     * @param id Nuevo id de la misión
     */
    public void setId(String id) { this.id = id; }

    /**
     * Obtiene la descripción de la misión.
     *
     * @return La descripción de la misión
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripción de la misión.
     *
     * @param descripcion Nueva descripción de la misión
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Obtiene la fecha de inicio de la misión.
     *
     * @return La fecha de inicio
     */
    public String getFechaInicio() { return fechaInicio; }

    /**
     * Establece la fecha de inicio de la misión.
     *
     * @param fechaInicio Nueva fecha de inicio
     */
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    /**
     * Obtiene la fecha de fin de la misión.
     *
     * @return La fecha de fin
     */
    public String getFechaFin() { return fechaFin; }

    /**
     * Establece la fecha de fin de la misión.
     *
     * @param fechaFin Nueva fecha de fin
     */
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    /**
     * Devuelve una representación en {@code String} de la misión.
     *
     * @return Cadena con los datos de la misión
     */
    @Override
    public String toString() {
        return "Mision{id='" + id + "', descripcion='" + descripcion +
               "', fechaInicio='" + fechaInicio + "', fechaFin='" + fechaFin + "'}";
    }
}
