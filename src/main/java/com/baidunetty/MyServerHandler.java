package com.baidunetty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

import java.util.Date;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/11/23 17:45
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server channel read.....");
        ByteBuf buf = (ByteBuf)msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String body = new String(bytes,"UTF-8");
        System.out.println("this accept message, server receive order : " + body);
        String currentTime = new Date(System.currentTimeMillis()).toString();
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);

//        ctx.write(msg); // (1)
//        ctx.flush(); // (2)  bound   bind

//        try {
//            while (buf.isReadable()){
//                System.out.println((char) buf.readByte());
//                System.out.flush();
//            }
//            System.out.println(buf.toString(io.netty.util.CharsetUtil.US_ASCII));
//            buf.release();
//        }catch (Exception e){
//            buf.release();
//            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channelRead complete....");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("server exception caught....");
        ctx.close();
    }
}
