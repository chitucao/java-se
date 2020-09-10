package cn.chitucao.java.io.stream.conversionstream;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author DennyFly
 * @since 2020/7/1 19:06
 */
public class InputStreamReaderTest {

    @Test
    public void readDecode() throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        char[] chs = new char[1024];
        int len = isr.read(chs);
        System.out.println(new String(chs, 0, len));
    }
}
