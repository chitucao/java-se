package cn.chitucao.datastructures.strategy.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author DennyFly
 * @since 2021/4/19 17:06
 */
public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private Integer capacity;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
