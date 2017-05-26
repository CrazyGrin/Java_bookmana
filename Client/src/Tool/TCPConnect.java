package Tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by yunhan on 2017/4/27.
 */
public class TCPConnect {

    Socket tcpConn = null;
    PrintStream sendToServer = null;
    BufferedReader resFromServer = null;

    public TCPConnect() {
        System.out.println("Init TCPClient");
        try {
            tcpConn = new Socket("127.0.0.1", 1200);

            sendToServer = new PrintStream(tcpConn.getOutputStream());
            resFromServer = new BufferedReader(new InputStreamReader(tcpConn.getInputStream()));

            System.out.println("Get Connection .");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            this.sendToServer.println(msg);

            DataPackage.bookResponseToHuman(this.resFromServer.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}