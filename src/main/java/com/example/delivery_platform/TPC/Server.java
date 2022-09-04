package com.example.delivery_platform.TPC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port = 3066;

    private Socket socket=null;

    public void Server(int port){
        this.port=port;
    }

    public void getClient(){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                socket=serverSocket.accept();
                System.out.println("收到新请求");
                new com.example.delivery_platform.TPC.ServerThread(socket).start();//为连接的客户单独创建一个线程对数据处理
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        new Server().getClient();//获取客户端的连接
    }
}
