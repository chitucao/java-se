package cn.chitucao.test.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author DennyFly
 * @since 2021/6/7 9:04
 * 太保非机动车险回调消息
 */
@Data
public class NonvehicleMessage implements Serializable {

    /**
     * 投保网点编码
     */
    private String siteCode;

    /**
     * 车架号/电机号
     */
    private String carVinNo;

    /**
     * 保单号
     */
    private String insureNo;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 批单号
     */
    private String endorsementNo;

    /**
     * 投保费用
     */
    private BigDecimal premiums;

    /**
     * 投保金额
     */
    private BigDecimal sumLimit;

    /**
     * 发起投保时间
     */
    private Date submitTime;

    /**
     * 保险生效日期
     */
    private Date validStart;

    /**
     * 保险截止日期
     */
    private Date validEnd;

    /**
     * 替换类型 0：未发生替换 1：替换 2：被替换
     */
    private Integer replaceType;

}
