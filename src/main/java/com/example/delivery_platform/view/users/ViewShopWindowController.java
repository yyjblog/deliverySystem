package com.example.delivery_platform.view.users;

import com.example.delivery_platform.dao.ShopDao;
import com.example.delivery_platform.vo.ShopBean;
import com.example.delivery_platform.vo.ShopInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewShopWindowController implements Initializable {

    @FXML
    private TableView<ShopBean> shopTableView;

    private ObservableList<ShopBean> shopData =FXCollections.observableArrayList();
    @FXML
    private TableColumn<ShopBean,String> shopName;
    @FXML
    private TableColumn<ShopBean,String> shopAddress;
    @FXML
    private TableColumn<ShopBean,String> shopImage;
    @FXML
    private TableColumn<ShopBean,String> shopRatings;

    //数据库初始导入到Tableview表格里
    public void initTableView(){
        List<ShopInformation> shopList=new ArrayList<>();
        ShopDao shopDao=new ShopDao();
        try {
            shopList=shopDao.queryShopInformation();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        for(int i=0;i<shopList.size();i++){
            shopData.add(new ShopBean(shopList.get(i).getShop_name(), shopList.get(i).getShop_address(), shopList.get(i).getShop_image(),shopList.get(i).getShop_ratings()));
        }
        //确定数据导入的列
        shopName.setCellValueFactory(
                cellData -> cellData.getValue().shop_nameProperty());
        shopAddress.setCellValueFactory(
                cellData -> cellData.getValue().shop_addressProperty());
        shopImage.setCellValueFactory(
                cellData -> cellData.getValue().shop_imageProperty());
        shopRatings.setCellValueFactory(
                cellData -> cellData.getValue().shop_ratingsProperty());
        //向表中导入数据
        shopTableView.setItems(shopData);
    }
        //跳转窗口函数
    public void orderDishWindow() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("OrderDish.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setTitle("点餐界面");
        stage.setScene(scene);
        stage.show();
    }

    //鼠标点击行事件
    public void initRowEvent(){
        shopTableView.setRowFactory(tv -> {
            TableRow<ShopBean> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    ShopBean shopInfo = row.getItem();
                    try {
                        orderDishWindow();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return row;
        });
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTableView();
        initRowEvent();
    }
}
