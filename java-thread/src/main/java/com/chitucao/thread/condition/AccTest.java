package com.chitucao.thread.condition;

import java.math.BigDecimal;
import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * @author DennyFly
 * @since 2020/4/26 19:44
 */
public class AccTest {
    public static void main(String[] args) {


        List<Integer> couponIds = Arrays.asList(30148, 30151);
        List<StoreCouponSettleRateDto> couponSettleRate = new ArrayList<>();
        couponSettleRate.add(new StoreCouponSettleRateDto(30148, new BigDecimal(1)));
        couponSettleRate.add(new StoreCouponSettleRateDto(30151, new BigDecimal(1)));

        Map<Integer, BigDecimal> ucpRateMap = couponSettleRate.stream().collect(toMap(StoreCouponSettleRateDto::getId, e -> Objects.isNull(e.getSettleRate()) ? BigDecimal.ZERO : e.getSettleRate()));
        //忽略结算的预购券、次卡数据
        List<StoreCouponSettleRateDto> ignoredCouponSettleRate = new ArrayList<>();
        ignoredCouponSettleRate.add(new StoreCouponSettleRateDto(29104,new BigDecimal(0.00)));
        ignoredCouponSettleRate.add(new StoreCouponSettleRateDto(29108,new BigDecimal(0.00)));
        ignoredCouponSettleRate.add(new StoreCouponSettleRateDto(29105,new BigDecimal(0.00)));
        ignoredCouponSettleRate.add(new StoreCouponSettleRateDto(29106,new BigDecimal(0.00)));

        if (ignoredCouponSettleRate.size() > 0) {
            for (StoreCouponSettleRateDto storeCouponSettleRateDto : ignoredCouponSettleRate) {
                ucpRateMap.put(storeCouponSettleRateDto.getId(), storeCouponSettleRateDto.getSettleRate());
            }
        }

        System.out.println(111);
    }
}
