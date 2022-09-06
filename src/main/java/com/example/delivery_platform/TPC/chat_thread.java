package com.example.delivery_platform.TPC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import static com.example.delivery_platform.TPC.Server.chat_create;

public class chat_thread extends Thread{
    private Socket main_socket=null;

    private ArrayList<Socket> connectors=null;

    private String identity;

    chat_thread(Socket socket, ArrayList<Socket> connectors,String identity){
        main_socket=socket;
        this.connectors=connectors;
        this.identity=identity;
    }

    @Override
    public void run() {
        while(true) {
            try {
                //读取客户端传来的信息
                while (true) {
                    DataInputStream in = new DataInputStream(main_socket.getInputStream());
                    String message = in.readUTF();
                    sendMessage(message);
                }
            } catch (IOException e) {
                try {
                    main_socket.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public void sendMessage(String message) throws IOException {
        Iterator<Socket> it = connectors.iterator();
        int num=0;
        try{
            while (it.hasNext()){
                DataOutputStream out = new DataOutputStream(it.next().getOutputStream());
                out.writeUTF(message);
                num++;
            }
        } catch (IOException e) {
            connectors.get(num).close();
            connectors.remove(num);
            sendMessage(identity+"退出群聊");
        }
    }
}
