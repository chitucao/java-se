package cn.chitucao.designprinciple.simpleresponsibility.simple;

/**
 * Created by Tom on 2020/2/16.
 */
public class Course {
    //错误的
    public  void study(String courseName){
        if("直播课".equals(courseName)){
            System.out.println("不能快进");
        }else{
            System.out.println("可以任意的来回播放");
        }
    }
}
