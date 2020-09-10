package cn.chitucao.designpattern.adapter.power;

/**
 * Created by Tom on 2019/3/16.
 * 原方法
 */
public class AC220 {

    public int outputAC220V() {
        int output = 220;
        System.out.println("输出电流" + output + "V");
        return output;
    }
}
