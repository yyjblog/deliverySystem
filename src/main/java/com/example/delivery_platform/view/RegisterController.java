package com.example.delivery_platform.view;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {

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

    public void choose(){
        roleChoiceBox.getItems().addAll("scsa","caasc","caas");
    }

}
