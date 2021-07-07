package cn.chitucao.test.streamfunction.export;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @param <T> 对象类型
 * @param <F> 对象中该字段的类型
 * @author DennyFly
 * @since 2021/7/6 17:32
 */
public class Dict<T, F> {

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 默认值
     */
    private String defaultValue = "";

    /**
     * k -> 要翻译的字段
     * v -> 翻译后的字段名称
     */
    private Map<F, String> dict = new HashMap<>();

    /**
     * 获取对象字段的方法
     */
    private Function<T, F> func;


    public Dict<T, F> defaultValue(String value) {
        defaultValue = value;
        return this;
    }

    public Dict<T, F> add(F field, String value) {
        add(field, value, false);
        return this;
    }

    public Dict<T, F> add(F field, String value, boolean isDefault) {
        dict.put(field, value);
        if (isDefault) {
            defaultValue = value;
        }
        return this;
    }

    // T: 对象类型
    // F：对象字段类型
    public Dict<T, F> by(Function<T, F> func) {
        this.func = func;
        return this;
    }

    public Function<T, F> getFunc() {
        return func;
    }

    public Dict<T, F> in(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * 克隆一个字典对象，目的是使用同样的字典数据，处理不同对象中的不同字段
     */
    public Dict<T, F> clone(String fieldName, Function<T, F> func) {
        Dict<T, F> dict = new Dict<T, F>();
        dict.dict = this.dict;
        dict.defaultValue = this.defaultValue;
        dict.fieldName = fieldName;
        dict.func = func;
        return dict;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getValue(F field) {
        if (Objects.nonNull(field)) {
            String value = dict.get(field);
            if (Objects.nonNull(value)) {
                return value;
            }
        }
        return defaultValue;
    }

}
