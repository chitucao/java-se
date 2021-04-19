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
        String siteIdsStr = "57,194,218,1557,1896,2483,2544,2661,2741,2743,3018,3214,3271,3299,3378,3452,3473,3475,3622,3721,3906,3934,4003,4004,4267" +
                ",4270,4587,4721,4781,5532,5667,5708,6421,6852,7529,8109,8325,8375,8820,8862,10503,10848,14246,16450,1022474,1023400,1025561,1045771,1047640,1048151,1053484,1053806,1057092,1064202";
        List<Long> siteIds = Arrays.stream(siteIdsStr.split(",")).map(Long::parseLong).collect(Collectors.toList());
        List<NumTo> numToList = new ArrayList<>(siteIds.size());
        for (Long siteId : siteIds) {
            // 落表
            long tableNum = (siteId + 1L) % 1024L;

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
}
