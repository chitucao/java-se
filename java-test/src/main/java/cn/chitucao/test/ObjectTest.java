package cn.chitucao.test;

import cn.chitucao.test.model.Person;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author DennyFly
 * @since 2021/4/13 17:50
 */
public class ObjectTest {


    @Test
    public void testHashCodeWithGC() {
        Object obj = new Object();
        long address = VM.current().addressOf(obj);
        long hashCode = obj.hashCode();
        System.out.println("before GC : The memory address is " + address);
        System.out.println("before GC : The hash code is " + hashCode);

        new Object();
        new Object();
        new Object();

        System.gc();

        long afterAddress = VM.current().addressOf(obj);
        long afterHashCode = obj.hashCode();
        System.out.println("after GC : The memory address is " + afterAddress);
        System.out.println("after GC : The hash code is " + afterHashCode);
        System.out.println("---------------------");

        System.out.println("memory address = " + (address == afterAddress));
        System.out.println("hash code = " + (hashCode == afterHashCode));
    }

    @Test
    public void testIdentityHashCode() {
        Person person = new Person();
        person.setId(1);

        System.out.println("Hashcode = " + person.hashCode());
        System.out.println("Identity Hashcode = " + System.identityHashCode(person));
    }

    /**
     * 证明是发生了hashCode调用，hashCode才被存储在对象头中
     */
    @Test
    public void testHashCodeStoreInHeader() {
        // 创建对象并打印JVM中对象的信息
        Object person = new Object();
        System.out.println(ClassLayout.parseInstance(person).toPrintable());

        // 调用hashCode方法，如果重写了hashCode方法则调用System#identityHashCode方法
        System.out.println(person.hashCode());

        // System.out.println(System.identityHashCode(person));
        // 再次打印对象JVM中的信息
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
    }

}
