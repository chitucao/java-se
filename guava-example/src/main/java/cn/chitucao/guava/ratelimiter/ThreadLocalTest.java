package cn.chitucao.guava.ratelimiter;

public class ThreadLocalTest {

    public static ThreadLocal<String> value = new ThreadLocal<>();

    public static void main(String[] args) {

    }

    public void test1(){
        value.set("主线程设置的值123");
        String v = value.get();

    }


}
