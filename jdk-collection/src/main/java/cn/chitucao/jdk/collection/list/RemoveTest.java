package cn.chitucao.jdk.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author DennyFly
 * @since 2020/9/17 11:55
 */
public class RemoveTest {


    private static List<String> list = new ArrayList<String>() {{
        add("2");
        add("3");
        add("3");
        add("3");
        add("4");
    }};

    /**
     * 1.普通for删除
     * 因为i是不断递增的，而数组中删除元素后面的元素都会向前移动一位，所以会导致下一个相邻的相同元素无法删除干净
     */
    @Test
    public void testeGeneralFor() {
        for (int i = 0; i < list.size(); i++) {
            if ("3".equals(list.get(i))) {
                list.remove(i);
            }
        }
        printList();
    }

    /**
     * 2.增强for删除
     * 因为expectedModCount和modCount会不一致，会抛出并发修改异常
     */
    @Test
    public void testSuperFor() {
        for (String s : list) {
            if ("3".equals(s)) {
                list.remove(s);
            }
        }
        printList();
    }

    /**
     * 3.迭代器删除
     * 因为expectedModCount和modCount会不一致，会抛出并发修改异常
     */
    @Test
    public void testIterter() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("3".equals(next)) {
                iterator.remove();
            }
        }
        printList();
    }

    private void printList() {
        System.out.println(list);
    }
}
