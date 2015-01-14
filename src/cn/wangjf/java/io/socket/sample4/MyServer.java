package cn.wangjf.java.io.socket.sample4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * User: wangjf
 * Date: 15-1-14
 * Time: 下午5:54
 *
 * 传输压缩对象
 *
 */
public class MyServer {

    private final static Logger logger = Logger.getLogger(MyServer.class.getName());

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);

        while (true) {
            Socket socket = server.accept();
            socket.setSoTimeout(10 * 1000);
            invoke(socket);
        }
    }

    private static void invoke(final Socket socket) throws IOException {
        new Thread(new Runnable() {
            public void run() {

                //使用 GZIP 压缩
                GZIPInputStream gzipis = null;
                ObjectInputStream ois = null;
                GZIPOutputStream gzipos = null;
                ObjectOutputStream oos = null;

                try {
                    gzipis = new GZIPInputStream(socket.getInputStream());
                    ois = new ObjectInputStream(gzipis);
                    gzipos = new GZIPOutputStream(socket.getOutputStream());
                    oos = new ObjectOutputStream(gzipos);

                    Object obj = ois.readObject();
                    User user = (User)obj;
                    System.out.println("user: " + user.getName() + "/" + user.getPassword());

                    user.setName(user.getName() + "_new");
                    user.setPassword(user.getPassword() + "_new");

                    oos.writeObject(user);
                    oos.flush();
                    gzipos.finish(); //完成将压缩数据写入输出流的操作，无需关闭底层流。
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, null, ex);
                } catch(ClassNotFoundException ex) {
                    logger.log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        ois.close();
                    } catch(Exception ex) {}
                    try {
                        oos.close();
                    } catch(Exception ex) {}
                    try {
                        socket.close();
                    } catch(Exception ex) {}
                }
            }
        }).start();
    }
}
