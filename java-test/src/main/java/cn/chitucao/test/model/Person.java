package cn.chitucao.test.model;

import lombok.Data;

import java.util.Objects;

/**
 * @author DennyFly
 * @since 2021/4/13 17:55
 */
@Data
public class Person {
    private int id;
    // 省略getter/setter 和equals方法

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
