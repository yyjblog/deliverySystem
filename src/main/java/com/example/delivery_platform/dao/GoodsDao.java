package com.example.delivery_platform.dao;

import com.example.delivery_platform.databaseutil.Database;
import com.example.delivery_platform.vo.GoodsBean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    private Database db;

    //查询表单
    public List<GoodsBean>  queryGoodsInformation () throws Exception {
        db = new Database();
        db.connect();
        //查询多个数据
        String Sql = "SELECT goods_name, goods_price,goods_description,goods_image FROM `2973288539@qq.com`";
        PreparedStatement psmt = db.getConnection().prepareStatement(Sql);
        //查询结果集,用于获取查询结果中的每一行数据
        ResultSet rs = psmt.executeQuery();
        List<GoodsBean> goodsList = new ArrayList<>();

        while (rs.next()) {
            GoodsBean goods = new GoodsBean();
            goods.setGoodsName(rs.getString("goods_name"));
            goods.setGoodsPrice(rs.getString("goods_price"));
            goods.setGoodsDescription(rs.getString("goods_description"));
            goods.setGoodsImage(rs.getString("goods_image"));
            goodsList.add(goods);
        }
        db.getConnection().close();
        //测试用
        goodsList.forEach(goods->{
            System.out.println(goods.getGoodsName());
        });

        return goodsList;
    }

    public static void main(String[] args) throws Exception {
        GoodsDao goodsDao=new GoodsDao();
        goodsDao.queryGoodsInformation();
    }
}
