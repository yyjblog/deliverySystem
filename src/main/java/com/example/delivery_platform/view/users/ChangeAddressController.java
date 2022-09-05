package com.example.delivery_platform.view.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangeAddressController {
    @FXML
    private TextField addressTextField;

    @FXML
    private Button cancelBrn;

    @FXML
    private Button commitBtn;
    @FXML
    void onCommitBtnClicked(ActionEvent event) {
        /*
         *
         * 写如何改名字
         *
         * */
        Stage thisStage=(Stage) cancelBrn.getScene().getWindow();
        thisStage.close();

    }

    @FXML
    void onCancelBrnClicked(ActionEvent event) {
        Stage thisStage=(Stage) cancelBrn.getScene().getWindow();
        thisStage.close();
    }
}
