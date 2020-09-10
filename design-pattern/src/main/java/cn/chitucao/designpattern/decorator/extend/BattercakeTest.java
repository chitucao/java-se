package cn.chitucao.designpattern.decorator.extend;


/**
 * @author DennyFly
 * @since 2020/3/20 16:28
 * 继承方式重写父类方法实现装饰者
 */
public class BattercakeTest {
    public static void main(String[] args) {

        Battercake battercake = new Battercake();
        System.out.println(battercake.getMsg() + ",总价格：" + battercake.getPrice());

        Battercake battercakeWithEgg = new BattercakeWithEgg();
        System.out.println(battercakeWithEgg.getMsg() + ",总价格：" + battercakeWithEgg.getPrice());

        Battercake battercakeWithEggAndSausage = new BattercakeWithEggAndSausage();
        System.out.println(battercakeWithEggAndSausage.getMsg() + ",总价格：" + battercakeWithEggAndSausage.getPrice());

    }

}
