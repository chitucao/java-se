package cn.chitucao.java.io.stream.bytestream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author DennyFly
 * @since 2020/7/1 14:31
 * 字节输出流  从内存或者其它地方输出到文件
 */
public class FileOutputStreamTest {

    @Test
    public void writeOffset() throws IOException {
        //1:创建FileOutputStream类对象
        // 默认写到项目路径下
        FileOutputStream fos = new FileOutputStream("a.txt");
        //2:写文件中写一个字符串:hello --->ell
        fos.write("hello".getBytes(), 1, 3);
        //3:关流
        fos.close();
    }

    @Test
    public void writeAll() throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");
        //2:向文件中写一个字节数组
        byte[] bytes = {97,98,99,100,101};
        byte[] bytes2 = {'h','e','l','l','o'};
        byte[] bytes3 = {'I','a'};
        /*
         * 有没有一个方法可以直接将字符串转为字节数组,有
         *  String类: public byte[] getBytes()
         */
        byte[] bytes4 = "I love China".getBytes();
        fos.write(bytes4);
        //3:关流
        fos.close();
    }

    @Test
    public void writeAppend() throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt",true);
        //2:向文件中写一个字节数组
        fos.write("\r\n".getBytes());
        fos.write("hello".getBytes());
        //3:关流
        fos.close();
    }
}
