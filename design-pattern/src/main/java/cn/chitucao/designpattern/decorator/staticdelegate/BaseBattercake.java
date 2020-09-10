package cn.chitucao.designpattern.decorator.staticdelegate;

/**
 * Created by Tom on 2019/3/17.
 */
public class BaseBattercake extends Battercake {
    @Override
    protected String getMsg(){
        return "煎饼";
    }

    @Override
    public int getPrice(){
        return 5;
    }
}
