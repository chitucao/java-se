package cn.chitucao.java.io.stream.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author DennyFly
 * @since 2020/6/28 15:26
 * 字符输入缓冲流
 * <p>
 * 内部提供了一个长度为8192的数组,提高效率
 * newLine():写入一个自适应平台的换行符
 * <p>
 * (1)直接关闭BufferedWriter流,会一起关闭对应的FileWriter,所以不需要单独关闭FileWriter
 * (2)缓冲区满了会自动刷新,不用手动调用flush操作
 */
public class BufferedWriterAPI {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("G:\\Temp\\io\\data.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("hello IO");
        bw.close();
    }

}
