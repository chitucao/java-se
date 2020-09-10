package cn.chitucao.test;

import java.util.Objects;
import java.util.function.Function;

public class FunctionInterfaceTest {
    public static void main(String[] args) {
        System.out.println(transferRow(null, o -> o));

    }

    private static <T, R> Object transferRow(T orginRow, Function<T, R> fun) {
        if (Objects.isNull(orginRow)) {
            return "-";
        } else {
            return fun.apply(orginRow);
        }
    }
}
