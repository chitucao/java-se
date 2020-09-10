package cn.chitucao.java.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author DennyFly
 * @since 2020/7/1 10:14
 */
public class LoadFileTest {

    public static final String FILE_NAME = "aaa.txt";

    /**
     * 获取路径
     *
     * @throws IOException
     */
    @Test
    public void loadAsPath() throws IOException {
        // 根加载器获取，即resource目录   /G:/Personal/JavaSEFly/java-io/target/classes/aaa.txt
        String absolutePath1 = this.getClass().getClassLoader().getResource(FILE_NAME).getPath();
        System.out.println(absolutePath1);
        // 当前类目录获取  /G:/Personal/JavaSEFly/java-io/target/classes/cn/chitucao/java/io/file/aaa.txt
        String absolutePath2 = this.getClass().getResource(FILE_NAME).getFile();
        System.out.println(absolutePath2);

        // 标准接口  G:\Personal\JavaSEFly\java-io\target\classes\aaa.txt
        File file = new File(absolutePath1);
        String canonicalPath = file.getCanonicalPath();
        System.out.println(canonicalPath);

        // 获取所有环境配置信息
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

    /**
     * 读取为流
     *
     * @throws IOException
     */
    @Test
    public void loadAsStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
    }
}
