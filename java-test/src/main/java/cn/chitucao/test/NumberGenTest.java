package cn.chitucao.test;

import org.junit.Test;

/**
 * @author DennyFly
 * @since 2021/4/9 16:59
 */
public class NumberGenTest {


    @Test
    public void testGenByDate(){
        long l = System.currentTimeMillis();

        System.out.println(l);
        System.out.println(String.valueOf(l).length());
    }
}
