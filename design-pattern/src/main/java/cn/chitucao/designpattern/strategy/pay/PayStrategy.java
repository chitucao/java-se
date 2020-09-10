package cn.chitucao.designpattern.strategy.pay;

import cn.chitucao.designpattern.strategy.pay.payport.AliPay;
import cn.chitucao.designpattern.strategy.pay.payport.JDPay;
import cn.chitucao.designpattern.strategy.pay.payport.UnionPay;
import cn.chitucao.designpattern.strategy.pay.payport.WechatPay;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理
 * Created by Tom.
 * 委派模式，存放不同的策略模式
 */
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> payStrategy = new HashMap<String, Payment>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(WECHAT_PAY, new WechatPay());
        payStrategy.put(UNION_PAY, new UnionPay());
        payStrategy.put(JD_PAY, new JDPay());
    }

    /**
     * @param payKey 根据payKey选择不同的支付策略
     * @return
     */
    public static Payment get(String payKey) {
        if (!payStrategy.containsKey(payKey)) {
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }
}
