module com.example.delivery_platform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.delivery_platform to javafx.fxml;
    opens com.example.delivery_platform.view to javafx.fxml;

    exports com.example.delivery_platform;
    exports com.example.delivery_platform.view;
    exports com.example.delivery_platform.view.business;
    opens com.example.delivery_platform.view.business to javafx.fxml;
    exports com.example.delivery_platform.view.users;
    opens com.example.delivery_platform.view.users to javafx.fxml;
    exports com.example.delivery_platform.view.rider;
    opens com.example.delivery_platform.view.rider to javafx.fxml;

}