package cn.chitucao.test;

import cn.chitucao.test.model.TableTitle;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DennyFly
 * @since 2021/3/8 13:35
 */
public class JsonGenTest {

    @Test
    public void testGenXlsTitles() {
        List<TableTitle> titles = new ArrayList<>();
        titles.add(new TableTitle("createDate","订单创建时间"));
        titles.add(new TableTitle("orderStatusName","订单状态名称"));
        titles.add(new TableTitle("payDate","支付时间"));
        titles.add(new TableTitle("orderId","订单编号"));
        titles.add(new TableTitle("accountType","账户类型"));
        titles.add(new TableTitle("userName","用户名称"));
        titles.add(new TableTitle("userCode","用户工号"));
        titles.add(new TableTitle("chargeType","充值方式"));
        titles.add(new TableTitle("billType","面单类型"));
        titles.add(new TableTitle("num","面单数量"));
        titles.add(new TableTitle("tradeAmount","金额"));
        System.out.println(JSONUtil.toJsonStr(titles));
    }
}
