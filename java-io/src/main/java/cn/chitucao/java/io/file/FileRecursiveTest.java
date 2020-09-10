package cn.chitucao.java.io.file;

import org.junit.Test;

import java.io.File;

/**
 * @author DennyFly
 * @since 2020/7/1 15:25
 */
public class FileRecursiveTest {

    @Test
    public void listAllFileName() {
        File file = new File("G:\\学习资料\\消息队列高手课-从源码角度全面解析MQ的设计与实现");
        //2:写一个方法,该方法用来实现打印所有文件(递归)
        getFile(file);
    }

    private void getFile(File file) {
        //1:获取该文件夹中所有的File对象,数组
        File[] array = file.listFiles();
        //2:遍历数组,判断file对象时文件还是文件夹
        for (File file2 : array) {
            //2.1 如果是文件,则直接打印
            if (file2.isFile()) {
                System.out.println(file2.getAbsolutePath());
            } else {
                System.out.println("进入了" + file2.getName() + "文件夹");
                //2.2 如果是文件夹,则递归调用自己
                getFile(file2);
                System.out.println("离开了" + file2.getName() + "文件夹");
            }
        }
    }

    @Test
    public void deleteAllFile(){
        //1:创建File类对象
        File file = new File("G:\\Temp\\test\\消息队列高手课-从源码角度全面解析MQ的设计与实现");
        //2:封装方法:删除文件夹
        deleteDir(file);
    }

    private void deleteDir(File file) {
        //1:获取文件夹中所有的File对象:数组
        File[] array = file.listFiles();
        //2:遍历数组,判断每个file是文件还是文件夹
        for (File file2 : array) {
            //2.1 如果是文件,则直接删除
            //2.2 如果是文件夹,则递归调用自己
            if (file2.isFile()) {
                file2.delete();
            } else {
                deleteDir(file2);
            }
        }
        //3:删除文件夹自己
        file.delete();
    }

}
