package cn.chitucao.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DennyFly
 * @since 2021/9/18 10:24
 */
public class MathTest {

    @Test
    public void testAvg() {

        int[] arr = {};
        int[] arr1 = {1, 2, 3, 4, 5};



        double result = Arrays.stream(arr1).mapToDouble(e -> (double) e).average().orElse(0.00);
        System.out.println("avg："+result);

        double aDouble = new Double("0.0");
        float f =(float)aDouble;

//        Float aFloat = Float.valueOf("0.0");
//        System.out.println("float: "+aFloat);
        System.out.println(f);
    }


    @Test
    public void testDiff(){

        List<Object> list = new ArrayList<>();
        list.add("1233");
        list.add(123);
        list.add("hdaofhdao");
        System.out.println(list);
    }
}
