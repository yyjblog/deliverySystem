module com.example.delivery_platform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.delivery_platform to javafx.fxml;
    opens com.example.delivery_platform.loginwindow to javafx.fxml;

    exports com.example.delivery_platform;
    exports com.example.delivery_platform.loginwindow;
}