package cn.chitucao;

import cn.chitucao.test.model.NonvehicleMessage;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author DennyFly
 * @since 2021/6/7 16:39
 */
public class JsonTest {

    @Test
    public void testGenJson(){
        List<NonvehicleMessage> nonvehicleMessages = new ArrayList<>();

        NonvehicleMessage nonvehicleMessage = new NonvehicleMessage();
        nonvehicleMessage.setSiteCode("53412");
        nonvehicleMessage.setCarVinNo("LFV2A21K6E4003382");
        nonvehicleMessage.setInsureNo("BD2021012500000008");
        nonvehicleMessage.setOrderNo("BJ20210123000000081");
        nonvehicleMessage.setEndorsementNo("");
        nonvehicleMessage.setPremiums(new BigDecimal("240"));
        nonvehicleMessage.setSumLimit(new BigDecimal("300000.0000"));
        nonvehicleMessage.setSubmitTime(new Date());
        nonvehicleMessage.setValidStart(new Date());
        nonvehicleMessage.setValidEnd(new Date());
        nonvehicleMessage.setReplaceType(0);

        nonvehicleMessages.add(nonvehicleMessage);

        System.out.println(JSONUtil.toJsonStr(nonvehicleMessages));
    }
}
