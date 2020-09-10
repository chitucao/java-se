package cn.chitucao.designpattern.observer.observable;

import java.util.Observable;

/**
 * 学生 被监听对象 发布事件
 */
public class Student extends Observable {

    private String name = "小明同学";

    private static Student student;

    private Student() {
    }

    public static Student getInstance() {
        if (null == student) {
            student = new Student();
        }
        return student;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");

        //表示事件改变 通知观察者
        setChanged();
        notifyObservers(question);
    }
}
