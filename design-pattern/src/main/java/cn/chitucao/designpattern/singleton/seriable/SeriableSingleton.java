package cn.chitucao.designpattern.singleton.seriable;

import java.io.Serializable;

/**
 * @author DennyFly
 * @since 2020/3/20 14:32
 * 防止单例模式被反序列化破坏，重写readResolve方法
 * 序列化：将内存中的数据状态转换成字节码流，写入其它地方（磁盘、网络IO），内存中的状态被永久保存了下来
 * 反序列化：读取IO流，转换成对象重新写入内存
 */
public class SeriableSingleton implements Serializable {

    public final static SeriableSingleton INSTANCE = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance() {
        return INSTANCE;
    }

//    private Object readResolve() {
//        return INSTANCE;
//    }
}
