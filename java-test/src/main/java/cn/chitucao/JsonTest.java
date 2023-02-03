package cn.chitucao;

import cn.chitucao.test.model.NonvehicleMessage;
import cn.hutool.core.net.URLEncodeUtil;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author DennyFly
 * @since 2021/6/7 16:39
 */
public class JsonTest {

    @Test
    public void testGenJson(){
        List<NonvehicleMessage> nonvehicleMessages = new ArrayList<>();

        NonvehicleMessage nonvehicleMessage = new NonvehicleMessage();
        nonvehicleMessage.setSiteCode("53412");
        nonvehicleMessage.setCarVinNo("LFV2A21K6E4003382");
        nonvehicleMessage.setInsureNo("BD2021012500000008");
        nonvehicleMessage.setOrderNo("BJ20210123000000081");
        nonvehicleMessage.setEndorsementNo("");
        nonvehicleMessage.setPremiums(new BigDecimal("240"));
        nonvehicleMessage.setSumLimit(new BigDecimal("300000.0000"));
        nonvehicleMessage.setSubmitTime(new Date());
        nonvehicleMessage.setValidStart(new Date());
        nonvehicleMessage.setValidEnd(new Date());
        nonvehicleMessage.setReplaceType(0);

        nonvehicleMessages.add(nonvehicleMessage);

        System.out.println(JSONUtil.toJsonStr(nonvehicleMessages));
    }

    @Test
    public void testEncode(){
        String name = "/template/劳动合同（甲方是企业，乙方是个人）.docx";
        String templatePath1 = URLEncodeUtil.encode(name);
        System.out.println(templatePath1);

//        try {
////            String encode = URLEncoder.en(name, Charset.defaultCharset());
////            System.out.println(encode);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    /**
     * 八进制转中文
     * @param dataStr 八进制字符
     * @return
     */
    public static String transfromOctalToString(String dataStr) {
        if (! dataStr.contains("\\")) {
            return dataStr;
        }
        //不属于八进制内容的字符
        StringBuilder oldBuffer = new StringBuilder();
        //属于八进制的内容，转成十六进制后缓存在这里
        StringBuilder hexBuffer = new StringBuilder();
        for (int i = 0; i < dataStr.length(); i ++) {
            char c = dataStr.charAt(i);
            if (c != '\\') {
                oldBuffer.append(c);
            }
            //反斜杠往后3个为一组，组成了一个八进制数。例如\20710,其实是207组成了一个八进制数
            else {
                char c1 = dataStr.charAt(i + 1);
                char c2 = dataStr.charAt(i + 2);
                char c3 = dataStr.charAt(i + 3);
                i += 3;
                //将八进制转换为十进制，再转换为十六进制
                String hex = Integer.toHexString((Integer.valueOf("" + c1 + c2 + c3, 8)));
                //先缓存住，直到凑够三个字节
                hexBuffer.append(hex);
                String hexString = hexBuffer.toString();
                //utf8编码中，三个字节为一个汉字
                if (hexString.length() == 6) {
                    //凑够三个字节了，转成汉字后放入oldBuffer中
                    oldBuffer.append(hexStr2Str(hexString));
                    //凑够一个汉字了，清空缓存
                    hexBuffer = new StringBuilder();
                }
            }
        }
        return oldBuffer.toString();
    }
    /**
     * 十六进制转换字符串
     */
    private static String hexStr2Str(String hexStr) {
        String str = "0123456789abcdef";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }

    /**
     * 中文转八进制字符
     * @param s
     * @return
     */
    public static String toOct(String s)
    {
        String result = "";
        byte[] bytes = s.getBytes();
        for (byte b : bytes)
        {
            int b1 = b;
            if (b1 < 0) {
                b1 = 256 + b1;
            }
            result += "\\" + (b1 / 64) % 8 +  "" + (b1 / 8) % 8 + "" + b1 % 8;
        }
        return result;
    }

    /**
     * 八进制字符转中文
     *  只转换并显示属于八进制的字符(\\xxx形式)
     * @param s
     * @return
     */
    public static String getOct(String s) {
        String[] as = s.split("\\\\");
        byte[] arr = new byte[as.length - 1];
        for (int i = 1; i < as.length; i++)
        {
            int sum = 0;
            int base = 64;
            for (char c : as[i].toCharArray())
            {
                sum += base * ((int)c - '0');
                base /= 8;
            }
            if (sum >= 128) {
                sum = sum - 256;
            }
            arr[i - 1] = (byte)sum;
        }
        String getOctStr = null;
        try {
            getOctStr = new String(arr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return getOctStr; //如果还有乱码，这里编码方式你可以修改下，比如试试看unicode gbk等等
    }


    public static void main(String[] args) {
        //weihushijian5xiaoshi
        String s = "\\347\\273\\264\\346\\212\\244\\346\\227\\266\\351\\227\\264" +
                "5\\345\\260\\217\\346\\227\\266";//维护时间5小时
        String s2 = "\\345\\" +
                "277\\253\\351\\200\\222\\347\\275\\221\\347\\202\\271\\347\\211\\207\\345\\214\\272\\346\\211\\277\\" +
                "345\\214\\205\\345\\220\\210\\345\\220\\214\\357\\274\\210\\347\\224\\262\\346\\226\\271\\346\\230\\" +
                "257\\344\\274\\201\\344\\270\\232\\357\\274\\214\\344\\271\\231\\346\\226\\271\\346\\230\\257\\344\\" +
                "274\\201\\344\\270\\232\\357\\274\\211";

        System.out.println("transfromOctalToString(s) = " + transfromOctalToString(s2));//transfromOctalToString(s) = 维护时间5小时
        System.out.println("getOct(s) = " + getOct(s));//getOct(s) = 维护时间小时
        System.out.println("toOct(\"小时\") = " + toOct("小时"));//toOct("维护") = \345\260\217\346\227\266

    }
}
