package com.example.delivery_platform.MySQLTest;

import java.io.*;
import java.util.*;
//import java.sql.*;

public class Test {
    public static void main(String[] args) throws Exception {

        System.out.println("sdfsdfsdfds");
//        1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//        2.用户信息和url
        String url = "jdbc:DeliveryDataBase://localhost:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "root";
////        3.连接成功，数据库对象 Connection
//        Connection connection = DriverManager.getConnection(url,username,password);
////        4.执行SQL对象Statement，执行SQL的对象
//        Statement statement = connection.createStatement();
////        5.执行SQL的对象去执行SQL，返回结果集
//        String sql = "SELECT *FROM studentinfo;";
//        ResultSet resultSet = statement.executeQuery(sql);
//        while(resultSet.next()){
//            System.out.println("SNo="+resultSet.getString("SNo"));
//            System.out.println("SName="+resultSet.getString("SName"));
//            System.out.println("Birth="+resultSet.getString("Birth"));
//            System.out.println("SPNo="+resultSet.getString("SPNo"));
//            System.out.println("Major="+resultSet.getString("Major"));
//            System.out.println("Grade="+resultSet.getString("Grade"));
//            System.out.println("SInstructor="+resultSet.getString("SInstructor"));
//            System.out.println("SPwd="+resultSet.getString("SPwd"));
//        }
////        6.释放连接
//        resultSet.close();
//        statement.close();
//        connection.close();
//    }
    }
}

