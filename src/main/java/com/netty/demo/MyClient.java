package com.netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.logging.Logger;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/24 10:00
 */
public class MyClient {

    private static final Logger logger = Logger.getLogger(MyClient.class.getName());

    private MyClientHandler clientHandler = new MyClientHandler();

    public void connect(int port,String host) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            System.out.println("client initChannel....");
                            socketChannel.pipeline().addLast(clientHandler);
                        }
                    });
            //发起异步连接
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            logger.info("客户端已连接");
//            clientHandler.sendMessage("这是客户端发送的信息——one...");
//            clientHandler.sendMessage("这是客户端发送的信息——two...");
//            clientHandler.sendMessage("这是客户端发送的信息——three...");
            clientHandler.sendMessage("这是客户端新发送的啊，哈哈哈哈哈");
            //等待客户端链路关闭
            channelFuture.channel().closeFuture().sync();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9303;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (Exception e) {

            }
        }
        new MyClient().connect(port, "127.0.0.1");
    }
}
