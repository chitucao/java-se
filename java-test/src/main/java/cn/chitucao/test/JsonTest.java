package cn.chitucao.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author DennyFly
 * @since 2020/4/3 10:56
 */
public class JsonTest {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<String, String>();
        map.put("张三", "14");
        map.put("李四", "15");

        //普通打印
        String s = objectMapper.writeValueAsString(map);
        System.out.println(s);

        //格式化打印
        String s1 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        System.out.println(s1);

    }
}
