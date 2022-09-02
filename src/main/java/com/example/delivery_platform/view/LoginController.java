package com.example.delivery_platform.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
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
    private Button registerBtn;

    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {

    }

    @FXML
    void onVerificationClicked(ActionEvent event) throws IOException {


    }

    @FXML
    void onRegisterClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("RegisterWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage=new Stage();
        stage.setTitle("注册界面");
        stage.setScene(scene);
        stage.show();
        Stage thisStage = (Stage) registerBtn.getScene().getWindow();
        thisStage.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}
