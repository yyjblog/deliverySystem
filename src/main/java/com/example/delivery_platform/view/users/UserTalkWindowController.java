package com.example.delivery_platform.view.users;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import static com.example.delivery_platform.TPC.Client.send;
import static com.example.delivery_platform.view.users.UserMainWindowController.ownClient;

public class UserTalkWindowController {
    @FXML
    private TextArea talkTextField;

    @FXML
    private Button sendBtn;

    @FXML
    private TextArea messageTextField;

    @FXML
    private Label talkObject;

    @FXML
    private void sendBtnClicked(){
        send(messageTextField.getText(),ownClient.getSocket());
    }
}
