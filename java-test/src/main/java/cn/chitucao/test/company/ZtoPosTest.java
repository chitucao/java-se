package cn.chitucao.test.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DennyFly
 * @since 2020/10/20 17:37
 */
public class ZtoPosTest {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < 1001; i++) {
            list.add(i);
        }

        List<List<Object>> lists = splitExcelList(list, 400);
        System.out.println(lists);

    }


    private static List<List<Object>> splitExcelList(List<Object> list, int len) {
        List<List<Object>> excelList = new ArrayList<List<Object>>();
        int size = list.size();
        int count = (size + len - 1) / len;
        for (int i = 0; i < count; i++) {
            List<Object> subList = list.subList(i * len, (Math.min((i + 1) * len, size)));
            excelList.add(subList);
        }
        return excelList;
    }
}
