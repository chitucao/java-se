package cn.chitucao.test;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author dennyfly
 * @since 2021/11/23 17:08
 */
public class SecureTest {

    private static final String SECRET_KEY = "dfly.#666Ac";

    // 86ceeb56689c572bfceda6c88542299fd84259e94a28e375f3f5e53055427b85
    @Test
    public void testAesEncrypt() {

        AES aes = SecureUtil.aes(getSecretKey(SECRET_KEY).getEncoded());
        String text = "2743,02100.13421";
        String encryptBase64 = aes.encryptHex(text);
        System.out.println(encryptBase64.length());
        System.out.println("加密后：" + encryptBase64);


    }

    @Test
    public void testAesDecrypt() {
        AES aes = SecureUtil.aes(SECRET_KEY.getBytes());
        String encryptBase64 = "uSaHpCCwyM7qPz7fY1zbww==";

        String decryptStr = aes.decryptStr(encryptBase64);
        System.out.println("解密后：" + decryptStr);
    }

    /**
     * 生成加密秘钥
     *
     * @return
     */
    private static SecretKeySpec getSecretKey(String password) {
        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //AES 要求密钥长度为 128
        kg.init(128, new SecureRandom(password.getBytes()));
        //生成一个密钥
        SecretKey secretKey = kg.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), "AES");// 转换为AES专用密钥
    }
}
