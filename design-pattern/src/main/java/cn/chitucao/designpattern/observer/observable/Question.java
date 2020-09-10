package cn.chitucao.designpattern.observer.observable;

/**
 * Created by Tom on 2019/3/17.
 * 事件
 */
public class Question {

    private String userName;
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
