package cn.chitucao.java.io.stream.conversionstream;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author DennyFly
 * @since 2020/7/1 18:46
 * 转换流  用于将字节流转换成字符流
 * 作用:
 * 1:调用方法时,实现流的转换
 * 2:解决文件编码问题(乱码问题)
 */
public class OutputStreamWriterTest {

    @Test
    public void writeBasic() throws IOException {
        FileOutputStream fos = new FileOutputStream("osw.txt");
        // 注意转换流相对路径是对于当前最外面的目录
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("xxxxx");
        osw.flush();
        osw.close();
    }

    @Test
    public void writeEncode() throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("oswcode.txt"), StandardCharsets.UTF_8);
        osw.write("中国");
        osw.flush();
        osw.close();
    }

}
