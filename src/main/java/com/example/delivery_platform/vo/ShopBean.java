package com.example.delivery_platform.vo;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.StringProperty;

public class ShopBean {

    private  final StringProperty shop_name;
    private final StringProperty shop_address;
    private final StringProperty shop_image;
    private final StringProperty shop_ratings;


public ShopBean(){
    this.shop_name=null;
    this.shop_address=null;
    this.shop_image=null;
    this.shop_ratings=null;

}

public ShopBean(String name, String address, String image, String ratings){
    this.shop_name=new ReadOnlyStringWrapper(name);
    this.shop_address=new ReadOnlyStringWrapper(address);
    this.shop_image=new ReadOnlyStringWrapper(image);
    this.shop_ratings=new ReadOnlyStringWrapper(ratings);
}

    public String getShop_name() {
        return shop_name.get();
    }

    public StringProperty shop_nameProperty() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {

        this.shop_name.set(shop_name);
//        this.shop_name=new ReadOnlyStringWrapper(shop_name);;
    }

    public String getShop_address() {
        return shop_address.get();
    }

    public StringProperty shop_addressProperty() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address.set(shop_address);
    }

    public String getShop_image() {
        return shop_image.get();
    }

    public StringProperty shop_imageProperty() {
        return shop_image;
    }

    public void setShop_image(String shop_image) {
        this.shop_image.set(shop_image);
    }

    public String getShop_ratings() {
        return shop_ratings.get();
    }

    public StringProperty shop_ratingsProperty() {
        return shop_ratings;
    }

    public void setShop_ratings(String shop_ratings) {
        this.shop_ratings.set(shop_ratings);
    }
}
