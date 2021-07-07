package cn.chitucao.test.streamfunction.functions;

import java.util.HashMap;
import java.util.Map;

public class BiConsumerTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
