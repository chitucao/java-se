package cn.chitucao.jdk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author DennyFly
 * @since 2020/6/4 12:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String name;

    private int age;

    private List<String> hobbes;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void tooString(Person person){
        System.out.println(person.toString());
    }
}
