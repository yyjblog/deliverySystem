package com.example.delivery_platform.TPC;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    private int port = 3066;

    private Socket socket=null;

    //建立存储三个种类用户IP的容器，用于筛选用户发送特定指向信息
    protected static ArrayList<Socket> user_list = new ArrayList<>();

    protected static ArrayList<Socket> business_list = new ArrayList<>();

    protected static ArrayList<Socket> rider_list = new ArrayList<>();

    public void Server(int port){
        this.port=port;
    }

    public void getClient(){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                socket=serverSocket.accept();
                System.out.println("收到新请求");
                classify(new DataInputStream(socket.getInputStream()));
                new ServerThread(socket).start();//为连接的客户单独创建一个线程对数据处理
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void classify(DataInputStream in){
        try {
            switch (in.readUTF()){
                case "user":
                    user_list.add(socket);
                    break;
                case "business":
                    business_list.add(socket);
                    break;
                case "rider":
                    rider_list.add(socket);
                    break;
            }
            System.out.println(user_list);
            System.out.println(rider_list);
            System.out.println(business_list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void chat_create(Socket rider_socket){
        new Chatroom(rider_socket,business_list.get(0),user_list.get(0)).start();
    }

    public static void main(String[] args){
        new Server().getClient();//获取客户端的连接
    }
}
