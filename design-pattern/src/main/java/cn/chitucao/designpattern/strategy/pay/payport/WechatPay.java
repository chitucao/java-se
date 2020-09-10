package cn.chitucao.designpattern.strategy.pay.payport;

import cn.chitucao.designpattern.strategy.pay.Payment;

/**
 * Created by Tom.
 */
public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }

}
