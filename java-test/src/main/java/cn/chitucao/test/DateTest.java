package cn.chitucao.test;

import cn.hutool.core.date.*;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.text.Format;
import java.text.SimpleDateFormat;
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

    @Test
    public void testBetweenDay() {
        Date date1 = DateUtil.parse("2021-08-30 08:00:00");
        Date date2 = DateUtil.parse("2021-09-03 09:00:00");

        System.out.println(DateUtil.between(date1, date2, DateUnit.DAY));
        //        long l = DateUtil.offsetDay(date2, -1).getTime() - date1.getTime();
//        System.out.println(l);

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
        long remainDay = DateUtil.between(new Date(), examDay, DateUnit.DAY) - 1L;
        System.out.println("NPEE remain day" + remainDay + "天");
    }

    @Test
    public void testCalendar1() {
        String empEntryMonth = "0";
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        int value = 0;
        if (StrUtil.isNotBlank(empEntryMonth)) {
            value = Integer.valueOf(empEntryMonth);
        }
        c.add(Calendar.MONTH, -value);
        String s = f.format(c.getTime());
        Date date = DateUtil.parse(s, "yyyy-MM-dd");
        System.out.println(date);
    }

    @Test
    public void testYear() {

        // 2021阴历过年已过去
        DateTime leaveDay = DateUtil.parse("2021-02-12");
        long lostDay = DateUtil.between(new Date(), leaveDay, DateUnit.DAY);
        System.out.println("2021年已经过去：" + lostDay + "天");

        // 2022阴历过年
        DateTime yearDay1 = DateUtil.parse("2022-01-31");
        long remainDay1 = DateUtil.between(new Date(), yearDay1, DateUnit.DAY);
        System.out.println("阴历 距离过年还有：" + remainDay1 + "天");

        // NPEE
        DateTime examDay = DateUtil.parse("2021-12-26");
        long npeeDay = DateUtil.between(new Date(), examDay, DateUnit.DAY) - 1L;
        System.out.println("NPEE remain day：" + npeeDay + "天");

        int year = DateUtil.year(new Date());
        System.out.println("当前年是" + year);
    }

    @Test
    public void testYesterday() {
        Date yesterday = DateUtil.yesterday();
        System.out.println(yesterday);
    }

    @Test
    public void test2022() {
        Date now = new Date();
        Date birthDay = DateUtil.parse("1995-04-25");
        Date begin2022 = DateUtil.parse("2022-02-01");
        System.out.println("2022已经过去" + DateUtil.betweenDay(begin2022, now, false) + "天");
        System.out.println("已经活了" + DateUtil.betweenDay(birthDay, now, false) + "天");
    }

    @Test
    public void test11() {
        AbstractClass abstractClass = new ClassImpl();
        System.out.println(abstractClass.getClass());
    }

    @Test
    public void testTimestamp() {
        Date date = new Date();
        System.out.println("time：" + date.getTime());

        System.out.println("sorphkqhnxa".length());

    }

}
