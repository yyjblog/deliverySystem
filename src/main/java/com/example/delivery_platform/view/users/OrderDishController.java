package com.example.delivery_platform.view.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDishController implements Initializable {
    @FXML
    private Button returnBtn;

    @FXML
    private Button orderBtn;

    @FXML
    private TableView<?> dishTableView;
    @FXML
    void onReturnBtnClicked(ActionEvent event) {
        Stage thisStage= (Stage) returnBtn.getScene().getWindow();
        thisStage.close();

    }

    @FXML
    void onOrderBtnClicked(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
