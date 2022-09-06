package com.example.delivery_platform.TPC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Client {

    private String host = "localhost";

    private int port = 3066;

    private Socket socket = new Socket(host, port);

    public Client() throws IOException {

    }

    //通过构造方法指定其他的连接端口与主机
    public Client(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }

    public void connect(String identity){
        //告诉服务端自己是什么身份
        send(identity,socket);

    }

    //向服务端发送信息
    public static void send(String message,Socket user){
        try{
            DataOutputStream out;
            out = new DataOutputStream(user.getOutputStream());
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket(){
        return socket;
    }
}
