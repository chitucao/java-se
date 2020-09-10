package cn.chitucao.designpattern.observer.observable;

public class MainTest {
    public static void main(String[] args) {
        Student student = Student.getInstance();

        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");


        //这为没有@Tom老师
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用于哪些场景？");


        student.addObserver(tom);
        student.addObserver(mic);

        //被观察者发布事件
        student.publishQuestion(question);
    }

}
