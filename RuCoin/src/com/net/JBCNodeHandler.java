package com.net;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.udt.UdtMessage;
import io.netty.channel.udt.nio.NioUdtProvider;
/**
 * Handler implementation for the echo peer. It initiates the ping-pong traffic
 * between the echo peers by sending the first message to the other peer on
 * activation.
 */
public class JBCNodeHandler extends SimpleChannelInboundHandler<UdtMessage> {

    public static String greet = "Hello!";
    private int messageSize=0;
    public JBCNodeHandler(int messageSize) {
        super(false);
        this.messageSize=messageSize;
       
      
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
        System.out.println("Initialized JBCNode @"+ctx.channel().localAddress().toString());
        ctx.writeAndFlush(generateText(greet));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, UdtMessage message) {
    	System.out.println("---New Message---");
    	System.out.println("Sender: "+ctx.channel().remoteAddress().toString());
    	System.out.println("Content: "+message.content().toString(StandardCharsets.UTF_8));
    	System.out.println("---End Message---");
        try {
        	Thread.sleep(5000);
        }catch(Exception e) {
        
        }
        System.out.println("Generating random response...");
        UdtMessage response = generateRandomResponse();
        System.out.println("Response content: "+response.content().toString(StandardCharsets.UTF_8));
        ctx.writeAndFlush(response);
        
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    public UdtMessage generateText(String text) {
    	byte[] b = text.getBytes();
    	final ByteBuf byteBuf = Unpooled.buffer(b.length);
        for (int i = 0; i < byteBuf.capacity(); i++) {
            byteBuf.writeByte(b[i]);
        }
        return new UdtMessage(byteBuf);
    }
    public UdtMessage generateRandomResponse() {
    	Random r = new Random(System.currentTimeMillis());
    	byte[] msg = new byte[messageSize];
    	for(int i = 0 ; i<msg.length;i++) {
    		byte b = (byte)(r.nextInt(26)+96);
    		msg[i]=b;
    	}
    	final ByteBuf byteBuf = Unpooled.buffer(msg.length);
        for (int i = 0; i < byteBuf.capacity(); i++) {
            byteBuf.writeByte(msg[i]);
        }
        return new UdtMessage(byteBuf);
    }
}
