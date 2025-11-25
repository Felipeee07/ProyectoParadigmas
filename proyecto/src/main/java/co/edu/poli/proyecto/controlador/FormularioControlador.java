package co.edu.poli.proyecto.controlador;

import co.edu.poli.proyecto.model.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;

public class FormularioControlador {


@FXML private TextField txtCodigo;
@FXML private TextField txtNombre;
@FXML private TextField txtFechaCaducidad;
@FXML private TextField txtCantidad;

@FXML private TableView<Producto> tabla;
@FXML private TableColumn<Producto, String> colCodigo;
@FXML private TableColumn<Producto, String> colNombre;
@FXML private TableColumn<Producto, String> colFecha;
@FXML private TableColumn<Producto, String> colCantidad;

private ObservableList<Producto> lista = FXCollections.observableArrayList();

@FXML
public void initialize() {

    colCodigo.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCodigo()));
    colNombre.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNombre()));
    colFecha.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getFechaCaducidad()));
    colCantidad.setCellValueFactory(c -> new SimpleStringProperty(String.valueOf(c.getValue().getCantidad())));

    // === Cargar datos al seleccionar un elemento de la tabla ===
    tabla.setOnMouseClicked(event -> {
        Producto p = tabla.getSelectionModel().getSelectedItem();
        if (p != null) {
            txtCodigo.setText(p.getCodigo());
            txtNombre.setText(p.getNombre());
            txtFechaCaducidad.setText(p.getFechaCaducidad());
            txtCantidad.setText(String.valueOf(p.getCantidad()));
            txtCodigo.setDisable(true);
        }
    });
}

// =========================
// CREAR
// =========================
@FXML
private void accionCrear() {

    try {

        Producto p = new Producto(
                txtCodigo.getText(),
                txtNombre.getText(),
                txtFechaCaducidad.getText(),
                Integer.parseInt(txtCantidad.getText())
        );

        lista.add(p);
        tabla.setItems(lista);
        tabla.refresh();
        limpiarCampos();
        mostrarInfo("Producto creado correctamente.");

    } catch (Exception e) {
        mostrarError("Datos inválidos: " + e.getMessage());
    }
}

// =========================
// BUSCAR
// =========================
@FXML
private void accionBuscar() {

    String cod = txtCodigo.getText();

    for (Producto p : lista) {
        if (p.getCodigo().equals(cod)) {
            llenarCampos(p);
            txtCodigo.setDisable(true);
            return;
        }
    }

    mostrarInfo("No existe un producto con ese código.");
}

private void llenarCampos(Producto p) {
    txtCodigo.setText(p.getCodigo());
    txtNombre.setText(p.getNombre());
    txtFechaCaducidad.setText(p.getFechaCaducidad());
    txtCantidad.setText(String.valueOf(p.getCantidad()));
}

// =========================
// LISTAR
// =========================
@FXML
private void accionListar() {
    tabla.setItems(lista);
    tabla.refresh();
}


// =========================
// MODIFICAR
// =========================
@FXML
private void accionModificar() {

    String cod = txtCodigo.getText();

    for (int i = 0; i < lista.size(); i++) {

        Producto actual = lista.get(i);
        if (actual.getCodigo().equals(cod)) {

            try {
                Producto nuevo = new Producto(
                        cod,
                        txtNombre.getText(),
                        txtFechaCaducidad.getText(),
                        Integer.parseInt(txtCantidad.getText())
                );

                lista.set(i, nuevo);
                tabla.refresh();
                limpiarCampos();
                mostrarInfo("Producto modificado correctamente.");
                return;

            } catch (Exception e) {
                mostrarError("Datos inválidos al modificar: " + e.getMessage());
                return;
            }
        }
    }

    mostrarError("No se encontró el producto para modificar.");
}

// =========================
// ELIMINAR
// =========================
@FXML
private void accionEliminar() {

    Producto seleccionado = tabla.getSelectionModel().getSelectedItem();

    if (seleccionado == null) {
        mostrarError("Seleccione un producto en la tabla para eliminar.");
        return;
    }

    lista.remove(seleccionado);
    tabla.refresh();
    limpiarCampos();
    mostrarInfo("Producto eliminado correctamente.");
}

// =========================
// SERIALIZAR
// =========================
@FXML
private void accionSerializar() {

    try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("productos.dat"))) {
        out.writeObject(new ArrayList<>(lista));
        mostrarInfo("Datos guardados correctamente.");

    } catch (IOException e) {
        mostrarError("Error al guardar: " + e.getMessage());
    }
}

// =========================
// DESERIALIZAR
// =========================
@FXML
private void accionDeserializar() {

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("productos.dat"))) {

        lista.setAll((ArrayList<Producto>) in.readObject());

        // OJO: aquí NO debes hacer tabla.setItems(lista)
        // para que solo se muestre cuando el usuario presione LISTAR

        mostrarInfo("Datos cargados correctamente.\nPresione LISTAR para verlos.");

    } catch (Exception e) {
        mostrarError("Error al cargar: " + e.getMessage());
    }
}

// =========================
// UTILIDADES
// =========================
private void limpiarCampos() {
    txtCodigo.clear();
    txtNombre.clear();
    txtFechaCaducidad.clear();
    txtCantidad.clear();
    txtCodigo.setDisable(false);
}

private void mostrarError(String m) {
    new Alert(Alert.AlertType.ERROR, m).show();
}

private void mostrarInfo(String m) {
    new Alert(Alert.AlertType.INFORMATION, m).show();
}


}
