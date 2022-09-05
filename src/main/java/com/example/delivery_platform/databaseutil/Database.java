package com.example.delivery_platform.databaseutil;

import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
    //url中需更改为可用的数据库，并将账号密码一并更改
    private String url ="jdbc:mysql://localhost:3306/testdb?useSSL=true&useUnicode=true&characterEncoding=utf-8&iserverTimezone=Asia/Shanghai";
    private final static String driver = "com.mysql.cj.jdbc.Driver";
    private String userName = "root"; //数据库账号名
    private String password = "452544248"; //数据库密码
    private Connection connection;

    //连接数据库
    public  void connect()throws Exception {
        try {
            Class.forName(driver);  //动态加载并初始化mysql数据库类
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("数据库连接成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库连接不成功");
        }
    }


    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
