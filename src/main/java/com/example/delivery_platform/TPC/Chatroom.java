package com.example.delivery_platform.TPC;

import java.net.Socket;
import java.util.ArrayList;

public class Chatroom extends Thread{
    private ArrayList<Socket> sockets = new ArrayList<>();

    Chatroom(Socket Rider, Socket Business, Socket User){
        sockets.add(Rider);
        sockets.add(Business);
        sockets.add(User);
    }

    @Override
    public void run() {
        new chat_thread(sockets.get(0),sockets,"骑手").start();
        new chat_thread(sockets.get(1),sockets,"卖家").start();
        new chat_thread(sockets.get(2),sockets,"买家").start();
    }
}
