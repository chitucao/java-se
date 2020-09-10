package cn.chitucao.designpattern.factory.simplefactory;

/**
 * @author DennyFly
 * @since 2020/3/20 10:36
 * @description Client为应用层，Client端想要获取到Cola或者Sprite对象，只要通过DrinkFactory中的produceDrink方法传入相对应的对应的产品
 */
public class MainTest {
    public static void main(String[] args) {
        DrinksFactory drinksFactory = new DrinksFactory();
        Cola cola = (Cola) drinksFactory.produceDrink(Cola.class);
        cola.produce();
    }
}
