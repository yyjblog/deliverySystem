package com.example.delivery_platform.view.business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BusinessMainWindowController implements Initializable {

    @FXML
    private BorderPane mainPage;

    @FXML
    private Button headImageBtn;

    //设置中心区域
    private void setCenter(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        loader.load();
        Parent root = loader.getRoot();
        mainPage.setCenter(root);
    }
    //头像点击
    @FXML
    protected void headImageBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessPersonalWindow.fxml");
        setCenter(resource);
    }

   //订单点击
    @FXML
    void onOrderBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessOrder.fxml");
        setCenter(resource);
    }

    //商铺点击
    @FXML
    void onShopBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("shopWindow.fxml");
        setCenter(resource);
    }

    //会话点击
    @FXML
    void onTalkBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("BusinessTalkWindow.fxml");
        setCenter(resource);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Stage thisStage = (Stage) mainPage.getScene().getWindow();
//        thisStage.setTitle("商家界面");
    }
}