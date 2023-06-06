module com.example.electronic {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.electronic to javafx.fxml;
    exports com.example.electronic;
}