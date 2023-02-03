package cn.chitucao.other;

import org.junit.Test;

/**
 * @author DennyFly
 * @since 2021/11/2 9:16
 */
public class Main {

    @Test
    public void testGetCustomerIdByUserId() {
        Long userId = 1013911500L;
        boolean isCustomerId = CustomerUtils.isCustomerId(userId);
        // 是否是客户和计算对应的用户
        System.out.println("是否是客户id：" + isCustomerId);
        if (isCustomerId) {
            System.out.println("对应找到的用户id：" + CustomerUtils.getUserId(userId));
        }

        // 是否是用户和计算对应的客户
        boolean isUserId = CustomerUtils.isUserId(userId);
        System.out.println("是否是用户id：" + isUserId);
        if(isUserId){
            System.out.println("对应找到的客户id："+CustomerUtils.getCustomerIdFromUser(userId));
        }
    }

}
