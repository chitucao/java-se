package cn.chitucao.test;

import cn.hutool.core.util.StrUtil;
import org.junit.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

/**
 * @author DennyFly
 * @since 2021/9/7 13:12
 */
public class GenTest {


    @Test
    public void testGenSql(){



        String sql = "INSERT INTO ZTKB.ZTO_NOREAL_NAME_DETAIL\n" +
                "(BILL_CODE, FIRST_SCAN_DATE, FIR_SCAN_SITE_ID, CHECKDATE, FLAG, CREATEDATE)\n" +
                "VALUES('{}', TIMESTAMP '2021-09-07 00:00:00.000000', '6399', TIMESTAMP '2020-07-10 00:00:00.000000', 0, TIMESTAMP '2020-07-10 00:00:00.000000');\n";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6666; i++) {

            String billCode = "testBillCode"+i;
            String format = StrUtil.format(sql, billCode);
            sb.append(format);
        }

        String text = "测试";
        StringSelection selection = new StringSelection(sb.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
    }
}
