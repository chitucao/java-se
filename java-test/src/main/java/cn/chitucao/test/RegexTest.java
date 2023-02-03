package cn.chitucao.test;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DennyFly
 * @since 2020/8/12 16:06
 * <p>
 * 参考资料
 * <p>
 * 史上最全常用正则表达式大全 https://www.cnblogs.com/hsinfo/p/13584432.html
 * 正则表达式(Java版整理)  https://www.cnblogs.com/yw0219/p/8047938.html
 */
public class RegexTest {

    public static void main(String[] args) {
//        //要匹配的字符
//        String str = "13656231253";
//        //正则表达式
//
//        String regex = "1[2378][0-35-9]{9}";
//
//        //将给定的正则表达式编译为模式。 如果匹配需求较多，且需用同相同的regex去匹配，就可将这句写到静态模块里面，用的时候直接使用实例p
//        Pattern p = Pattern.compile(regex);
//
//        //创建一个匹配器，匹配给定的输入与此模式。
//        Matcher m = p.matcher(str);
//
//        //尝试将整个区域与模式进行匹配。
//        boolean flag = m.matches();
//
//        //输出匹配结果，此次结果为true
//        System.out.println(flag);

        String content = "dubbo.metadata-service.urls=[ \"dubbo://172.30.0.47:20880/com.alibaba.cloud.dubbo.service.DubboMetadataService?anyhost=true&application=com-petkit-sms-service&bind.ip=172.30.0.47&bind.port=20880&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&group=com-petkit-sms-service&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&metadata-type=remote&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=6&qos.enable=false&release=2.7.6&revision=2.2.1.RELEASE&side=provider&timestamp=1597221111264&version=1.0.0\" ]";
        String regex = "/\timestamp(.+?)\\&version/g";
        System.out.println(ReUtil.getGroup0(regex, content));

    }


    @Test
    public void testAllNum() {
        // 全数字
        String allNum = "^[0-9]*$";

        String text = "1234";
        System.out.println(ReUtil.isMatch(allNum, text));
    }

    @Test
    public void testEnOrNum() {
        // 由数字和26个英文字母组成的字符串
        String enOrNum = "^[A-Za-z0-9]+$";

        String text = "1234abwAZ";
        System.out.println(ReUtil.isMatch(enOrNum, text));
    }

    @Test
    public void testLen() {
        String reg = "^.{3,20}$";
        String text = "重托";
        System.out.println(ReUtil.isMatch(reg, text));
    }

    @Test
    public void testMultiLen() {
        // 3位，6位，9位或F开头+7位
        String multiDiff = "^.{3}|.{6}|.{9}|[F].{7}$";
        String text = "1234567";
        String text2 = "F1234567";
        System.out.println(ReUtil.isMatch(multiDiff, text2));
    }

    @Test
    public void testWithSub() {
        String text = "abcdefg";
        String first2 = StrUtil.subWithLength(text, 10, 2);
        System.out.println(StrUtil.isEmpty(first2));

        System.out.println(first2);
    }

    @Test
    public void testBlankStr() {
        String text = "";
        String reg = "^[\\s]|[0-9]*$";
        System.out.println(ReUtil.isMatch(reg, text));
    }

    @Test
    public void testAnd() {
        String text = "";
        String reg = "^[\\s]|[0-9]*|[X]$";
        System.out.println(ReUtil.isMatch(reg, text));
    }

    @Test
    public void testGe() {
        String text = "a我是中国人ba";
        String reg = "^[u4e00-u9fa5aa-zA-Z]{5,}$";
        System.out.println(ReUtil.isMatch(reg, text));
    }

    @Test
    public void testHz() {
        String text = "1我是1啊哈哈";
        String reg = "^.*?[\\u4e00-\\u9fa5].*?[\\u4e00-\\u9fa5].*$";

        boolean b = Arrays.stream(text.split("")).filter(e -> ReUtil.isMatch("^[\\u4e00-\\u9fa5]$", e)).count() >= 5;
        System.out.println(b);


//        for (char c : text.toCharArray()) {
//            System.out.println(String.valueOf(c));
//            System.out.println(ReUtil.isMatch("^[\\u4e00-\\u9fa5]$", String.valueOf(c)));
//        }


//        System.out.println(ReUtil.isMatch(reg, text));
    }


    @Test
    public void testValidateMobile() {

        String mobile = "176005328861";
        String reg = "^(?:0|86|\\+86)?1[3-9]\\d{9}$";
        System.out.println(ReUtil.isMatch(reg, mobile));
    }

    @Test
    public void testValidateIdCard() {
        String idCard = "340881199503265619";
        String reg = "^[1-9]\\d{5}[1-2]\\d{3}((0\\d)|(1[0-2]))(([012]\\d)|3[0-1])\\d{3}(\\d|X|x)$";
        System.out.println(ReUtil.isMatch(reg, idCard));
    }


    @Test
    public void testValidate() {
        // 营业执照号
        String licencesNo = "FA1234561234ABCDX1";
        System.out.println(licencesNo.length());
        Assert.isTrue(ReUtil.isMatch("^[a-zA-Z0-9]+$", licencesNo), "营业执照号只能输入数字和字母");
        Assert.isTrue(ReUtil.isMatch("^.{7}|.{13}|.{15}|.{18}|[F]\\d{7}$", licencesNo), "营业执照号只能是7/13/15/18位或F开头加7位数字");
        Assert.isTrue(ReUtil.isMatch("^[A-Z0-9]+$", StrUtil.subWithLength(licencesNo, 0, 2)), "第1~2位只能为数字或者大写字母");
        Assert.isTrue(ReUtil.isMatch("^\\s*|\\d*$", StrUtil.subWithLength(licencesNo, 2, 6)), " 第3~8位只能为数字");
        Assert.isTrue(ReUtil.isMatch("^\\s*|[A-Z0-9]+$", StrUtil.subWithLength(licencesNo, 8, 8)), " 第9~16位只能为数字或者大写字母");
        Assert.isTrue(ReUtil.isMatch("^\\s*|[0-9]*|[X]$", StrUtil.subWithLength(licencesNo, 16, 1)), "第17位只能为数字或者‘X’");

        // 公司地址
        String address = "123456789a这是要给号";
        Assert.isTrue(ReUtil.isMatch("^.{9,50}$", address), "公司地址最少为9位，最多为50位");
        Assert.isTrue(ReUtil.isMatch("^(.*?)\\d+(.*?)$", address) && !ReUtil.isMatch("^\\d*$", address), "公司地址至少有1位数字；且不能为纯数字");
        Assert.isTrue(Arrays.stream(address.split("")).filter(e -> ReUtil.isMatch("^[\\u4e00-\\u9fa5]$", e)).count() >= 5, "公司地址不能少于5个汉字");

        // 联系电话
        String tel = "18600532881";
        Assert.isTrue(ReUtil.isMatch("^\\d{11}$", tel) && !tel.startsWith("086"), "联系电话要求是11位纯数字；前三位不能为086");


        // 手机号校验

    }

}
