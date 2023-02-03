package cn.chitucao.test;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author dennyfly
 * @since 2021/12/28 15:58
 */
public class QRCodeTest {

    @Test
    public void testGenQRCode() {
        int width = 200;
        int height = 200;
        String content = "https://qapi-test.zt-express.com/c/scar?salesman=86ceeb56689c572bfceda6c88542299fd84259e94a28e375f3f5e53055427b85";

        QrConfig config = new QrConfig(width, height);
        File logFile=   FileUtil.file("static/image/zto-logo.png");
        //附带logo
        config.setImg(logFile);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 高纠错级别
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(new Color(0, 60, 130));
        // 设置背景色（灰色）
        config.setBackColor(new Color(242, 242, 242));
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\Users\\24695\\Desktop\\ee.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedImage bufferedImage = QrCodeUtil.generate(//
                content, //二维码内容
                config
        );


        try {
            //以JPEG格式向客户端发送
//            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(bufferedImage, "PNG", out);
            out.flush();
            out.close();
            // 转base64
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", stream);
            String base64 = Base64.encode(stream.toByteArray());
            System.out.println(base64);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
