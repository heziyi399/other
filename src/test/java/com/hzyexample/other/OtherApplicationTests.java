package com.hzyexample.other;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@SpringBootTest
class OtherApplicationTests {

    @Test
    void contextLoads() {

                try {
                    // 1、字节输出流通向目标文件
                    FileOutputStream fos = new FileOutputStream("data01.txt");
                    // 2、得到字节输出流对应的通道Channel
                    FileChannel channel = fos.getChannel();
                    // 3、分配缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("hello,黑马Java程序员！".getBytes());
                    // 4、把缓冲区切换成写出模式
                    buffer.flip();
                    channel.write(buffer);
                    channel.close();
                    System.out.println("写数据到文件中！");
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }


}
