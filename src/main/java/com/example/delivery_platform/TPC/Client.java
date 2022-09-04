package com.example.delivery_platform.TPC;

import java.net.Socket;

public class Client {
    private String host = "localhost";
    private int port = 3066;

    private Socket socket = null;

    public Client() {

    }

    //通过构造方法指定其他的连接端口与主机
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }


}
