package cn.chitucao.beans;


import cn.chitucao.beans.entity.Student;
import lombok.SneakyThrows;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class IntrospectorDemo {

    @SneakyThrows
    public static void main(String[] args) {
        Student student = new Student("tom", 12,"男");

            BeanInfo beanInfo = Introspector.getBeanInfo(student.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            System.out.println("---");


    }

}
