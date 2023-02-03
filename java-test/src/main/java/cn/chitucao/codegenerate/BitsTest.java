package cn.chitucao.codegenerate;

import org.junit.Test;

/**
 * @author chitucao
 * @since 2022/9/6 16:59
 */
public class BitsTest {

    @Test
    public void testMax2To10() {
        long workerLen = 5;

        long sequenceLen = 12;

        // -1原码：  1000 0000 0000 0000 0000 0000 0000 0001
        // -1反码：  1111 1111 1111 1111 1111 1111 1111 1110
        // -1补码：  1111 1111 1111 1111 1111 1111 1111 1111  NN

        // 左移5位： 1000 0000 0000 0000 0000 0000 0010 0000
        // 反码   ： 1111 1111 1111 1111 1111 1111 1101 1111
        // 补码   ： 1111 1111 1111 1111 1111 1111 1110 0000  MM

        // 补码异或：0000 0000 0000 0000 0000 0000 0001 1111

        // 这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数
        long workerMax = -1L ^ (-1L << workerLen); // 31
        System.out.println(workerMax);

        // 补码与
        // 0000 1111 1111 1111
        // 0001 0000 0000 0000
        // 0000 0000 0000 0000
        long sequenceMask = -1L ^ (-1L << sequenceLen);
        long sequence = 4096;
        long sequenceAnd = sequence & sequenceMask; // 0
        System.out.println(sequenceAnd);

        // 可以使用多少年计算
        long year = (-1 ^ (-1L << 41)) / (1000L * 60 * 60 * 24 * 365); // 69
        System.out.println(year);


        // 时间戳的长度
        String maxTimestampSum = String.valueOf(-1 ^ (-1L << 41)); // 2199023255551
        System.out.println(maxTimestampSum);
        System.out.println(maxTimestampSum.length());

    }
}
