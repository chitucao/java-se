package cn.chitucao.designpattern.factory.simplefactory;

/**
 * @author DennyFly
 * @since 2020/3/20 10:32
 * 具体产品
 */
public class Sprite extends AbstractDrinks {

    @Override
    protected void produce() {
        System.out.println("drink sprite");
    }
}
