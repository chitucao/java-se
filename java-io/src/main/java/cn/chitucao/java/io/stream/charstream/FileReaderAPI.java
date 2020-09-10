package cn.chitucao.java.io.stream.charstream;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author DennyFly
 * @since 2020/6/28 15:12
 */
public class FileReaderAPI {

    public static void main(String[] args) throws IOException {
//        singleRead();
        moreRead();
    }

    private static void singleRead() throws IOException {
        FileReader fr = new FileReader("G:\\Temp\\io\\filereader.txt");
		/*while(true) {
			//读取一个字符
			int ch = fr.read();
			if(ch==-1) {//如果读取到了文件的结束,会返回-1,直接结束循环
				break;
			}
			System.out.println((char)ch);
		}*/
        //以上代码的意思是:遇到结束标记就结束循环,反过来讲,不是结束标记就循环
        int ch = 0;//定有一个临时变量ch用来存储 每次读取到的字符的ASCII码值
        while ((ch = fr.read()) != -1) {//从fr关联的文件中读取一个字符,返回ASCII码值,并赋值给变量ch,最后判断ch是否等于-1,不等于-1,继续循环
            System.out.println((char) ch);
        }
        fr.close();
    }

    private static void moreRead() throws IOException {
        FileReader fr = new FileReader("G:\\Temp\\io\\filereader.txt");
		/*while(true) {
			//读取一个字符
			int ch = fr.read();
			if(ch==-1) {//如果读取到了文件的结束,会返回-1,直接结束循环
				break;
			}
			System.out.println((char)ch);
		}*/
        //以上代码的意思是:遇到结束标记就结束循环,反过来讲,不是结束标记就循环
        char[] chs = new char[3];//用来存储 每次读取到的多个字符
        int len = 0;//用来存储每次读取到的字符的数量
        while ((len = fr.read(chs)) != -1) {//从fr关联的文件中读取一些字符,存入数组chs中,返回读取的字符数量赋值给len
            System.out.println(new String(chs, 0, len));
        }
        fr.close();
    }

}
