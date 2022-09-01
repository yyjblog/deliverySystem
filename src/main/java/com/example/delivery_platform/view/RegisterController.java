package com.example.delivery_platform.view;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Label registerLabel;

    @FXML
    private TextField verificationTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label roleLabel;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    @FXML
    private Label slogansLabel;

    @FXML
    private Button returnBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private Button verificationBtn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleChoiceBox.getItems().addAll("普通用户","商家","骑手");
        roleChoiceBox.getSelectionModel().selectFirst();
    }
}
