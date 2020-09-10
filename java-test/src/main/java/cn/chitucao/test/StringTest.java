package cn.chitucao.test;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

/**
 * @author DennyFly
 * @since 2020/3/11 14:57
 */
public class StringTest {
    public static void main(String[] args) {
        String s ="hello";
//        s = "world"; //内存地址已经修改 原来地址上的值还是不变的，只是失去了引用等待垃圾回收
        String s2 = "hello"; //从常量池中找到并引用
        String s4 = new String("hello"); //new产生一个新的对象 不会从常量池中引用
        String s6 = "hel" + "lo";
        String s7 = new String("hel") + new String("lo");
        System.out.println(s == s2); //引用相等     Java把字符串常量存入字符串常量池，优先从常量池查引用
        System.out.println(s2 == s4); //引用不相等       new的对象不会从常量池查引用
        System.out.println(s2.equals(s4)); //值相等    分析equals方法源码,比较的是hash值
        System.out.println(s2 == s6); //引用相等    使用相常量相加 也是从常量池中找到引用
        System.out.println(s2 == s7); //引用不相等


        String a = "a"+"b"+1;
        String b = "ab1";
        System.out.println(a == b); //引用相等，常亮是从常量池中找引用
    }


    @Test
    public void testUpperFirst(){
        String str = "哈哈哈";
        System.out.println(StrUtil.upperFirst(str));
    }
}

