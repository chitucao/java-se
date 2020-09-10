package cn.chitucao.designpattern.factory.abstractfactory;

/**
 * @author DennyFly
 * @since 2020/3/20 11:28
 */
public class MiPhone extends Phone {

    @Override
    public void call() {
        System.out.println("Mi Phone call");
    }
}
