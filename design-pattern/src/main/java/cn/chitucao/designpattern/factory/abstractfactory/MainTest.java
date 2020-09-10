package cn.chitucao.designpattern.factory.abstractfactory;

/**
 * @author DennyFly
 * @since 2020/3/20 11:30
 */
public class MainTest {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        appleFactory.producaComputer().work();
        appleFactory.producePhone().call();

        MiFactory miFactory = new MiFactory();
        miFactory.producaComputer().work();
        miFactory.producePhone().call();
    }
}
