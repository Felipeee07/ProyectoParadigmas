package co.edu.poli.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX para la gestión de productos.
 * <p>
 * Esta clase extiende {@link Application} y se encarga de inicializar
 * la interfaz gráfica cargando el archivo FXML correspondiente.
 * </p>
 */
public class App extends Application {

    /**
     * Método principal de inicio de la aplicación JavaFX.
     * <p>
     * Carga el archivo FXML {@code Formulario.fxml}, crea la escena y
     * la asigna al escenario principal.
     * </p>
     *
     * @param stage Escenario principal de la aplicación
     * @throws Exception Si ocurre algún error al cargar el FXML
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/poli/proyecto/vista/Formulario.fxml")
        );
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.setTitle("Gestión de Productos");
        stage.show();
    }

    /**
     * Método principal que lanza la aplicación.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        launch();
    }
}
