package cn.chitucao.designpattern.singleton.lazy;

/**
 * @author DennyFly
 * @since 2020/3/20 11:44
 * 懒汉式单例 外部调用的时候进行初始化
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton simpleSingleton;

    private LazySimpleSingleton() {
    }

    //synchronize解决了多线程访问的线程安全问题
    //但是每次获取锁都会阻塞
    public static synchronized LazySimpleSingleton getSingleton() {
        if (simpleSingleton == null) {
            simpleSingleton = new LazySimpleSingleton();
        }
        return simpleSingleton;
    }

}
