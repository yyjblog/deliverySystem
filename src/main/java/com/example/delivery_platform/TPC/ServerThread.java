package com.example.delivery_platform.view.TPC;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
        try{
            //读取客户端传来的信息
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String accept = in.readUTF();
            System.out.println(accept);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
