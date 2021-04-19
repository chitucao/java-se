package cn.chitucao.jdk.collection;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author DennyFly
 * @since 2020/9/17 16:29
 */
public class ComparableTest {
    @Data
            // DTO 为我们排序的对象
    class DTO implements Comparable<DTO> {
        private Integer id;

        public DTO(Integer id) {
            this.id = id;
        }

        @Override
        public int compareTo(DTO o) {
            //默认从小到大排序
            return id - o.getId();
        }
    }

    @Test
    public void testTwoComparable() {
        // 第一种排序，从小到大排序，实现 Comparable 的 compareTo 方法进行排序
        List<DTO> list = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            list.add(new DTO(i));
        }
        Collections.sort(list);
        System.out.println(JSON.toJSONString(list));

        // 第二种排序，从大到小排序，利用外部排序器 Comparator 进行排序
        Comparator<DTO> comparator = (Comparator<DTO>) (o1, o2) -> o2.getId() - o1.getId();
        List<DTO> list2 = new ArrayList<>();
        for (int i = 5; i > 0; i--) {
            list2.add(new DTO(i));
        }
        Collections.sort(list, comparator);
        System.out.println(JSON.toJSONString(list2));
    }
}

