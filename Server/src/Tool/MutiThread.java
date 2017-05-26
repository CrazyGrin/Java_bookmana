package Tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by yunhan on 2017/4/28.
 */
public class MutiThread implements Runnable {

    private Socket server = null;

    public String getDataFromClient() {
        return dataFromClient;
    }

    public void setDataFromClient(String dataFromClient) {
        this.dataFromClient = dataFromClient;
    }

    public Socket getServer() {
        return server;
    }

    public void setServer(Socket server) {
        this.server = server;
    }

    private String dataFromClient;

    public MutiThread(Socket server) {
        this.server = server;
    }

    public void run() {
        try {
            //获取Socket输出流用于返回客户端数据
            PrintStream out = new PrintStream(server.getOutputStream());

            //获取Socket输入流用于接收客户端数据
            BufferedReader buf = new BufferedReader(new InputStreamReader(server.getInputStream()));

            boolean flag = true;

            //轮询接收信息
            while (flag) {

                String msgFromClient = buf.readLine();

                flag = false;
                if (msgFromClient == null || msgFromClient.equals("")) {
                    flag = false;
                } else {
                    System.out.println(msgFromClient);
                    this.setDataFromClient(msgFromClient);

                    //初始化路由
                    Route route = new Route(getDataFromClient().split(";"));

                    String resultData = route.sendRequest_bookModule();

                    out.println(resultData);
                }
            }
            out.close();
            buf.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}