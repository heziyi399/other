package com.hzyexample.other.server;

import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.Callable;

/**
 * @author hzy
 * @date 2021-12-25
 */
//@RestController("nio")
public class NioController implements Runnable {


    @SneakyThrows
    @Override
    public void run() {
        getSelector();
    }
    public void getSelector() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel channel  = ServerSocketChannel.open();//获取通道
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(8004));
        channel.register(selector, SelectionKey.OP_ACCEPT);
    while(selector.select() > 0)
    {
        //
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();//获取当前选择器中所有注册的选择键
        while(it.hasNext())
        {
            SelectionKey sk = it.next();
            if(sk.isAcceptable())
            {
                SocketChannel socketChannel = channel.accept();//如果选择键是accept则获取与客户端的连接
                socketChannel.configureBlocking(false);
                socketChannel.register(selector,SelectionKey.OP_READ);//将该通道也注册到上面的选择器上
            }
            else if(sk.isReadable())
            {
                //获取当前读状态就绪的通道
                SocketChannel socketChannel = (SocketChannel) sk.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int length = 0,len=0;
             try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\heziyi6\\Desktop\\xm\\sguigumybatiscode\\other\\src\\main\\java\\com\\hzyexample\\other\\new.txt")) {
               FileChannel fileChannel =fileOutputStream.getChannel();
                 Charset charset = Charset.forName("UTF-8");

               while((len = socketChannel.read(byteBuffer)) > 0)
               {
                   String   receiveText =charset.newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
                   System.out.println(receiveText);
                   byteBuffer.flip();
                   while(byteBuffer.hasRemaining())
                   {
                       length += fileChannel.write(byteBuffer);
                       byteBuffer.clear();
                       fileOutputStream.flush();
                   }
               }
             }


            }
        }
    }
    }

    public static void main(String[] args) {
        NioController nio =  new NioController();
        Thread t = new Thread((Runnable) nio);
        t.start();
    }
}
