package cn.chitucao.designpattern.singleton.lazy;

/**
 * @author DennyFly
 * @since 2020/3/20 11:50
 * 懒汉式双重检查锁单例
 */
public class LazyDoubleCheckSingleton {

    //单线程下没问题，但是多线程情况下23可能会发生指令重排序，导致A线程设置对象指向内存空间但是还没初始化的时候被B线程访问了
    //这里禁止23步骤的指令重排序
    private static volatile LazyDoubleCheckSingleton singleton;

    private LazyDoubleCheckSingleton() {
    }

    //在对象初始化之后就不会走获取锁来判断初始化对象的逻辑了，保证了性能，但是双重检查有指令重排序的问题
    public static LazyDoubleCheckSingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new LazyDoubleCheckSingleton();
                    //memory = allocate();　　// 1.分配对象的内存空间
                    //ctorInstance(memory);　 // 2.初始化对象
                    //sInstance = memory;　　 // 3.设置sInstance指向刚分配的内存地址
                }
            }
        }
        return singleton;
    }
}
