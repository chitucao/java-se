package cn.chitucao.java.io.path;

import java.io.IOException;
import java.nio.file.*;

/**
 * @author DennyFly
 * @since 2020/11/26 9:17
 * https://blog.csdn.net/qq_36761831/article/details/90547522
 */
public class PathBasicTest {

    public static void main(String[] args) throws IOException {
        // 当前项目的绝对路径
        FileSystem aDefault = FileSystems.getDefault();
        // 获取当前项目某个目录下的某个文件
        Path path = aDefault.getPath("leetcode", "pom.xml");

        Path path1 = Paths.get("d:\\nio", "hello.txt");
        Path path2 = Paths.get("atguigu.txt");

//		Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
        //要想复制成功，要求path1对应的物理上的文件存在。path1对应的文件没有要求。
//		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);

//		Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
        //要想执行成功，要求path对应的物理上的文件目录不存在。一旦存在，抛出异常。
        Path path3 = Paths.get("d:\\nio\\nio1");
//		Files.createDirectory(path3);

//		Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
        //要想执行成功，要求path对应的物理上的文件不存在。一旦存在，抛出异常。
        Path path4 = Paths.get("d:\\nio\\hi.txt");
//		Files.createFile(path4);

//		void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
//		Files.delete(path4);

//		void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除.如果不存在，正常执行结束
        Files.deleteIfExists(path3);

//		Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
        //要想执行成功，src对应的物理上的文件需要存在，dest对应的文件没有要求。
//		Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);

//		long size(Path path) : 返回 path 指定文件的大小
        long size = Files.size(path2);
        System.out.println(size);




        System.out.println("断点处");
    }

}
