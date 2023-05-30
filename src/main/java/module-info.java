module com.example.proyectofinal2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;


    opens com.example.proyectofinal2 to javafx.fxml;
    exports com.example.proyectofinal2;
}