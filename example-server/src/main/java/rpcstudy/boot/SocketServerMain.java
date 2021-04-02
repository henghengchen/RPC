package rpcstudy.boot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerMain {

    public static Integer listenPort = 8888;

    public static void main(String[] args){
        System.out.println("server start!");
        try {
            ServerSocket serverSocket = new ServerSocket(listenPort);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("connect establish, port = " + socket.getPort());
                //包装流
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                //读取请求数据
                objectInputStream.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
