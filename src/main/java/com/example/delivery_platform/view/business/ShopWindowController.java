package com.example.delivery_platform.view.business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopWindowController {

    @FXML
    private Button changeShopPlaceBtn;

    @FXML
    private Label shopPlaceLabel;

    @FXML
    private Label shopNameLabel;

    @FXML
    private Button changeShopNameBtn;

    @FXML
    private Button viewDishesBtn;

    @FXML
    void onManageDishBtnClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("ManageDishes.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setTitle("管理菜品");
        stage.setScene(scene);
        stage.show();
    }
}
