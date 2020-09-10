package cn.chitucao.designpattern.strategy.pay.payport;

import cn.chitucao.designpattern.strategy.pay.Payment;

/**
 * Created by Tom.
 */
public class UnionPay extends Payment {

    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }

}
