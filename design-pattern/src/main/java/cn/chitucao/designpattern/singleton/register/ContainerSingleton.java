package cn.chitucao.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DennyFly
 * @since 2020/3/20 14:20
 * 类Spring容器注册式单例
 */
public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static final Map<String, Object> IOC = new ConcurrentHashMap<>();

    public static Object getSingleton(String className) {
        synchronized (IOC) {
            if (!IOC.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    IOC.put(className, obj);
                } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return IOC.get(className);
            }
        }
    }

}
