module com.example.registro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.registro to javafx.fxml;
    exports com.example.registro;
}