package cn.chitucao.test;

import cn.hutool.core.util.NumberUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NumberTest {

    public static final long START = 1000000000L;

    public static final long STEP = 10;

    public static final long ZHONGTIAN = 0;

    @Test
    public void testMax(){
        BigDecimal num1 = null;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal num3 = new BigDecimal(-1);
        BigDecimal num4 = null;
        BigDecimal num5 = null;

        BigDecimal max = NumberUtil.max(num1, num2, num3, num4, num5);
        System.out.println(max);

    }


    @Test
    public void genId() {
        Long id = 1128091020L;

        Long originId = (id - START - ZHONGTIAN) / STEP;
        System.out.println("原CustomerId：" + originId);
    }


    public static void main(String[] args) {
//        testFormat();
//       testFloatProblem();
//       testBigDecimalProblem();
        System.out.println(2 >> 1);
    }


    public static void testFormat() {
        BigDecimal num = new BigDecimal("0");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println(df.format(num));
    }


    /**
     * add(BigDecimal)       BigDecimal对象中的值相加，然后返回这个对象。
     * subtract(BigDecimal)  BigDecimal对象中的值相减，然后返回这个对象。
     * multiply(BigDecimal)  BigDecimal对象中的值相乘，然后返回这个对象。
     * divide(BigDecimal)    BigDecimal对象中的值相除，然后返回这个对象。
     * toString()            将BigDecimal对象的数值转换成字符串。
     * doubleValue()         将BigDecimal对象中的值以双精度数返回。
     * floatValue()          将BigDecimal对象中的值以单精度数返回。
     * longValue()           将BigDecimal对象中的值以长整数返回。
     * intValue()            将BigDecimal对象中的值以整数返回。
     */
    public static void testBigDecimalProblem() {
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(a.add(b));
        System.out.println(c.add(d));
    }

    /**
     * Java中float的精度为6-7位有效数字。double的精度为15-16位。
     */
    public static void testFloatProblem() {
        System.out.println(0.05 + 0.01);
        System.out.println(1.0 - 0.42);
        System.out.println(4.015 * 100);
        System.out.println(123.3 / 100);
    }

    @Test
    public  void testDivide(){
        BigDecimal multiply = (new BigDecimal(52).multiply(new BigDecimal(100)).divide(new BigDecimal(90), 2, BigDecimal.ROUND_UP));
        System.out.println(multiply);
    }

}
