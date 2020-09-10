package cn.chitucao.designpattern.factory.factorymethod;

/**
 * @author DennyFly
 * @since 2020/3/20 10:50
 * PepsiColaFactory定义子类工厂，它继承抽象工厂，实现了对某一产品等级的产品的获得
 */
public class PepsiColaFactory implements ColaFacotry {

    public PepsiCola produce(Class cola) throws IllegalAccessException, InstantiationException {
        if (cola.isInstance(PepsiCola.class.newInstance())) {
            return new PepsiCola();
        }
        return null;
    }
}
