package com.netty.io;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/23 11:01
 */
public class BIOServer {
    public static void start(int port) throws IOException {
        //socket
        ServerSocket serverSocket = new ServerSocket();
        //blocking,bind,
        serverSocket.bind(new InetSocketAddress(port),2);
        while (true){
            final Socket clientSocket = serverSocket.accept();
            System.out.println("begin accept !~");
            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                    String line = reader.readLine();
                    while (line != null){
                        out.println(line);
                        out.flush();
                        //blocking
                        line = reader.readLine();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    try {
                        clientSocket.close();
                    }catch (IOException e2){
                        e2.printStackTrace();
                    }
                }
            }).start();
        }
    }


}
