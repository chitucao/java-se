package cn.chitucao.shenzhou;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author DennyFly
 * @since 2021/1/18 17:43
 */
public class BillPriceFlow {

    /**
     * 充值时间
     */
    private Date chargeDate;

    /**
     * 交易流水号
     */
    private String tradeNo;

    /**
     * 账户类型
     */
    private String accountType;

    /**
     * 对象
     */
    private String account;

    /**
     * 充值方式
     */
    private String chargeType;

    /**
     * 面单类型和数量
     */
    private String billTypeAndNum;

    /**
     * 金额
     */
    private BigDecimal amount;
}
