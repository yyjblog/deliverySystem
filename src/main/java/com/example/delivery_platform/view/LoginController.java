package com.example.delivery_platform.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginButton;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField passwd;
    @FXML
    private TextField verification;
    @FXML
    private Button verificationButton;



    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {
        AnchorPane settings = FXMLLoader.load(this.getClass().getResource("RegisterWindow.fxml"));
        Stage settingsStage = new Stage();
        settingsStage.setTitle("配置");
        settingsStage.setScene(new Scene(settings));
        settingsStage.show();
    }

    @FXML
    void onVerificationClicked(ActionEvent event) throws IOException {

    }
}
