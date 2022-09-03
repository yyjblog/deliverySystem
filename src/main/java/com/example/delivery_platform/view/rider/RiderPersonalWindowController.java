package com.example.delivery_platform.view.rider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RiderPersonalWindowController {


    @FXML
    private Button changeHeadImageBtn;

    @FXML
    private Label idLabel;

    @FXML
    private Button changeNameBtn;

    @FXML
    private ImageView headImage;

    @FXML
    private Button changePasswdBtn;

    @FXML
    private Label emailLabel;

    @FXML
    private Label nameLabel;

    @FXML
    void onchangePasswdBtnClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("RiderChangePasswd.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setTitle("修改密码");
        stage.setScene(scene);
        stage.show();
    }


}
