package cn.chitucao.designpattern.decorator.extend;

/**
* @author DennyFly
* @since 2020/3/20 16:28
 * 继承方式
*/
public class BattercakeWithEgg extends Battercake{
    @Override
    protected String getMsg() {
        return super.getMsg() + "+1个鸡蛋";
    }

    @Override
    //加一个鸡蛋加1块钱
    public int getPrice() {
        return super.getPrice() + 1;
    }
}
