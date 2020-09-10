package cn.chitucao.designpattern.factory.abstractfactory;

/**
 * @author DennyFly
 * @since 2020/3/20 11:26
 * 工厂的具体实现，产品族2
 */
public class MiFactory implements AbstractFactory {
    public Phone producePhone() {
        return new MiPhone();
    }

    public Computer producaComputer() {
        return new MiComputer();
    }
}
