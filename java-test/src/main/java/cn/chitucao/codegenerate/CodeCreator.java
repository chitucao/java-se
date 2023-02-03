package cn.chitucao.codegenerate;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 预付款流水号生成逻辑
 * <p>
 * 单号20位，前缀2位的话，再去掉时间戳10位，workerId5位，还剩下3位留给生成序列，所以单台机器一秒钟最多支持1000的单号生成，就我们这破业务，绝对够用了，害；
 * 因为是基于时间戳的，所以会有时钟回拨的问题，这里对于时钟回拨没有作特殊处理；
 */
public class CodeCreator {

    public static final String PREFIX_REGEX = "[A-z]{1,3}";
    private static long workerId = 0;

    static {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }

        // [10, 1, 54, -63]
        byte[] ipAddressByteArray = address.getAddress();
        int i1 = ipAddressByteArray[1];
        int i2 = ipAddressByteArray[2];
        int i3 = ipAddressByteArray[3];

        // byte只能表示 -128~127，如果有负数出现，需要加上256，例如193用byte表示为 -(256-193) = -63
        i1 = i1 < 0 ? 256 + i1 : i1;
        i2 = i2 < 0 ? 256 + i2 : i2;
        i3 = i3 < 0 ? 256 + i3 : i3;

        // workerId = (long) ((((i1 << Byte.SIZE) + i2) << Byte.SIZE) + i3);

        // 根据ip地址生成唯一的workerId，通过移位相加，保证唯一性，这里只利用了ip地址的后两位（0~2^16）
        workerId = (long) ((i2 << Byte.SIZE) + i3); // 54 * 256 + 193 =  14017
    }

    private static ReentrantLock instanceLock = new ReentrantLock();
    private static Map<String, CodeCreator> instances = new HashMap<>();

    private String prefix;
    private ReentrantLock lock = new ReentrantLock();
    private int number = 0;
    private int maxNumber = 10;
    private long lastTime = 0;

    /**
     * @param prefix 编码前缀;1-3个字符
     * @return
     */
    public static CodeCreator getInstance(String prefix) {
        return getInstance(prefix, 20);
    }

    /**
     * @param prefix 编码前缀;1-3个字符
     * @param len    编码总长度，最少20
     * @return
     */
    public static CodeCreator getInstance(String prefix, int len) {
        if (prefix == null || !prefix.matches(PREFIX_REGEX))
            throw new IllegalArgumentException("prefix must be 1 - 3 character");
        if (len - prefix.length() < 16 || len - prefix.length() > 25) {
            throw new IllegalArgumentException("length except prefix must between 16 and 25!");
        }

        // 双重检查锁+注册登记式单例，每种前缀对应一个生成器
        String key = prefix + len;
        if (!instances.containsKey(key)) {
            instanceLock.lock();
            try {
                if (!instances.containsKey(key)) {
                    instances.put(key, new CodeCreator(prefix, len));
                }
            } finally {
                instanceLock.unlock();
            }
        }
        return instances.get(key);
    }

    private CodeCreator(String prefix, int len) {
        this.prefix = prefix;
        len = len - 10 - 5 - this.prefix.length();  // 20 - 15 - 2 = 3  20位的单号，去掉时间10位、ip地址5位、前缀2位、还剩下3位，这三位用于存储1秒中的不同
        while (len-- > 1) {
            maxNumber = maxNumber * 10;     // maxNumber表示同1秒中能够生成的最大单号数，超过了就要等待进入下一秒
        }
    }

    public String next() {
        NextNumber nextNumber = getNextNumber();
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(nextNumber.time);  // PS + 1662448035

        // 这里加上1000同时subString一下应该是保证剩下的是5位，workerId的范围是【0】~【65535】，只要保证最小值也要达到5位就可以了
        sb.append(String.valueOf(100000 + workerId).substring(1));  // PS + 1662448035 + /1/(100000 + 14017) = PS 1662448035 14017
//        sb.append(prefix).append(nextNumber.time * 100000 + workerId);

        // 这里主要是下面要配合截取一位，至少要达到10，不过判断有点多余，maxNumber肯定是不小于10的
        if (maxNumber >= 10) {
            // 这里加上maxNumber配合下面的subString也是为了达到maxNumber.lengh-1的位数，例如index = 9应该是009而不是9
            long index = maxNumber + nextNumber.index;  // 1000 + 9 = 1009 在1000到1999之间
            if (index >= 10)
                sb.append(String.valueOf(index).substring(1));  // PS + 1662448035 + /1/(100000 + 14017) = /1/1009 = PS 1662448035 14017 009
        }
        return sb.toString();
    }

    public long nextNumber() {
        NextNumber nextNumber = getNextNumber();
        if (nextNumber.time * 10000 + workerId > (Long.MAX_VALUE / maxNumber))
            throw new IllegalArgumentException("BIZ_UTIL" + "根据你的设定，结果大于Long类型的上限，无法返回结果");
        return (nextNumber.time * 10000 + workerId) * maxNumber + nextNumber.index;
    }

    private NextNumber getNextNumber() {
        lock.lock();    // 因为是单例，就需要考虑多线程并发问题，这里用了可重入锁
        try {
            long time = System.currentTimeMillis() / 1000;  // 秒级
            if (lastTime != time) {     // 如果不是同一秒进来的，时间不同能够保证唯一，记录一下lastTime
                lastTime = time;
                number = 0;
            } else {
                // 同一秒进来number++，根据number保证唯一
                // 如果一秒钟超过了maxNumber，剩下的位数(这里是3)就用完了，就需要自旋等待一下，进入下一秒，同时将number置零
                if (++number >= maxNumber) {
                    while (true) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e) {

                        }
                        time = System.currentTimeMillis() / 1000;
                        if (lastTime != time) {
                            lastTime = time;
                            number = 0;
                            break;
                        }
                    }
                }
            }
            NextNumber nextNumber = new NextNumber();
            nextNumber.time = time; // 秒 1662448035  10位
            nextNumber.index = number;
            return nextNumber;
        } finally {
            lock.unlock();
        }
    }

    class NextNumber {
        long time;
        long index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String ps = CodeCreator.getInstance("PS").next();
            System.out.println(ps);
        }

    }

}
