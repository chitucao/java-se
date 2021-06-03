package cn.chitucao.datastructures.strategy.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author DennyFly
 * @since 2021/4/19 16:39
 * LRU 缓存策略简单实现
 * <p>
 * 主要是利用了linkedhashmap，优先删除队首的元素，插入或者更新元素优先放到队尾
 */
public class LRUCache1 {

    int capacity;

    Map<Integer, Integer> map;


    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // 保证插入到集合的尾部
        Integer value = map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(Integer key, Integer value) {
        // 再次插入保证插入到尾部
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }

        map.put(key, value);

        // 这里考虑到容量满的情况
        if (map.size() > capacity) {
            map.remove(map.keySet().iterator().next());
        }
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(10);
        for (int i = 0; i < 10; i++) {
            lruCache.put(i, i);
            System.out.println(lruCache.map.size());
        }
        System.out.println(lruCache.map);

        lruCache.put(10, 200);
        System.out.println(lruCache.map);
    }
}
