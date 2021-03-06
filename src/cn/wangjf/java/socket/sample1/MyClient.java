package cn.wangjf.java.socket.sample1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: wangjf
 * Date: 15-1-11
 * Time: 下午6:30
 *
 * 简单socket通信 客户端
 *
 */
public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 10000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = reader.readLine();
            System.out.println("client input: " + msg);
            out.println(msg);
            out.flush();
            if (msg.equals("bye")) {
                break;
            }
            System.out.println(in.readLine());  //会阻塞
        }
        socket.close();
    }
}
