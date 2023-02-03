package cn.chitucao.other;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.zto.shenzhou.common.utils.DigestUtils;
//import com.zto.shenzhou.common.utils.HttpUtils;
//import com.zto.titans.common.util.DateUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class CustomerUtils {
//    static Logger logger = LoggerFactory.getLogger(CustomerUtils.class);
    public static final long START = 1000000000L;

    public static final long STEP = 10;

    public static final long ZHONGTIAN = 0;

    public static final long USER = 1;

    public static final long CUSTOMER = 2;

    public static final long ZZT = 3;

    public static long getId(long srcId, long type) {
        return (srcId * STEP + type) + START;
    }

    public static String env = System.getProperty("env");

    /**
     * 根据工号id算出客户id
     *
     * @param userId
     * @return
     */
    public static long getCustomerIdFromUser(long userId) {
        return getId(userId, USER);
    }

    /**
     * 根据中天客户id算出客户id
     *
     * @param userId
     * @return
     */
    public static long getCustomerIdFromZhongtian(long userId) {
        return getId(userId, ZHONGTIAN);
    }

    public static long getCustomerIdFromZzt(Long id) {
        return getId(id, ZZT);
    }

    /**
     * 根据客户id，找到他对应的工号id
     *
     * @param customerId
     * @return
     */
    public static Long getUserId(Long customerId) {
        if (customerId == null)
            return null;
        if (fromUser(customerId))
            return (customerId.longValue() - START) / 10;
        return null;
    }

    /**
     * 判断一个id值，是客户Id
     *
     * @param id
     * @return
     */
    public static boolean isCustomerId(Long id) {
        return id != null && id > START;
    }

    /**
     * 判断一个id值，是用户Id
     *
     * @param id
     * @return
     */
    public static boolean isUserId(Long id) {
        return id != null && id < START;
    }

    /**
     * 判断一个客户id是否是工号过来的
     *
     * @param customerId
     * @return
     */
    public static boolean fromUser(Long customerId) {
        if (customerId == null)
            return false;
        return customerId.longValue() > START && customerId.longValue() % STEP == USER;
    }

//    /**
//     * 面单使用情况
//     * 需要启动参数env
//     *
//     * @param merchantId
//     */
//    public static Integer postElectronicBill(String merchantId) {
//        try {
//            Map<String, Object> map = new HashMap<>();
//            String data = "{\"lastno\": \"\"}";
//            map.put("content", DigestUtils.encryptBASE64(data));
//            map.put("style", "json");
//            map.put("func", "mail.counter");
//            map.put("partner", merchantId);
//            map.put("datetime", DateUtil.formatDateTime(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
//            String url = null;
//            if ("pro".equals(env)) {
//                url = "http://partner.ztosys.com/partner/UserBillCode.php";
//            } else {
//                url = "http://10.9.15.71:86/partner/UserBillCode.php";
//            }
//            String res = HttpUtils.doPost(url, map, 300000, 300000);
//            JSONObject json = JSON.parseObject(res);
//            boolean status = json.getBoolean("result");
//            if (status) {
//                JSONObject counter = json.getJSONObject("counter");
//                int billNum = counter.getIntValue("available");
//                return billNum;
//            } else {
//                //logger.debug("获取运单数量出错{}", "错误码:" + json.getString("code") + "," + "错误信息" + json.getString("remark"));
//            }
//        } catch (Exception e) {
//            logger.error("接口调用异常{}", e);
//        }
//        return null;
//    }
}
