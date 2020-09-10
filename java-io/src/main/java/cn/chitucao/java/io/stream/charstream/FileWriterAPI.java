package cn.chitucao.java.io.stream.charstream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author DennyFly
 * @since 2020/6/28 15:00
 * 字符输出流
 * Writer-->Output
 *
 * <p>
 * 路径问题:
 * 1.绝对路径:从盘符开始写,一直到文件名结束,中间的每个路径都不能省略
 * 2.相对路径:相对于项目的根路径,直接写文件名,相当于前面自动补上项目根路径
 *
 * <p>
 * 关闭和刷新方法的区别
 * 1.flush:将文件内存中的内容刷新到文件中,执行flush后,可以继续向文件中写入内容
 * 2.close:关闭流释放资源,执行close后不能继续写入,否则报异常:Stream closed
 * 执行close方法内部先执行flush
 *
 * <p>
 * 写数据的5个方法
 * 1.void write(String str):将str的内容写入到文件中
 * 2.void write(String str,int index,int len):写一个字符串中的一部分数据, index:开始索引,len:写几个
 * 3.void write(int ch):写一个字符数据,这里写int类型的好处是既可以写char类型的数据，也可以写char对应的int类型的值。'a',9
 * 4.void write(char[] chs):写一个字符数组数据
 * 5.void write(char[] chs,int index,int len):写一个字符数组的一部分数据, index:开始索引,len:写几个
 *
 * <p>
 * 换行问题
 * windows:\r\n
 * linux:\n
 * mac:\r
 * 换行符可以写在第一个数据的结尾,也可以写在第二个数据的开头
 * bw.newLine():写入一个自适应平台的换行符
 *
 * <p>
 * 追加写入问题
 * 1.FileWriter(String fileName, boolean append)
 * 2.FileWriter(String fileName) :不写第二个参数,默认为false,代表覆盖之前的文件
 */
public class FileWriterAPI {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("G:\\Temp\\io\\data.txt");

        // FileWriter fw =  new FileWriter("file01.txt"); //相对路径，当前项目的路径

        fw.write("hello IO"); //将字符串写入内存
        fw.flush(); // 刷新该流的缓冲，把内存缓冲区中的数据刷新到文件中，flush后可以继续写入
        fw.close(); //关闭流,释放资源，close之后不能再次写入（java.io.IOException: Stream closed）
    }
}
