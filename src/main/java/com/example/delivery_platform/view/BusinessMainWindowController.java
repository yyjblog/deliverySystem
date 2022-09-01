package com.example.delivery_platform.view;

import com.example.delivery_platform.LoginWindow;
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
    protected void test(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("LoginWindow.fxml");
        setCenter(resource);
    }
}
