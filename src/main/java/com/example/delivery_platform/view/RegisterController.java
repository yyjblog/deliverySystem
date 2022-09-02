package com.example.delivery_platform.view;


import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button registerBtn;

    @FXML
    private Label registerLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwdTextField;

    @FXML
    private TextField passwd_1TextField;

    @FXML
    private TextField verificationTextField;

    @FXML
    private Label roleLabel;

    @FXML
    private Label slogansLabel;

    @FXML
    private Button verificationBtn;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    @FXML
    private Button returnBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChoiceBox.getItems().addAll("普通用户","商家","骑手");
        roleChoiceBox.getSelectionModel().selectFirst();
    }


    @FXML
    void onRegisterBtnClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("注册界面");
        stage.show();
        Stage thisStage = (Stage) registerBtn.getScene().getWindow();
        thisStage.close();
    }

}
