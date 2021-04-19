package cn.chitucao.jdk.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author DennyFly
 * @since 2020/9/17 17:31
 * 1.可以看到，map 初始化的时候，我们放进去四个元素，但结果只有三个元素，10 不见了，这个主要是因为我们覆写了 removeEldestEntry 方法，
 * 我们实现了如果 map 中元素个数大于 3 时，我们就把队头的元素删除，当 put(1, 1) 执行的时候，正好把队头的 10 删除，
 * 这个体现了达到我们设定的删除策略时，会自动的删除头节点。
 * <p>
 * 2.当我们调用 map.get(9) 方法时，元素 9 移动到队尾，调用 map.get(20) 方法时， 元素 20 被移动到队尾，
 * 这个体现了经常被访问的节点会被移动到队尾。
 */
@Slf4j
public class LinkedHashMapLRUTest {


    @Test
    public void testAccessOrder() {
        // 新建 LinkedHashMap
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(4, 0.75f, true) {
            {
                put(10, 10);
                put(9, 9);
                put(20, 20);
                put(1, 1);
            }

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 3;
            }
        };

        System.out.println(com.alibaba.fastjson.JSON.toJSONString(map));

        Assert.assertNotNull(map.get(9));
        System.out.println(com.alibaba.fastjson.JSON.toJSONString(map));

        Assert.assertNotNull(map.get(20));
        System.out.println(com.alibaba.fastjson.JSON.toJSONString(map));

    }
}
