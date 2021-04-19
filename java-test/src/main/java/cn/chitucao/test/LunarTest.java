package cn.chitucao.test;

import com.nlf.calendar.Lunar;
import org.junit.Test;

public class LunarTest {

    @Test
    public void solarTest(){
        //今天
        //Lunar date = new Lunar();

        //指定阴历的某一天
        Lunar date = new Lunar(2020,11,13);
        System.out.println(date.toFullString());
//        System.out.println(date.getSolar().toFullString());
    }

}
