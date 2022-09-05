package com.example.delivery_platform.TPC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Client {
    private DataOutputStream out = null;

    private DataInputStream in = null;

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

    public void connect(String identity){
        try{
            socket = new Socket(host, port);
            //告诉服务端自己是什么身份
            send(identity);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //向服务端发送信息
    public void send(String message){
        try{
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
