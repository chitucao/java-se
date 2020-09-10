package cn.chitucao.designpattern.singleton.hungry;

/**
 * @author DennyFly
 * @since 2020/3/20 11:37
 * 饿汉式初始化单例
 */
public class HungrySingleton {
    private static HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return singleton;
    }
}
