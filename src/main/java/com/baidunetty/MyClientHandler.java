package com.baidunetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.logging.Logger;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/24 9:23
 */
public class MyClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = Logger.getLogger(MyClientHandler.class.getName());

    private ChannelHandlerContext ctx;

    private final ByteBuf firstMsg;

    public MyClientHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        firstMsg = Unpooled.buffer(req.length);
        firstMsg.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //与服务端建立连接
        System.out.println("client channelActive");
        this.ctx = ctx;
        ctx.writeAndFlush(firstMsg);
    }

    public boolean sendMessage(String msg){
        boolean result;
        try {
            byte[] req = msg.getBytes();
            ByteBuf msgBuf = Unpooled.buffer(req.length);
            msgBuf.writeBytes(req);
            ctx.writeAndFlush(msgBuf);
            result = true;
        }catch (Exception e){
            //to  handler exception
            result = false;
            logger.warning(e.getMessage());
        }
        return result;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channel Read....");
        ByteBuf byteBuf = (ByteBuf) msg;
        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String body = new String(req,"UTF-8");
        System.out.println("Now is : " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exception Caught ////");
        //释放资源
        logger.warning("Unexpected exception from downstream : "+cause.getMessage());
        ctx.close();
    }
}
