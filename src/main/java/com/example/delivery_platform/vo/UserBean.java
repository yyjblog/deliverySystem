package com.example.delivery_platform.vo;

public class UserBean {
    private String UserAccount;
    private String UserPassword;
    private String UserName;
    private String UserRole;
    private String UserFaceImage;

    public UserBean(String userAccount, String userPassword, String userName, String userRole, String userFaceImage) {
        UserAccount = userAccount;
        UserPassword = userPassword;
        UserName = userName;
        UserRole = userRole;
        UserFaceImage = userFaceImage;
    }

    public UserBean() {
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String userRole) {
        UserRole = userRole;
    }

    public String getUserFaceImage() {
        return UserFaceImage;
    }

    public void setUserFaceImage(String userFaceImage) {
        UserFaceImage = userFaceImage;
    }
}
