package cn.chitucao.test;

import cn.hutool.core.util.ReUtil;

/**
 * @author DennyFly
 * @since 2020/8/12 16:06
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

        String content =  "dubbo.metadata-service.urls=[ \"dubbo://172.30.0.47:20880/com.alibaba.cloud.dubbo.service.DubboMetadataService?anyhost=true&application=com-petkit-sms-service&bind.ip=172.30.0.47&bind.port=20880&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&group=com-petkit-sms-service&interface=com.alibaba.cloud.dubbo.service.DubboMetadataService&metadata-type=remote&methods=getAllServiceKeys,getServiceRestMetadata,getExportedURLs,getAllExportedURLs&pid=6&qos.enable=false&release=2.7.6&revision=2.2.1.RELEASE&side=provider&timestamp=1597221111264&version=1.0.0\" ]";
        String regex = "/\timestamp(.+?)\\&version/g";
        System.out.println(ReUtil.getGroup0(regex,content));

    }

}
