package com.example.delivery_platform.TPC;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

import static com.example.delivery_platform.TPC.Server.*;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
        try{
            //读取客户端传来的信息
            while(true){
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String accept = in.readUTF();

                System.out.println(accept);
            }
        } catch (IOException e) {
            try {
                int if_execute = 0;
                Iterator<Socket> it = user_list.iterator();
                while(it.hasNext()&&if_execute==0){
                    if(it.next() == socket){
                        it.remove();
                        if_execute=1;
                    }
                }
                it = business_list.iterator();
                while(it.hasNext()&&if_execute==0){
                    if(it.next() == socket){
                        it.remove();
                        if_execute=1;
                    }
                }
                it = rider_list.iterator();
                while(it.hasNext()&&if_execute==0){
                    if(it.next() == socket){
                        it.remove();
                        if_execute=1;
                    }
                }
                socket.close();
//                Iterable<String> it = 
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
