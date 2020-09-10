package cn.chitucao.java.io.stream.bytestream;

import java.io.*;

/**
 * @author DennyFly
 * @since 2020/7/1 16:24
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        // 1:创建BufferedOutputStream对象
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("a.txt"));

        bufos.write("hello".getBytes());
        bufos.flush();

        bufos.close();

        // 2:创建BufferedInputStream对象
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("b.txt"));
    }
}
