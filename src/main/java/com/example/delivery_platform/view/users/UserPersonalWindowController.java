package com.example.delivery_platform.view.users;

import com.example.delivery_platform.dao.UserDao;
import com.example.delivery_platform.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class UserPersonalWindowController implements Initializable {
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

    private UserDao userDao;

    @FXML
    void onchangePasswdBtnClicked(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String id;
        String name;
        String account;
    }
}
