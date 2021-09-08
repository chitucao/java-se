package cn.chitucao.test;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testNpe(){
        List<String> list = new ArrayList<>();
        List<String> list2 = null;
//        list.add("111");
//        list.add("222");
//        list.add("333");

//        Optional.ofNullable(list).orElse(Collections.emptyList()).stream().findFirst();
//
//        java.util.Optional.of(list2).orElse(null);

    }

    @Test
    public void testContains(){
        String siteCode = null;
        System.out.println(Collections.emptyList().contains(siteCode));
    }

    @Test
    public void testJoin(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(StrUtil.format("哈哈哈{}啊啊啊", String.join("、",list)));
    }
}
