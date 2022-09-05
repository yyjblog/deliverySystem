package com.example.delivery_platform.view.business;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePasswdController {
    @FXML
    private TextField newPasswd_2;

    @FXML
    private TextField newPasswd_1;

    @FXML
    private Button cancelBrn;

    @FXML
    private Button commitBtn;

    @FXML
    private TextField oldPasswd;

    @FXML
    private Label checkPasswdLabel;

    @FXML
    void onCommitBtnClicked(ActionEvent event) {
        if(validPasswd()){
            /*
             *
             * 写如何将数据库密码修改
             *
             *
             * */
            Stage thisStage=(Stage) cancelBrn.getScene().getWindow();
            thisStage.close();
        }
    }

    @FXML
    void onCancelBrnClicked(ActionEvent event) {
        Stage thisStage=(Stage) cancelBrn.getScene().getWindow();
        thisStage.close();
    }


    //判断密码是否合法
    public boolean validPasswd(){
        String pwd_1=newPasswd_1.getText();
        String pwd_2=newPasswd_2.getText();
        String oldPwd=oldPasswd.getText();

        if (pwd_1.length()==0||pwd_2.length()==0||oldPwd.length()==0){
            checkPasswdLabel.setText("请填写完整");
            return false;
        }
        else {
            if (!oldPwd.equals("123456")) {        //将此处括号内改为验证密码是否相同
                checkPasswdLabel.setText("原密码错误");
                return false;
            }
            if (!pwd_1.equals(pwd_2)){
                checkPasswdLabel.setText("两次密码填写不同");
                return false;
            }
            if(pwd_1.equals(oldPwd)){
                checkPasswdLabel.setText("新旧密码不能相同");
                return false;
            }
            return true;

        }

    }
}