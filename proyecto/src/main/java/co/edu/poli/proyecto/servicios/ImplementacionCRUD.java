package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz {@link OperacionCRUD} para manejar operaciones CRUD
 * sobre objetos {@link Producto}.
 * <p>
 * Esta clase mantiene una lista de productos en memoria y se encarga de serializarlos
 * y deserializarlos usando la clase {@link OperacionArchivo}.
 * </p>
 */
public class ImplementacionCRUD implements OperacionCRUD {

    /** Lista interna de productos. */
    private List<Producto> productos;

    /** Objeto encargado de guardar y cargar la lista de productos desde archivo. */
    private OperacionArchivo archivo;

    /**
     * Constructor que inicializa la lista de productos cargando desde el archivo.
     * Si el archivo no existe o está vacío, crea una lista vacía.
     */
    public ImplementacionCRUD() {
        archivo = new OperacionArchivo();
        productos = archivo.cargarArchivo(); // Si no existe, devuelve lista vacía

        if (productos == null) {
            productos = new ArrayList<>();
        }
    }

    /**
     * Crea un nuevo producto y lo agrega a la lista.
     * También serializa la lista para guardar los cambios.
     *
     * @param p Producto a crear
     * @return Mensaje de éxito o error
     */
    @Override
    public String create(Producto p) {
        productos.add(p);
        serializar();
        return "Producto creado exitosamente";
    }

    /**
     * Devuelve un arreglo con todos los productos actuales.
     *
     * @return Arreglo de productos
     */
    @Override
    public Producto[] read() {
        return productos.toArray(new Producto[0]);
    }

    /**
     * Busca y devuelve un producto por su código.
     *
     * @param serial Código del producto
     * @return Producto encontrado o {@code null} si no existe
     */
    @Override
    public Producto read(String serial) {
        return productos.stream()
                .filter(p -> p.getCodigo().equals(serial))
                .findFirst()
                .orElse(null);
    }

    /**
     * Actualiza un producto existente identificado por su código.
     * Serializa la lista después de la actualización.
     *
     * @param serial Código del producto a actualizar
     * @param p Producto con los nuevos datos
     * @return Mensaje de éxito o error si no se encuentra el producto
     */
    @Override
    public String update(String serial, Producto p) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(serial)) {
                productos.set(i, p);
                serializar();
                return "Producto actualizado exitosamente";
            }
        }
        return "Error: Producto no encontrado";
    }

    /**
     * Elimina un producto de la lista identificado por su código.
     * Serializa la lista después de eliminar.
     *
     * @param serial Código del producto a eliminar
     * @return Mensaje de éxito o error si no se encuentra el producto
     */
    @Override
    public String delete(String serial) {
        Producto encontrado = read(serial);
        if (encontrado != null) {
            productos.remove(encontrado);
            serializar();
            return "Producto eliminado exitosamente";
        }
        return "Error: Producto no encontrado";
    }

    /**
     * Carga nuevamente la lista de productos desde el archivo.
     * Si no existe el archivo o está vacío, crea una lista vacía.
     */
    public void deserializar() {
        productos = archivo.cargarArchivo();
        if (productos == null) {
            productos = new ArrayList<>();
        }
    }

    /**
     * Serializa la lista de productos y la guarda en el archivo.
     */
    public void serializar() {
        archivo.guardarArchivo(productos);
    }

    /**
     * Devuelve la lista interna de productos.
     *
     * @return Lista de productos
     */
    public List<Producto> getProductosLista() {
        return productos;
    }
}
