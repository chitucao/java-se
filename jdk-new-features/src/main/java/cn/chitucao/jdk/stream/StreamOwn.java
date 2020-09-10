package cn.chitucao.jdk.stream;

import cn.chitucao.jdk.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author DennyFly
 * @since 2020/6/4 11:53
 */
public class StreamOwn {

    private static final String[] strArr = {"美羊羊", "喜洋洋", "懒洋洋", "灰太狼", "红太狼"};

    private static final List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("tom", 18, Arrays.asList("吃饭", "睡觉")));
        persons.add(new Person("jack", 22, Arrays.asList("唱歌", "画画", "拉二胡")));
        persons.add(new Person("mic", 16, Arrays.asList("吹牛", "喝酒")));
    }


    @Test
    public void findFirstTest() {
        String first = Stream.of(strArr).findFirst().get();
        String tom = Stream.of(strArr).findFirst().orElse("tom");
        System.out.println(first + tom);
    }

    @Test
    public void skipLimitTest() {
        Stream<String> stream = Stream.of(strArr);
        Stream<String> stream2 = stream.skip(2).limit(2);
        stream2.forEach(System.out::println);
    }

    @Test
    public void flatMapTest() {
        List<String> allHobbies = persons.stream().flatMap(e -> e.getHobbes().stream()).collect(Collectors.toList());
        allHobbies.forEach(System.out::println);
    }

    @Test
    public void joiningTest() {
        List<String> allHobbies = persons.stream().flatMap(e -> e.getHobbes().stream()).collect(Collectors.toList());
        String hobbiesStrA = String.join(",", allHobbies);
        String hobbiesStrB = allHobbies.stream().collect(Collectors.joining(","));
        System.out.println(hobbiesStrB);
    }

    @Test
    public void testOrElseThrow() throws Exception {
        List<String> allHobbies = persons.stream().flatMap(e -> e.getHobbes().stream()).collect(Collectors.toList());
        String[] stringsA = allHobbies.stream().toArray(String[]::new);
        String[] stringsB = allHobbies.toArray(new String[0]);
        System.out.println(stringsA);
        allHobbies.stream().findFirst().orElseThrow(this::throwA);
    }

    public Exception throwA() {
        return new RuntimeException();
    }

    @Test
    public void anyMatchTest() {
        boolean flag = Stream.of(strArr).anyMatch(e -> "美羊羊".equals(e));
        System.out.println(flag);
    }


}
