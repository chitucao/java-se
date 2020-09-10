package cn.chitucao.designpattern.singleton.threadlocal;

/**
 * @author DennyFly
 * @since 2020/3/20 14:47
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> TL =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return TL.get();
    }
}
