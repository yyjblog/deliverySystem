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
        return shopList;
    }
}
