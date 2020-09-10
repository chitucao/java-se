package cn.chitucao.java.io.stream.bytestream;

import org.junit.Test;

import java.io.*;

/**
 * @author DennyFly
 * @since 2020/7/1 16:12
 * 文件拷贝
 */
public class FileCopyTest {

    @Test
    public void testFileCopy() throws Exception {
        // 1:创建源文件的File
        File srcFile = new File("01.mp4");
        // 2:创建目标文件的File
        File destFile = new File("02.mp4");
        // 3:调用方法进行文件的复制
        long t1 = System.currentTimeMillis();

//        singleByteCopyVisual(srcFile, destFile);
//        bufferedSingleByteCopy(srcFile,destFile);
        bufferedBytesCopy(srcFile, destFile);

        long t2 = System.currentTimeMillis();

        System.out.println("复制成功,消耗了:" + (t2 - t1) + "毫秒");
    }

    @Test
    public void testFilesCopy() throws Exception {
        //1:创建源文件夹的File对象
        File srcFile = new File("G:\\学习资料\\消息队列高手课-从源码角度全面解析MQ的设计与实现\\01-课前必读 (2讲)");
        //2:创建目标文件夹的File对象
        File destFile = new File("G:\\Temp\\test\\dest");

        //3:判断目标文件夹是否存在,如果不存在创建
        if (!destFile.exists()) {
            destFile.mkdirs();
        }

        //4:获取源文件中所有的File对象:数组
        File[] array = srcFile.listFiles();
        for (File file : array) {
            //5:遍历数组,遍历一个file则调用copyFile4()进行复制
            //D:\\demo\\刘涛2.jpg   ----> F:\\demo\\刘涛2.jpg
            //destFile :F:\\demo
            File newFile = new File(destFile, file.getName());
            bufferedBytesCopy(file, newFile);
        }
        System.out.println("复制成功!");
    }

    @Test
    public void testDirCopy() throws Exception {
        //1:创建源文件夹的File对象
        File srcFile = new File("G:\\学习资料\\消息队列高手课-从源码角度全面解析MQ的设计与实现");
        //2:创建目标文件夹的File对象
        File destFile = new File("G:\\Temp\\test\\dest\\dir");

        //3:判断目标文件夹是否存在,如果不存在创建
        if(!destFile.exists()){
            destFile.mkdirs();
        }

        dirCopy(srcFile, destFile);
        System.out.println("复制成功");
    }

    public static void dirCopy(File srcFile, File destFile) throws Exception {
        //1:获取源文件夹总所有的 file对象
        File[] array = srcFile.listFiles();
        //2:遍历数组,判断是文件还是文件夹
        for (File file : array) {
            if (file.isFile()) {
                //如果是文件,则直接复制
                bufferedBytesCopy(file, new File(destFile, file.getName()));
            } else {
                //如果是文件夹,则先手动创建该文件夹,在递归调用自己
                //D:\\demo\\新建文件夹   --->F:\\demo\\新建文件夹
                File file2 = new File(destFile, file.getName());
                file2.mkdirs();
                dirCopy(file, file2);
            }
        }
    }

    public static void bufferedBytesCopy(File srcFile, File destFile) throws Exception {
        // 1:创建缓冲流的源文件对象
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream(srcFile));
        // 2:创建缓冲流的目标文件对象
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(destFile));
        // 3:完成文件的复制
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bufis.read(bytes)) != -1) {
            bufos.write(bytes, 0, len);
            bufos.flush();
        }
        // 4:关流
        bufos.close();
        bufis.close();
    }

    public void bufferedSingleByteCopy(File srcFile, File destFile) throws Exception {
        // 1:创建缓冲流的源文件对象
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream(srcFile));
        // 2:创建缓冲流的目标文件对象
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream(destFile));
        // 3:实现文件的复制
        int num = 0;
        while ((num = bufis.read()) != -1) {
            bufos.write(num);
            // 刷新
            bufos.flush();
        }
        // 4:关流
        bufos.close();
        bufis.close();
    }


    public void singleByteCopyVisual(File srcFile, File destFile) throws IOException {
        // 1:创建源文件对象
        FileInputStream fis = new FileInputStream(srcFile);
        // 2:创建目标文件对象
        FileOutputStream fos = new FileOutputStream(destFile);

        // 计算源文件长度
        long srcLen = srcFile.length();

        // 3:实现文件的复制
        int count = 0;
        int num;
        while ((num = fis.read()) != -1) {
            count++;
            double value = (count * 1.0 / srcLen) * 100;

            System.out.println("当前进度:" + (int) value + "%");
            fos.write(num);
        }

        // 4:关流
        fos.close();
        fis.close();
    }


    @Test
    public void singleByteCopyBasic() throws IOException {
        // 1:创建源文件对象
        FileInputStream fis = new FileInputStream("a.txt");
        // 2:创建目标文件对象
        FileOutputStream fos = new FileOutputStream("b.txt");
        // 3:实现文件的复制
        /*
         * while(true){ int num = fis.read(); if(num == -1){ break; }
         * fos.write(num); }
         */
        int num;
        while ((num = fis.read()) != -1) {
            fos.write(num);
        }
        // 4: 关流    先关闭输出流，再关闭输入流
        fos.close();
        fis.close();
    }

}
