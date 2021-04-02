package rpcstudy.boot;

import java.io.*;
import java.net.Socket;

public class SocketClientMain {

    public static Integer sendPort = 8888;

    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1", sendPort);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            //发送数据
            objectOutputStream.writeObject(null);
            objectOutputStream.flush();
            //读取数据
            objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
