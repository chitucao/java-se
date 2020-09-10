package cn.chitucao.guava.event;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Tom on 2019/3/17.
 * 事件监听者
 */
public class GuavaEvent {

    /**
     * @param str 订阅到的消息
     * 这里订阅的是方法级别的
     */
    @Subscribe
    public void subscribe(String str) {
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }

}
