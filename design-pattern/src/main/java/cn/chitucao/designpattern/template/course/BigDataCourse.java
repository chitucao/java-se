package cn.chitucao.designpattern.template.course;


public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    /**
     * 重写钩子方法，实现程序的微调
     */
    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }

    /**
     * 需要实现的自定义方法
     */
    @Override
    void checkHomework() {
        System.out.println("检查大数据的课后作业");
    }
}
