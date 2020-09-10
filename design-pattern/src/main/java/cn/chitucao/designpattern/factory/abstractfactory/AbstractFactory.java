package cn.chitucao.designpattern.factory.abstractfactory;

/**
 * @author DennyFly
 * @since 2020/3/20 11:21
 * 抽象工厂 实现类是产品族，实现类中的方法是产品等级
 */
public interface AbstractFactory {

    public Phone producePhone();

    public Computer producaComputer();
}
