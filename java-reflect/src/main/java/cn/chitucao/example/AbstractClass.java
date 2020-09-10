package cn.chitucao.socket;

/**
 * @author DennyFly
 * @since 2020/4/20 15:38
 */
public abstract class AbstractClass implements Messager {

    public String send(String msg) {
        String convertMsg = convertMessage(msg);
        return doSend(convertMsg);
    }

    protected String convertMessage(String msg) {
        return null;
    }


    protected abstract String doSend(String convertMsg);
}
