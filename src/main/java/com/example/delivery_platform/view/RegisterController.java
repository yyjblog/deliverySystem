package com.example.delivery_platform.view;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    public Stage stage;

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

    @FXML
    protected  void onReturnBtnClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("loginWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("登录界面");
        stage.setScene(scene);
        stage.show();
    }
}
