package cn.chitucao.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DennyFly
 * @since 2021/2/19 13:03
 */
public class CalculateTest {

    @Test
    public void testTableTo() {
        String siteIdsStr = "2743";
        List<Long> siteIds = Arrays.stream(siteIdsStr.split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<NumTo> numToList = new ArrayList<>(siteIds.size());
        for (Long siteId : siteIds) {
            // 落表
            long tableNum = (siteId + 1L) % 1024;

            // 落库
            long dataBaseNum = tableNum / 128 + 2L;

            NumTo numTo = new NumTo(siteId, dataBaseNum, tableNum);
            numToList.add(numTo);
        }
        numToList = numToList.stream().sorted(Comparator.comparing(NumTo::getDataBaseNum)).collect(Collectors.toList());
        for (NumTo numTo : numToList) {
            System.out.println("网点id为：" + numTo.getSiteId());
            System.out.println("数据库为：thrall" + numTo.getDataBaseNum());
            System.out.println("表为：zto_account_water_" + numTo.getTableNum());
            System.out.println("SELECT * FROM zto_account_water_" + numTo.getTableNum() + " WHERE site_id = " + numTo.getSiteId() + " AND fee_type IN (1111,1112);");
            System.out.println("SELECT count(1) FROM zto_account_water_" + numTo.getTableNum() +" WHERE site_id = " + numTo.getSiteId() + " AND fee_type IN (1111,1112) GROUP BY account_id;");
            System.out.println("--------------------------------------------");
            System.out.println();
        }
    }

    @Data
    @AllArgsConstructor
    class NumTo {
        private Long siteId;

        private Long dataBaseNum;

        private Long tableNum;
    }

    @Test
    public void testQuery(){

        int dbSize = 3;






//        dbSize--;

        Long value = Long.parseLong("1062095");
        Long tableSize = 4096L;
        Long size = (tableSize - (tableSize / dbSize)) / (dbSize - 1);
        size = tableSize % size == 0 ? size : size + 1;
        Long ds = (value % tableSize) / size;
        // + 1 是为了跳过第一个库
        System.out.println(ds);
    }
}
