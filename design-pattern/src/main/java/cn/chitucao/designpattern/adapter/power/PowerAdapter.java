package cn.chitucao.designpattern.adapter.power;

/**
 * Created by Tom on 2019/3/16.
 * 适配器 静态代理，持有原来对象的引用，在原来的基础上进行增强
 */
public class PowerAdapter implements DC5 {

   private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outoupDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC:" + adapterInput + "V,输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}
