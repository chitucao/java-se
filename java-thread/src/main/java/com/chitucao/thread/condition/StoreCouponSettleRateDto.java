package com.chitucao.thread.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreCouponSettleRateDto implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private BigDecimal settleRate;

}
