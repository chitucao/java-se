package cn.chitucao.test;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {



    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList();
        list.add("今天");
        list.add("天气");
        list.add("真好啊");
        list.add("啊");
        list.add("！！");
        list.add("！！");
        list.add("！！");
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String object=iterator.next();
            if("啊".equals(object)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
