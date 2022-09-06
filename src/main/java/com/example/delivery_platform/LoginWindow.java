package com.example.delivery_platform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("view/LoginWindow.fxml"));
        Scene scene=new Scene(anchorPane);
        stage.setTitle("登录窗口");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
