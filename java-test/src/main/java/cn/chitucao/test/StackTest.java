package cn.chitucao.test;

import cn.chitucao.test.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DennyFly
 * @since 2021/9/23 13:32
 */
public class StackTest {

    @Test
    public void testStackYY() {

        User user = new User(1, "tom");
        // 这里存的是右边的引用类型
        Stack<User> stack = new Stack<>();
        stack.push(user);

        // 这里改变引用类型不影响原来的引用
        User jack = new User(2, "jack");
        user = jack;

        user = stack.pop();
        System.out.println(user);

    }

    @Test
    public void testListYY(){
        User user = new User(1, "tom");
        List<User> list = new ArrayList<>();
        list.add(user);

        User jack = new User(2, "jack");
        user = jack;

        user = list.get(0);
        System.out.println(user);
    }
}
