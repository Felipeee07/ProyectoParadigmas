module co.edu.poli.proyecto {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.proyecto.controlador to javafx.fxml;
    exports co.edu.poli.proyecto;
    opens co.edu.poli.proyecto.model to javafx.fxml;

}
