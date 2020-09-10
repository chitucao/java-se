package cn.chitucao.test;

import java.util.HashSet;

/**
 * @author DennyFly
 * @since 2020/5/6 17:53
 */
public class CollectionTest {
    public static void main(String[] args) {
        HashSet<String> tom = new HashSet<>();
        tom.add("111");
        tom.remove(null);
        System.out.println(tom);
    }
}
