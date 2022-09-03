package com.example.delivery_platform.view.rider;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RiderMainWindowController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    private Stage stage;

    private Stage getStage() {
        if (stage == null) {
            stage = (Stage) anchorPane.getScene().getWindow();
        }
        return stage;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var stage = getStage();
        stage.setTitle("骑手界面");
    }
}
