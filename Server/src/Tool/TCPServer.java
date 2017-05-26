package Tool;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yunhan on 2017/4/20.
 */


public class TCPServer {

    ServerSocket server;

    public TCPServer() {
        try {
            server = new ServerSocket(1200);
            Socket client = null;
            boolean flag = true;
            while (flag) {
                //等待客户端的连接，如果没有获取连接
                client = server.accept();
                System.out.println("Accept Connection From Client！");
                //为每个客户端连接开启一个线程
                new Thread(new MutiThread(client)).start();
            }
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TCPServer();
    }
}