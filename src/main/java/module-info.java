module com.mycompany.cifras_divisiones {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.cifras_divisiones to javafx.fxml;
    exports com.mycompany.cifras_divisiones;
}
