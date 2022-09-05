package com.example.delivery_platform.dao;

import com.example.delivery_platform.databaseutil.Database;
import com.example.delivery_platform.vo.UserBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {

    private Database db;
    public String UserAccountResult;
    public String UserPasswordResult;
    public String UserRoledResult;

    public UserDao() throws Exception {
        db = new Database();
        db.connect();
    }

    //增加用户
    public void addUser(String UserAccount,String UserPassword,String UserName,String UserRole,String UserFaceImage)
            throws SQLException {
        String Sql="insert into user_info(user_account,user_password,user_name,user_role,user_faceimage) values('"+UserAccount
                +"','"+UserPassword+"','"+UserName+"','"+UserRole+"','"+UserFaceImage+"')";
        PreparedStatement psmt=db.getConnection().prepareStatement(Sql);
        psmt.executeUpdate();
//      db.getConnection().close();
    }

    //更新数据-----密码
    public void upDataPassword(String UserAccount,String UserPassword) throws SQLException {
        String Sql="UPDATE user_info SET user_password = '"+UserPassword+"' WHERE user_account = '"+UserAccount+"'";
        PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
        psmt.executeUpdate();
//      db.getConnection().close();
    }
    //更新数据-----头像
    public void upDataFaceImage(String UserAccount,String UserFaceImage) throws SQLException {
        String Sql="UPDATE user_info SET user_faceimage = '"+UserFaceImage+"' WHERE user_account = '"+UserAccount+"'";
        PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
        psmt.executeUpdate();
//      db.getConnection().close();
    }
    //   查询数据-----邮箱账号
    public void getUserAccount(String UserAccount) throws SQLException {
        String Sql="SELECT user_account FROM user_info where user_account='"+UserAccount+"'";
//        String Sql="SELECT user_password FROM user_info where user_name='"+userName+"'";
        PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
        //查询结果集,用于获取查询结果中的每一行数据
        ResultSet rs= psmt.executeQuery();
        UserBean role=new UserBean();
        if(rs.next()){//判断查询结果中是否有数据
//            userbean.setUserName(rs.getString("user_name"));
            role.setUserAccount(rs.getString("user_account"));
        }
//        System.out.println(userbean.getUserName());
        UserAccountResult = role.getUserAccount();
        System.out.println(role.getUserAccount());
//      db.getConnection().close();
    }

    //   查询数据-----邮箱密码
    public void getUserPassword(String UserAccount) throws SQLException {
        String Sql="SELECT user_password FROM user_info where user_account='"+UserAccount+"'";
//        String Sql="SELECT user_password FROM user_info where user_name='"+userName+"'";
        PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
        //查询结果集,用于获取查询结果中的每一行数据
        ResultSet rs= psmt.executeQuery();
        UserBean role=new UserBean();
        if(rs.next()){//判断查询结果中是否有数据
//            userbean.setUserName(rs.getString("user_name"));
            role.setUserAccount(rs.getString("user_password"));
        }
//        System.out.println(userbean.getUserName());
        UserPasswordResult = role.getUserAccount();
        System.out.println(role.getUserAccount());
//      db.getConnection().close();
    }

    //获取用户身份
    public void getUserRole(String UserAccount) throws SQLException {
        String Sql="SELECT user_role FROM user_info where user_account='"+UserAccount+"'";
//        String Sql="SELECT user_password FROM user_info where user_name='"+userName+"'";
        PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
        //查询结果集,用于获取查询结果中的每一行数据
        ResultSet rs= psmt.executeQuery();
        UserBean role=new UserBean();
        if(rs.next()){//判断查询结果中是否有数据
//            userbean.setUserName(rs.getString("user_name"));
            role.setUserRole(rs.getString("user_role"));
        }
//        System.out.println(userbean.getUserName());
        UserRoledResult = role.getUserRole();
        System.out.println(role.getUserRole());
//      db.getConnection().close();
    }


//   //查询表单
//   public void getUser(String userName) throws SQLException {
//      String Sql="SELECT user_password FROM user_info where user_name='"+userName+"'";
////        String Sql="SELECT user_password FROM user_info where user_name='"+userName+"'";
//      PreparedStatement  psmt=db.getConnection().prepareStatement(Sql);
//      //查询结果集,用于获取查询结果中的每一行数据
//      ResultSet rs= psmt.executeQuery();
//      userBean  userbean=new userBean();
//      if(rs.next()){//判断查询结果中是否有数据
////            userbean.setUserName(rs.getString("user_name"));
//         userbean.setUserPassword(rs.getString("user_password"));
//      }
////        System.out.println(userbean.getUserName());
//      System.out.println(userbean.getUserPassword());
//      db.getConnection().close();
//   }
/*
   public static void main(String[] args) {
      try {
         UserDao userDao = new UserDao();
         userDao.getUserAccount("93490258@qq.com");
         System.out.println(userDao.UserAccountResult+"....");
         System.out.println(userDao.UserAccountResult == null);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }*/
}
