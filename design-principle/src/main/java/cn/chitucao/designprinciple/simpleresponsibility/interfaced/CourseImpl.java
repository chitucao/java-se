package cn.chitucao.designprinciple.simpleresponsibility.interfaced;

/**
 * Created by Tom on 2020/2/16.
 */
public class CourseImpl implements ICourseInfo,ICourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
