module com.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires javafx.media;


    opens com.example.javafx to javafx.fxml;
    exports com.example.javafx;
    exports com.example.javafx.controller;
    opens com.example.javafx.controller to javafx.fxml;
}