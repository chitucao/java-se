package cn.chitucao.java.io.stream.bytestream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author DennyFly
 * @since 2020/7/1 14:37
 * 字节输入流  从文件读取到内存
 * 编码
 * <p>
 * GBK  一个英文->1个字节，一个汉字->2个字节
 */
public class FileInputStreamTest {

    @Test
    public void offsetInput() throws IOException {
        // 1:创建FileInputStream对象
        FileInputStream fis = new FileInputStream("a.txt");

        // 2:从文件读取一个字节数组
        byte[] bytes = new byte[1024];
        // 返回值: 表示实际读取的字节个数
        //       如果到达文件的末尾,则返回-1
        int len = fis.read(bytes);
        System.out.println(len); //6个
        System.out.println(new String(bytes, 0, len));
        // 3:关流
        fis.close();
        System.out.println(len);
    }

    @Test
    public void singleInput() throws IOException {
        // 1:创建FileInputStream对象
        FileInputStream fis = new FileInputStream("a.txt");

        // 2:从文件中读取一个字节
        int num1 = fis.read();
        int num2 = fis.read();

        byte[] bytes = {(byte) num1, (byte) num2};
        System.out.println(new String(bytes));

        byte[] bytes2 = {97, 98, 99, 100, 101};
        System.out.println(new String(bytes2));

        // 3:关流
        fis.close();
    }


}
