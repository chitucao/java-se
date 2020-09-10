package cn.chitucao.designprinciple.dependencyinversion;

/**
 * Created by Tom on 2020/2/16.
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom正在学习Python课程");
    }
}
