package co.edu.poli.proyecto.servicios;

import co.edu.poli.proyecto.model.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionArchivo {

private final String archivo = "data.dat";

public void guardarArchivo(List<Producto> lista) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        oos.writeObject(lista);
        System.out.println("Archivo guardado correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar: " + e.getMessage());
    }
}


@SuppressWarnings("unchecked")
public List<Producto> cargarArchivo() {

    File f = new File(archivo);
    if (!f.exists()) {
        System.out.println("No existe data.dat, se creará al guardar.");
        return new ArrayList<>();
    }

    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
        System.out.println("Datos cargados correctamente.");
        return (ArrayList<Producto>) ois.readObject();
    } catch (Exception e) {
        System.out.println("Error al cargar datos: " + e.getMessage());
        return new ArrayList<>();
    }
}

}
