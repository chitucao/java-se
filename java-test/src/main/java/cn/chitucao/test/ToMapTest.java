package cn.chitucao.test;

import cn.chitucao.test.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author DennyFly
 * @since 2021/4/8 14:47
 */
public class ToMapTest {

    private static User user = new User(1, "Tom");
    private static User user1 = new User(2, "Jerry");
    private static User user2 = new User(3, "Rose");
    private static User user3 = new User(3, "Jack");
    private static List<User> list = new ArrayList<User>() {{
        add(user);
        add(user1);
        add(user2);
    }};

    private static List<User> listDuplicateKey = new ArrayList<User>() {{
        add(user);
        add(user1);
        add(user2);
        add(user3);
    }};

    @Test
    public void testUniqueKey() {
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        map.forEach((k, v) -> System.out.println(k + "-->" + v));
    }

    /**
     * toMap默认方法有个参数：throwingMerger()，当key重复值，抛异常：
     * throw new IllegalStateException(String.format("Duplicate key %s", u));
     */
    @Test
    public void testDuplicateKeyThrowException() {
        Map<Integer, String> map = listDuplicateKey.stream().collect(Collectors.toMap(User::getId, User::getName));
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

//    @Test
//    public void testGroupBy() {
//        Map<Integer, List<User>> collect = listDuplicateKey.stream()
//                .collect(Collectors.groupingBy(User::getId));
//        map.forEach((k, v) -> System.out.println(k + "-->" + v));
//    }

    @Test
    public void testDuplicateKey() {
        Map<Integer, String> map = listDuplicateKey.stream()
                .collect(Collectors.toMap(User::getId, User::getName, (oldValue, newValue) -> newValue));
        map.forEach((k, v) -> System.out.println(k + "-->" + v));
    }

    /**
     * Function.identity()获取List里面的泛型属性实体，此方式也是不允许出现重复key
     */
    @Test
    public void testIdentityUniqueKey() {
        Map<Integer, User> map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        map.forEach((k, v) -> System.out.println(k + "-->" + v));
    }

    @Test
    public void testIdentityDuplicateKey() {
        Map<Integer, User> map = listDuplicateKey.stream()
                .collect(Collectors.toMap(User::getId, Function.identity(), (oldValue, newValue) -> newValue));
        map.forEach((k, v) -> System.out.println(k + "-->" + v));
    }

}
