package com.example.delivery_platform.view;

import com.example.delivery_platform.dao.UserDao;
import com.example.delivery_platform.mail.Mail;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Stage stage =null;

    //lws新增成员
    @FXML
    private TextField mailTextFiled;
    @FXML
    private TextField PasswordTextFiled;
    @FXML
    private TextField verificationTextFiled;
    @FXML
    private Button verificationBtn;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerBtn;
    @FXML
    private Label CheckPasswordLabel;
    @FXML
    private Label CheckmailLabel;
    @FXML
    private Label CheckVerificationLabel;
    @FXML
    private Label LoginResult;

    Mail mail = new Mail();

    @FXML
    void onLoginClicked(ActionEvent event) throws IOException {

            String email = mailTextFiled.getText();
            String password = PasswordTextFiled.getText();
            String verification= verificationTextFiled.getText();
            String VertificationCode = mail.getResult;


        //每次点击登录，都要让所有提示文本变为空
        CheckmailLabel.setText("");
        CheckPasswordLabel.setText("");
        CheckVerificationLabel.setText("");
        LoginResult.setText("");

        try {
            UserDao userDao = new UserDao();
            userDao.getUserAccount(email);
            userDao.getUserPassword(email);
            userDao.getUserRole(email);
            if ((email.length() == 0) && (password.length() == 0)) {
                CheckmailLabel.setText("请填写邮箱");
                CheckPasswordLabel.setText("请填写密码");
            } else if ((email.length() == 0) && (password.length() > 0)) {
                CheckmailLabel.setText("请填写邮箱");
            } else if ((email.length() > 0) && (password.length() == 0)) {
                CheckPasswordLabel.setText("请填写密码");
            }
            else {

                if(userDao.UserAccountResult == null){
                    CheckmailLabel.setText("该邮箱未注册");
                }

                //验证验证码
                else if (verification.length()==0) {
                    CheckVerificationLabel.setText("请填写验证码");
                }

                else{
                    if(userDao.UserPasswordResult.equals(password)&&verification.equals(VertificationCode)){
                        String role=userDao.UserRoledResult;
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
                    }else{
                        LoginResult.setText("登陆错误");
                        if(!userDao.UserPasswordResult.equals(password))
                            CheckPasswordLabel.setText("密码错误");
                        if(!verification.equals(VertificationCode))
                            CheckVerificationLabel.setText("验证码错误");

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onVerificationClicked(ActionEvent event) throws IOException {
        String UserAccount;
        UserAccount = mailTextFiled.getText();
        try {
            UserAccount = mailTextFiled.getText();
            mail.sendMail(UserAccount);
//            System.out.println("验证码是：" + mail.getResult);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onRegisterClicked(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("RegisterWindow.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage=new Stage();
        stage.setTitle("注册界面");
        stage.setScene(scene);
        stage.show();
        Stage thisStage = (Stage) registerBtn.getScene().getWindow();
        thisStage.hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }




}
