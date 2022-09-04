package com.example.delivery_platform.view.users;

import com.example.delivery_platform.TPC.Client;
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

public class UserMainWindowController extends Client{

    @FXML
    private Button headImageBtn;

    @FXML
    private BorderPane mainPage;

    @FXML
    private Button buyBtn;

    @FXML
    private Button talkBtn;

    @FXML
    private Button orderBtn;

    //创建客户端
    public void initialize(){
        super.connect("user");
    }

    //设置中心区域
    private void setCenter(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        loader.load();
        Parent root = loader.getRoot();
        mainPage.setCenter(root);
    }

    @FXML
    void onHeadImageBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("UserPersonalWindow.fxml");
        setCenter(resource);
    }

    @FXML
    void onBuyBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("ViewShopWindow.fxml");
        setCenter(resource);
    }

    @FXML
    void onOrderBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("UserOrderWindow.fxml");
        setCenter(resource);
    }

    @FXML
    void onTalkBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("UserTalkWindow.fxml");
        setCenter(resource);
    }
}
