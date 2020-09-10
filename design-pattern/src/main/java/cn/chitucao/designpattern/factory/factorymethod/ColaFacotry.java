package cn.chitucao.designpattern.factory.factorymethod;

/**
 * @author DennyFly
 * @since 2020/3/20 10:50
 * ColaFacotry定义抽象工厂，指定要生产此类产品的规范（存在的方法与属性），指定工厂方法
 */
public interface ColaFacotry {
    Cola produce(Class<Cola> cola) throws IllegalAccessException, InstantiationException;
}
