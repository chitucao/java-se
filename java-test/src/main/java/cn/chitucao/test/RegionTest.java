package cn.chitucao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegionTest {

    /**
     * 获取小括号里面区域经理的名字
     */
    private static final Pattern AREA_MANAGER_NAME = Pattern.compile("(?<=\\（)(\\S+)(?=\\）)");

    public static void main(String[] args) {
        String source = "区域经收付费电视理（李玲珑）";
        if (!source.contains("区域经理")) {
            System.out.println("没有找到");
            return;
        }
        Matcher matcher = AREA_MANAGER_NAME.matcher(source);
        while (matcher.find()) {
            String managerName = matcher.group();
            System.out.println(managerName);
        }
    }
}
