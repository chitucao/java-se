package cn.chitucao.designpattern.factory.abstractfactory;

/**
 * @author DennyFly
 * @since 2020/3/20 11:25
 * 工厂的具体实现，产品族1
 */
public class AppleFactory implements AbstractFactory {
    public Phone producePhone() {
        return new Iphone();
    }

    public Computer producaComputer() {
        return new Mac();
    }
}
