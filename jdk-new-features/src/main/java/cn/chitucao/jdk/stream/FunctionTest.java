package cn.chitucao.jdk.stream;

import cn.chitucao.jdk.entity.Person;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author DennyFly
 * @since 2020/6/4 14:36
 */
public class FunctionTest {

    @Test
    public void supplierPerson() {
        supplierPerson(() -> new Person("tom", 18));
    }

    // supplier
    // 自定义不同的生产行为
    public void supplierPerson(Supplier<Person> personSupplier) {
        System.out.println(personSupplier.get().getName());
    }

    @Test
    public void consumePerson() {
        consumePerson(new Person("tom", 18), Person::tooString);
    }

    // consumer
    // 自定义不同的消费行为
    // 需要传入消费对象
    public void consumePerson(Person person, Consumer<Person> personConsumer) {
        personConsumer.accept(person);
    }


}
