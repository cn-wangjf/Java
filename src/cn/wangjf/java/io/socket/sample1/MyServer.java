package cn.wangjf.java.io.socket.sample1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: wangjf
 * Date: 15-1-11
 * Time: 下午6:29
 *
 * 简单socket通信 服务端
 *
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);
        Socket socket = server.accept(); //侦听并接受到此套接字的连接。此方法在连接传入之前一直阻塞。
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());

        while (true) {
            String msg = in.readLine();
            System.out.println(msg);
            out.println("Server received " + msg);
            out.flush();
            if (msg.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}
