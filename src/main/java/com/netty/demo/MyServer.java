package com.netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.logging.Logger;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/23 17:58
 */
public class MyServer {
    private static final Logger logger = Logger.getLogger(MyServer.class.getName());

    public void run(int port) throws InterruptedException {
        EventLoopGroup bossLG = new NioEventLoopGroup();
        EventLoopGroup workLG = new NioEventLoopGroup();
        try {
            //配置服务器的NIO线程组
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossLG,workLG)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChildChannelHandler());
//                    .childOption(ChannelOption.SO_KEEPALIVE,true)
            //绑定端口，同步等待成功
            ChannelFuture future = bootstrap.bind(port).sync();
            logger.info("服务器启动成功");
            //等待服务器端监听端口关闭
            future.channel().closeFuture().sync();
        }finally {
            //优雅退出，释放线程
            bossLG.shutdownGracefully();
            workLG.shutdownGracefully();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            System.out.println("server initChannel....");
            socketChannel.pipeline().addLast(new MyServerHandler());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 9303;
        if (args.length > 0 && args != null){
            try {
                port = Integer.valueOf(args[0]);
            }catch (Exception e){
                logger.info(e.getMessage());
            }
        }
        new MyServer().run(port);
    }

}
