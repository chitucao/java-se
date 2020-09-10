package cn.chitucao.designpattern.template.course;

/**
 * Created by Tom.
 */
public class JavaCourse extends NetworkCourse {
    @Override
    void checkHomework() {
        System.out.println("检查Java的架构课件");
    }
}
