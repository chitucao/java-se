package cn.chitucao.designpattern.singleton.hungry;

/**
 * @author DennyFly
 * @since 2020/3/20 11:41
 * 饿汉式静态块单例
 */
public class HungryStaticSingleton {
    private static HungryStaticSingleton singleton;

    static {
        singleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    public static HungryStaticSingleton getInstance() {
        return singleton;
    }
}
