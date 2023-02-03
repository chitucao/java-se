package cn.chitucao.test;

import cn.chitucao.test.model.Student;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

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
    public void testNpe() {
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
    public void testContains() {
        String siteCode = null;
        System.out.println(Collections.emptyList().contains(siteCode));
    }

    @Test
    public void testJoin() {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(StrUtil.format("哈哈哈{}啊啊啊", String.join("、", list)));
    }

    @Test
    public void testToArray() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {

        }

    }


    @Test
    public void testHashTable() {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("tom", 12);
        hashtable.put("jerry", 20);
        Enumeration<Integer> elements = hashtable.elements();
        boolean tom = hashtable.contains(12);

        System.out.println(111);
    }

    @Test
    public void testHashMap() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("tom", 12);
        hashMap.put("jerry", 20);
        boolean tom = hashMap.containsKey(12);

        System.out.println(111);
    }

    @Test
    public void testMemoryLeak() {
//        HashSet<Student> set = new HashSet<>();
//        Student tom = new Student(1, "tom", 12, 1);
//        set.add(tom);
//        tom.setAge(22);
//        System.out.println(set.contains(tom));

        HashMap<Student, Integer> map = new HashMap<>();
        Student jerry = new Student(1, "jerry", 12, 1);
        map.put(jerry, 1);
        System.out.println(map.containsKey(jerry));
        jerry.setAge(22);
        System.out.println(map.containsKey(jerry));
        jerry.setAge(12);
        System.out.println(map.containsKey(jerry));
    }


    @Test
    public void testToArray1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

//        list.toArray(new int[]);
    }

    @Test
    public void testFilter() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.stream().filter(e -> Objects.equals(e, 1)).collect(Collectors.toList());

        System.out.println("111");
    }
}
