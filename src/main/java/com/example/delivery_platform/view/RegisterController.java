package com.example.delivery_platform.view;

import com.example.delivery_platform.dao.UserDao;
import com.example.delivery_platform.mail.Mail;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import com.example.delivery_platform.TPC.Client;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Button registerBtn;

    @FXML
    private Label registerLabel;

    @FXML
    private Label CheckPasswordLabel;

    @FXML
    private Label UserNameLabel;

    @FXML
    private Label vertificationLabel;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField passwdTextField;

    @FXML
    private TextField passwd_1TextField;

    @FXML
    private TextField verificationTextField;

    @FXML
    private Label roleLabel;

    @FXML
    private Label slogansLabel;

    @FXML
    private Button verificationBtn;

    @FXML
    private ChoiceBox<String> roleChoiceBox;

    @FXML
    private Button returnBtn;

    //lws新增

    Mail mail = new Mail();
    private Timeline animation;
    private String S = "";
    private int tmp = 62;

    public String mailResult;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        roleChoiceBox.getItems().addAll("普通用户","商家","骑手");
        roleChoiceBox.getSelectionModel().selectFirst();


    }


    //进行注册
    @FXML
    void onRegisterBtnClicked(ActionEvent event) throws IOException {
        try {

            UserDao userDao = new UserDao();
            String UserName = nameTextField.getText();
            String UserPassword = passwdTextField.getText();
            String UserPassword_1 = passwd_1TextField.getText();
            String UserAccount = emailTextField.getText();
            String UserRole = roleChoiceBox.getValue();
            String getVertificationCode = verificationTextField.getText();




            AnchorPane anchorPane = null;


            //-----查找邮箱是否已经被注册了-----
            //查找是否数据库中已有的邮箱有与现在输入的邮箱一致的
            //这里可能有问题，没写完lp
            userDao.getUserAccount(UserAccount);
            /*if(userDao.UserAccountResult == null) {
                    userDao.addUser(UserAccount, UserPassword, UserName, UserRole, "");

            }else{
                registerLabel.setText("该邮箱已注册！");
            }*/
            //每次点击注册都让所有本文变为空
            /*
             *
             *
             * 逻辑问题，可能要改改
             * */
            CheckPasswordLabel.setText("");
            UserNameLabel.setText("");
            vertificationLabel.setText("");
            registerLabel.setText("");

            //发送验证码
            String VertificationCode = mail.getResult;

            if(UserName.length() == 0){
                UserNameLabel.setText("请填写昵称");
            }else{
                if(UserPassword.equals(UserPassword_1)){
                    if(userDao.UserAccountResult == null){
                        if(getVertificationCode.length() == 0 ){
                            vertificationLabel.setText("请先获取验证码");
                        }else {
                            if (VertificationCode.equals(getVertificationCode)) {
                                userDao.addUser(UserAccount, UserPassword, UserName, UserRole, "");



                                switch (UserRole) {
                                    case "普通用户":
                                        anchorPane = FXMLLoader.load(this.getClass().getResource("users/UserMainWindow.fxml"));
                                        break;
                                    case "商家":
                                        anchorPane = FXMLLoader.load(this.getClass().getResource("business/BusinessMainWindow.fxml"));
                                        break;
                                    case "骑手":
                                        anchorPane = FXMLLoader.load(this.getClass().getResource("rider/RiderMainWindow.fxml"));
                                        break;
                                }

                                Scene scene = new Scene(anchorPane);
                                Stage stage = new Stage();
                                stage.setScene(scene);
                                stage.setTitle(UserRole);
                                stage.show();
                                Stage thisStage = (Stage) registerBtn.getScene().getWindow();
                                thisStage.close();


                            } else {
                                vertificationLabel.setText("请输入正确的验证码");
                            }
                        }
                    }else{
                        registerLabel.setText("邮箱已注册");
                    }
                }else{
                    CheckPasswordLabel.setText("请填写两次相同的密码");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        String role = roleChoiceBox.getValue();
        AnchorPane anchorPane = null;

        switch (role) {
            case "普通用户":
                anchorPane = FXMLLoader.load(this.getClass().getResource("users/UserMainWindow.fxml"));
                break;
            case "商家":
                anchorPane = FXMLLoader.load(this.getClass().getResource("business/BusinessMainWindow.fxml"));
                break;
            case "骑手":
                anchorPane = FXMLLoader.load(this.getClass().getResource("rider/RiderMainWindow.fxml"));
                break;
        }
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(role);
        stage.show();
        Stage thisStage = (Stage) registerBtn.getScene().getWindow();
        thisStage.close();
    }
    //获取验证码
    @FXML
    void getVertificationCode(ActionEvent event) throws IOException {
        tmp=61;
        Clock();
        String UserAccount;
        UserAccount = emailTextField.getText();
        try {
            UserAccount = emailTextField.getText();
            mail.sendMail(UserAccount);
//            System.out.println("验证码是：" + mail.getResult);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public void timelabel() {
        if (tmp>0) {
            verificationBtn.setDisable(true);
            tmp--;
        }
        S = tmp + "s";
        verificationBtn.setText(S);
        if(tmp==0) {
            verificationBtn.setText("获取验证码");
            verificationBtn.setDisable(false);
        }
    }
    public void Clock() {
        animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> timelabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    //返回登录界面
    @FXML
    void onReturnBtnClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
        Stage thisStage = (Stage) registerBtn.getScene().getWindow();
        thisStage.close();
    }
}
