package com.example.delivery_platform.view.Business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class BusinessMainWindowController {

    @FXML
    private BorderPane mainPage;

    @FXML
    private Button headImageBtn;

    private void setCenter(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        loader.load();
        Parent root = loader.getRoot();
        mainPage.setCenter(root);
    }

    @FXML
    protected void headImageBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessPersonalWindow.fxml");
        setCenter(resource);
    }


    @FXML
    void onOrderBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessOrder.fxml");
        setCenter(resource);
    }

    @FXML
    void onShopBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("shopWindow.fxml");
        setCenter(resource);
    }

    @FXML
    void onTalkBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessPersonalWindow.fxml");
        setCenter(resource);
    }

}
