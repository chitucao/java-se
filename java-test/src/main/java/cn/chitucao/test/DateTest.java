package cn.chitucao.test;

import cn.hutool.core.date.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
//        //获取今天10点的时间
//        Date todayTime = DateUtil.offsetHour(DateUtil.beginOfDay(new Date()), 10);
//        //获取昨天10点的时间
//        Date yesterdayTime = DateUtil.offsetDay(todayTime, -1);
//        System.out.println(todayTime);
//        System.out.println(yesterdayTime);
//        testObserv();
//        testTody();
//        testMonth();
        testyesterday();
//        testYes();
//        testSheetName();
//        testCalendar();
//        testDateFormat();
    }

    static void testyesterday() {
        //昨天开始时间
        Date notifyStartTime = DateUtil.offsetDay(DateUtil.beginOfDay(new Date()), -1);
        //昨天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testObserv() {
        //昨天开始时间
        Date notifyStartTime = DateUtil.offsetDay(DateUtil.beginOfDay(new Date()), -1);
        //昨天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testMonth() {
        //一个月过期后当天开始时间
        Date notifyStartTime = DateUtil.offsetMonth(DateUtil.beginOfDay(new Date()), 1);
        //一个月过期后当天结束时间
        Date notifyEndTime = DateUtil.endOfDay(notifyStartTime);
        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }


    static void testTody() {
        //今天开始时间
        Date notifyStartTime = DateUtil.beginOfDay(new Date());
        //明天开始时间
        Date notifyEndTime = DateUtil.offsetDay(notifyStartTime, 1);

        System.out.println(notifyStartTime);
        System.out.println(notifyEndTime);
    }

    static void testYes() {
        Date todayStart = DateUtil.beginOfDay(new Date());  //今天开始时间
        Date yesEnd = DateUtil.offsetMillisecond(todayStart, -1);  //昨天结束时间
        System.out.println(todayStart);
        System.out.println(yesEnd);

        System.out.println(DateUtil.format(todayStart, DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(yesEnd, DatePattern.NORM_DATETIME_PATTERN));

        Date start = DateUtil.offsetMonth(new Date(), -6);
        System.out.println(start);
    }

    static void currentYear() {
        Date date = DateUtil.beginOfYear(new Date());
        System.out.println(date);
    }

    public static void testSheetName() {
//        String name = DateUtil.format(new Date(), DatePattern.CHINESE_DATE_FORMAT) + " 结算明细表";
        String wbName = DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN)
                + "-" + DateUtil.format(new Date(), DatePattern.PURE_DATE_PATTERN) + " 结算明细表";
        System.out.println(wbName);
    }


    private static void testCalendar() {
        Date end = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, -2);
        Date start = calendar.getTime();
        System.out.println(DateUtil.format(start, DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end, DatePattern.NORM_DATETIME_PATTERN));

        //处理时间
        calendar.setTime(start);
        //获取当月第一天
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        start = calendar.getTime();
        //获取当月最后一天
        calendar.setTime(end);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        end = calendar.getTime();

        System.out.println(DateUtil.format(start, DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end, DatePattern.NORM_DATETIME_PATTERN));

        end = DateUtil.endOfMonth(new Date());
        start = DateUtil.beginOfMonth(DateUtil.offsetMonth(end, -2));

        System.out.println(DateUtil.format(start, DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.format(end, DatePattern.NORM_DATETIME_PATTERN));
    }

    private static void testDateFormat() {
        String nowStr = DateUtil.format(new Date(), "yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(nowStr);
    }

    @Test
    public void testRunPetkit() {
        DateTime runDay = DateUtil.parse("2020-09-25");
        long between = DateUtil.between(new Date(), runDay, DateUnit.DAY);
        System.out.println("距离【petkit】跑路的 " + between + " 天");
    }

    @Test
    public void testRunZto() {
        DateTime runDay = DateUtil.parse("2022-11-04");
        long between = DateUtil.between(new Date(), runDay, DateUnit.DAY);
        System.out.println("距离【zto】跑路的 " + between + " 天");
    }

    @Test
    public void testBetweenMonth() {
        DateTime start = DateUtil.parse("2020-03-25");
        DateTime after3Month = DateUtil.offsetMonth(start, 3);
        System.out.println(after3Month);
        DateTime end = DateUtil.parse("2020-06-26");
        System.out.println(end.after(after3Month));
    }

    @Test
    public void testLeaveShenzhou() {
        // 2020-10-15  借调到电商研发部

        DateTime leaveDay = DateUtil.parse("2020-10-14");
        long between = DateUtil.between(leaveDay, new Date(), DateUnit.DAY);
        System.out.println("离开产品二部的 " + between + " 天");
        System.out.println("来到电商研发部的 " + between + " 天");
    }

    @Test
    public void testNewYear() {
        DateTime newYear = DateUtil.parse("2021-02-11");
        long between = DateUtil.between(newYear, new Date(), DateUnit.DAY);
        System.out.println("还有 " + between + " 天过年了");
    }

    @Test
    public void testGirlFriend() {
        DateTime birthday = DateUtil.parse("1995-04-25");
        long between = DateUtil.between(birthday, new Date(), DateUnit.DAY);
        System.out.println("母胎单身" + between + " 天了");
    }

    @Test
    public void testFriends() {
        DateTime gz = DateUtil.parse("2021-03-16");
        DateTime tt = DateUtil.parse("2021-04-11");

        long gzGo = DateUtil.between(gz, new Date(), DateUnit.DAY);
        System.out.println("狗贼跑路的 " + gzGo + " 天了");

        long ttGo = DateUtil.between(tt, new Date(), DateUnit.DAY);
        System.out.println("田嘟嘟跑路的 " + ttGo + " 天了");
    }

    @Test
    public void testWork() {
        DateTime zz = DateUtil.parse("2021-04-10");

        long zzH = DateUtil.between(zz, new Date(), DateUnit.DAY);
        System.out.println("中通转正后的 " + zzH + " 天了");
    }


    @Test
    public void testOffset() {
        DateTime offset = DateUtil.offset(new Date(), DateField.YEAR, -1);
        System.out.println("一年前的某一天" + DateUtil.format(offset, DatePattern.NORM_DATETIME_PATTERN));
    }

    @Test
    public void testBetweenSeconds() {
        long betweenSeconds = DateUtil.between(new Date(), DateUtil.endOfDay(new Date()), DateUnit.SECOND);
        System.out.println("距离今天结束还剩：" + betweenSeconds + "秒");
    }

    @Test
    public void testNpee() {
        DateTime examDay = DateUtil.parse("2021-12-26");
        long remainDay= DateUtil.between(new Date(),examDay,DateUnit.DAY)-1L;
        System.out.println("NPEE remain day" + remainDay + "天");
    }
}
