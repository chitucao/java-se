package cn.chitucao.java.io.file;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

/**
 * @author DennyFly
 * @since 2020/7/1 15:07
 */
public class FileBasicTest {

    @Test
    public void fileBasic() {
        File file1 = new File("G:\\Temp\\io", "a.txt");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());

        //最近修改时间
        System.out.println(new Date(file1.lastModified()));

        File dir = new File("G:\\Temp\\io");
        File file2 = new File(dir, "a.txt");
    }

    @Test
    public void newFile() throws IOException {
        File file1 = new File("G:\\Temp\\io\\new\\a.avi");
        boolean bl = file1.createNewFile();
        System.out.println(bl);

        //2:创建文件夹,创建单级文件夹
        File file2 = new File("G:\\Temp\\io\\new\\aaa\\bbb\\ccc");
        boolean bl2 = file2.mkdir();
        System.out.println(bl2);

        //3:创建文件夹,创建多级文件夹
        File file3 = new File("G:\\Temp\\io\\new\\aaa\\bbb\\ccc\\a.txt");
        System.out.println(file3.mkdirs());
    }

    @Test
    public void deleteFile() {
        File file1 = new File("G:\\Temp\\io\\new\\a.avi");
        System.out.println(file1.delete());
        File file3 = new File("G:\\Temp\\io\\new\\aaa\\bbb\\ccc\\a.txt");
        System.out.println(file3.delete());
    }

    @Test
    public void attribute() throws IOException {
        //1:判断文件是否存在
        File file1 = new File("a.txt");
        System.out.println(file1.exists());
        if (!file1.exists()) {
            file1.createNewFile();
        }

        //2:判断是否是文件夹和文件
        File file2 = new File("a.txt");
        if (file2.isDirectory()) {
            System.out.println("文件夹");
        }
        if (file2.isFile()) {
            System.out.println("文件");
        }

        //3:判断文件是否隐藏
        File file3 = new File("D:\\lesson\\a.txt");
        System.out.println(file3.isHidden());

        //4:判断一个文件是否能执行
        //Windows系统不分区知否执行,而以后学的Linux系统会严格区分
        File file4 = new File("D:\\lesson\\a.txt");
        System.out.println(file4.canExecute());
    }

    @Test
    public void list() {
        // 1:获取D盘Lesson文件中所有上的文件名
        File file1 = new File("D:\\Lesson");
        String[] array = file1.list();
        for (String fileName : array) { // a.txt
            System.out.println(fileName);
        }

        System.out.println("---------------");

        //2:将一个文件夹所有的文件转为File对象
        //以后看到一个File对象,就认为该File对象代表一个文件,拿到这个File对象就可以获取该文件的一切信息
        //如果路径是一个文件,则返回的数组的是null
        File file2 = new File("D:\\lesson");
        File[] array2 = file2.listFiles();
        for (File file : array2) {
            //判断是否是文件夹
            if (file.isDirectory()) {
                System.out.println(file.getName());
            }
        }
    }

    @Test
    public void fileFilter() {
        File file = new File("D:\\Lesson");
        File[] array = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        for (File file2 : array) {
            System.out.println(file2.getName());
        }
    }

}
