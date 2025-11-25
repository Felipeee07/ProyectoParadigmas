package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.model.Producto;

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre objetos de tipo {@link Producto}.
 * <p>
 * Las clases que implementen esta interfaz deberán proveer la lógica
 * para manejar productos en memoria, bases de datos o archivos.
 * </p>
 */
public interface OperacionCRUD {

    /**
     * Crea un nuevo producto y lo agrega al sistema.
     *
     * @param p Producto a crear
     * @return Mensaje indicando éxito o fallo de la operación
     */
    String create(Producto p);

    /**
     * Devuelve todos los productos disponibles.
     *
     * @return Arreglo con todos los productos
     */
    Producto[] read();

    /**
     * Busca un producto por su código único.
     *
     * @param serial Código del producto a buscar
     * @return Producto encontrado o {@code null} si no existe
     */
    Producto read(String serial);

    /**
     * Actualiza un producto existente identificado por su código.
     *
     * @param serial Código del producto a actualizar
     * @param p Producto con los nuevos datos
     * @return Mensaje indicando éxito o error si no se encuentra el producto
     */
    String update(String serial, Producto p);

    /**
     * Elimina un producto del sistema identificado por su código.
     *
     * @param serial Código del producto a eliminar
     * @return Mensaje indicando éxito o error si no se encuentra el producto
     */
    String delete(String serial);
}
