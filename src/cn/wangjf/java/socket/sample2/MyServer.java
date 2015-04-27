package cn.wangjf.java.socket.sample2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: wangjf
 * Date: 15-1-11
 * Time: 下午7:42
 *
 * 多线程服务端
 *
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);

        try {
        	while (true) {
                Socket socket = server.accept();  //每次接受到新的连接，调用invoke开启一个新的线程
                invoke(socket);
            }
        } finally {
        	server.close();
        }
        
        
    }

    private static void invoke(final Socket client) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                BufferedReader in = null;
                PrintWriter out = null;
                try {
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream());

                    while (true) {
                        String msg = in.readLine();
                        System.out.println(msg);
                        out.println("Server received " + msg);
                        out.flush();
                        if (msg.equals("bye")) {
                            break;
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                        client.close();
                    } catch (Exception e) {
                    	e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
