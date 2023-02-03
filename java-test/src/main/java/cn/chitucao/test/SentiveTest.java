package cn.chitucao.test;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.DesensitizedUtil;
import org.junit.Test;

/**
 * @author dennyfly
 * @since 2021/12/9 13:04
 */
public class SentiveTest {


    @Test
    public void testSentive() {

        // 手机号
        String mobile = "17600532886";
        String handledMobile = DesensitizedUtil.mobilePhone(mobile);
        System.out.println(handledMobile);

        // 身份证
        String idCard = "340881199503265619";
        String handledIdCard = DesensitizedUtil.idCardNum(idCard, 6, 4);
        System.out.println(handledIdCard);

        // 姓名
        String userName = "我是你肚饿";
//        String handledName = DesensitizedUtil.chineseName(userName);
        String handledName = userName.length() <= 3 ? CharSequenceUtil.hide(userName, 1, 2)
                : CharSequenceUtil.hide(userName, 1, userName.length() - 1);

        System.out.println(handledName);

    }


}
