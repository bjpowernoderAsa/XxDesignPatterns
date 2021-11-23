package com.netty.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/23 10:27
 */
public class NIOServer {
    //添加NIO端口
    public static void start(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //notBlocking
        serverSocketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(port);

        serverSocketChannel.bind(address);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //scan,may have bug to some OS;
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()){
                SelectionKey selectionKey = keyIterator.next();
                //accept
                if (selectionKey.isAcceptable()){
                    ServerSocketChannel socketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = socketChannel.accept();
                    System.out.println("Accept !~~~");
                    //must set notBlocking
                    channel.configureBlocking(false);
                    //tricky
                    channel.register(selector,SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    final ByteBuffer byteBuffer = ByteBuffer.allocate(64);

                    final int byteRead = socketChannel.read(byteBuffer);
                    if (byteRead > 0){
                        byteBuffer.flip();
                        int ret = socketChannel.write(byteBuffer);
                        if (ret <= 0){
                            socketChannel.register(selector,SelectionKey.OP_WRITE);
                        }
                        byteBuffer.clear();
                    }else if (byteRead < 0 ){
                        selectionKey.cancel();
                        socketChannel.close();
                        System.out.println("Client close ~ ~!");
                    }
                }
            }
        }
    }

}
