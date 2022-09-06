package com.example.delivery_platform.vo;

public class GoodsBean {
    private String GoodsName;
    private String GoodsPrice;
    private String GoodsDescription;
    private String GoodsImage;


    public GoodsBean(String goodsName, String goodsPrice, String goodsDescription, String goodsImage) {
        GoodsName = goodsName;
        GoodsPrice = goodsPrice;
        GoodsDescription = goodsDescription;
        GoodsImage = goodsImage;
    }

    public GoodsBean() {

    }

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public String getGoodsDescription() {
        return GoodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        GoodsDescription = goodsDescription;
    }

    public String getGoodsImage() {
        return GoodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        GoodsImage = goodsImage;
    }
}
