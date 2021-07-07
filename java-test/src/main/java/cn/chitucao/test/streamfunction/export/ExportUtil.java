package cn.chitucao.test.streamfunction.export;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class ExportUtil {

    public static class Stream<T> {

        // 要操作的数据
        private List<T> data;

        // 字典对象集合
        private List<Dict> dictList = new ArrayList<>();

        // k -> filedName
        // v -> format
        private Map<String, String> formats = new HashMap<>();

        // T -> 对象类型
        // Map.key -> 字段名称
        // Map.value -> 字段值
        private List<BiConsumer<T, Map<String, Object>>> consumers = new ArrayList<>();


        public Stream(List<T> data) {
            this.data = data;
        }

        public Stream<T> titles(List<Title> titles) {
            if (titles != null && titles.size() > 0) {
                for (Title title : titles) {
                    if (Objects.nonNull(title) && title.getFormat() != null) {
                        String format = title.getFormat();
                        formats.put(title.getFieldName(), format);
                    }
                }
            }
            return this;
        }

        public <F> Stream<T> dict(Dict<T, F> dict) {
            dictList.add(dict);
            return this;
        }

        // 根据业务场景，自定义操作
        public Stream<T> peek(BiConsumer<T, Map<String, Object>> consumer) {
            consumers.add(consumer);
            return this;
        }

        public List<Map<String, Object>> translate() {
            // Map.key   -> 字段名称
            // Map.value -> 字段的值
            List<Map<String, Object>> mapList = new ArrayList<>();

            for (T obj : data) {
                Map<String, Object> map = toMap(obj);

                // 有字典优先按照字典翻译
                if (!dictList.isEmpty()) {
                    for (Dict dict : dictList) {
                        Function func = dict.getFunc();
                        if (func != null) {
                            Object field = func.apply(obj);
                            String value = dict.getValue(field);
                            if (value != null) {
                                map.put(dict.getFieldName(), value);
                            }
                        }
                    }
                }

                // 也可以设置自定义方法翻译
                if (!consumers.isEmpty()) {
                    for (BiConsumer<T, Map<String, Object>> consumer : consumers) {
                        consumer.accept(obj, map);
                    }
                }
                mapList.add(map);
            }

            return mapList;
        }

    }

    public static <T> Stream<T> stream(List<T> data) {
        return new Stream<>(data);
    }

    private static Map<String, Object> toMap(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if ("class".endsWith(propertyDescriptor.getName())) {
                    continue;
                }
                Method getter = propertyDescriptor.getReadMethod();
                if (getter != null) {
                    Object value = getter.invoke(obj);
                    if (value != null) {
                        map.put(propertyDescriptor.getName(), value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
