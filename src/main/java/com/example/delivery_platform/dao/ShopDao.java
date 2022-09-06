package com.example.delivery_platform.dao;

import com.example.delivery_platform.databaseutil.Database;
import com.example.delivery_platform.vo.ShopInformation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ShopDao {
    private Database db;

    //查询表单
    public List<ShopInformation> queryShopInformation () throws Exception {
        db=new Database();
        db.connect();
        //查询多个数据
        String Sql="SELECT shop_name, shop_address,shop_image,shop_ratings FROM shop_info";
        PreparedStatement psmt=db.getConnection().prepareStatement(Sql);
        //查询结果集,用于获取查询结果中的每一行数据
        ResultSet rs= psmt.executeQuery();
        List<ShopInformation> shopList=new ArrayList<>();

        while(rs.next()){
            ShopInformation shop=new ShopInformation();
            shop.setShop_name(rs.getString("shop_name"));
            shop.setShop_address(rs.getString("shop_address"));
            shop.setShop_image(rs.getString("shop_image"));
            shop.setShop_ratings(rs.getString("shop_ratings"));
            shopList.add(shop);
        }
        db.getConnection().close();
        //测试用
        shopList.forEach(shop->{
            System.out.println(shop.getShop_name()+","+shop.getShop_address()+","+shop.getShop_image()+","+shop.getShop_ratings());
        });
        return shopList;
    }

    public void insertShop(String shopName,String shopAddress,String shopImage,String shopRatings,String Useraccount) throws Exception {
        db=new Database();
        db.connect();
        String Sql="insert into shop_info(shop_name,shop_address,shop_image,shop_ratings,shop_account ) values('"+shopName +"','"+shopAddress +"','"+shopImage +"','"+shopRatings +"','"+Useraccount +"')";
        PreparedStatement psmt=db.getConnection().prepareStatement(Sql);
        psmt.executeUpdate();
        db.getConnection().close();
    }

    //测试
    public static void main(String[] args) throws Exception {
        ShopDao shopDao=new ShopDao();
        shopDao.insertShop("","","","","12345678999@qq.com");
//        try {
//            shopDao.queryShopInformation();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }
}
