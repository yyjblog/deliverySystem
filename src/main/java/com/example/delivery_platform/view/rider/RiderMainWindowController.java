package com.example.delivery_platform.view.rider;

import com.example.delivery_platform.TPC.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RiderMainWindowController implements Initializable {

    protected static Client ownClient;

    static {
        try {
            ownClient = new Client();
            ownClient.connect("rider");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button headImageBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private Button talkBtn;

    @FXML
    private BorderPane mainPage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //设置中心区域
    private void setCenter(URL url) throws IOException {
        FXMLLoader loader = new FXMLLoader(url);
        loader.load();
        Parent root = loader.getRoot();
        mainPage.setCenter(root);
    }
    //头像点击
    @FXML
    protected void onHeadImageBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("RiderPersonalWindow.fxml");
        setCenter(resource);
    }

    //任务点击
    @FXML
    void onTaskBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("RiderTaskWindow.fxml");
        setCenter(resource);
    }

    //会话点击
    @FXML
    void onTalkBtnClicked(ActionEvent event) throws IOException {
        URL resource = getClass().getResource("RiderTalkWindow.fxml");
        setCenter(resource);
    }

}
