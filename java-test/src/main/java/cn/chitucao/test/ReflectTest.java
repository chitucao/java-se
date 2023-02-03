package cn.chitucao.test;

import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectTest {

    class Person {
        private String name;
        private String sex;
        private String address;
        public String school;
        public String zip;
    }

    class Student extends Person {
        private String code;
        private String classmate;
        public String teacher;
        public String desk;
    }

    @Test
    public void testGetField() {
        Person p = new Person();// 实例化一个父类

        Field[] pf1 = p.getClass().getFields();// getFields()方法获取所表示的类或接口的所有可访问公共字段。包括继承过来的可访问公共字段
        show(pf1);
        Field[] pf2 = p.getClass().getDeclaredFields();// getDeclaredFields()方法获取对象所表示的类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
        show(pf2);

        Student s = new Student();// 实例化一个子类

        Field[] pf3 = s.getClass().getFields();// getFields()方法获取所表示的类或接口的所有可访问公共字段。包括继承过来的可访问公共字段
        show(pf3);
        Field[] pf4 = s.getClass().getDeclaredFields();// getDeclaredFields()方法获取对象所表示的类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
        show(pf4);
    }

    public static void show(Field[] fields) {
        for (Field f : fields) {
            System.out.println(f);
        }
        System.out.println("----------------------");
    }

}
