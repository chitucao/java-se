package cn.chitucao.guava.ratelimiter;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.*;

public class RateLimiterTest {
    private static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(100, 100, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws InterruptedException {
//        test1();
//        test2();
        test3();
    }

    private static void test1() {
        final RateLimiter rateLimiter = RateLimiter.create(4.0);
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(() -> {
                if (rateLimiter.tryAcquire(1, 10, TimeUnit.SECONDS)) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            });
        }
        threadPoolExecutor.shutdown();
    }


    private static void test2() {
        ExecutorService exec = Executors.newCachedThreadPool();
        final RateLimiter rateLimiter = RateLimiter.create(3.0);
        for (int i = 0; i < 20; i++) {
            final int no = i;
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        rateLimiter.tryAcquire(1, 10, TimeUnit.SECONDS);
                        System.out.println("Accessing: " + no + ",time:" + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();
    }


    //(service,Qps) 服务接口的访问速率
    private static final ConcurrentMap<String, Double> serviceMap = Maps.newConcurrentMap();

    //(service+userkey,limiter)
    private static final ConcurrentMap<String, RateLimiter> userServiceMap = Maps.newConcurrentMap();

    static {
        //默认A服务的限制速率 10次/秒
        serviceMap.putIfAbsent("methodA", 10.0);
    }

    /**
     * 修改服务的访问频次
     *
     * @param service
     * @param qps
     */
    public static void updateServiceQps(String service, double qps) {
        serviceMap.put(service, qps);
    }

    /**
     * 删除服务的限制
     *
     * @param service
     */
    public static void removeService(String service) {
        serviceMap.remove(service);
    }

    /**
     * 获取某个用户对于服务的访问速率
     *
     * @param service
     * @param userKey
     * @return
     */
    public static int enter(String service, String userKey) {
        long start = System.currentTimeMillis();
        Double qps = serviceMap.get(service);

        //不限流
        if (qps == null || qps.doubleValue() == 0.0) {
            return 0;
        }

        String keySer = service + userKey;
        RateLimiter rateLimiter = userServiceMap.get(keySer);

        //if null，new limit
        if (Objects.isNull(rateLimiter)) {
            //设置为服务默认的访问频次
            rateLimiter = RateLimiter.create(qps);

            RateLimiter oldRateLimiter = userServiceMap.putIfAbsent(keySer, rateLimiter);
            if (oldRateLimiter != null) {
                rateLimiter = oldRateLimiter;
            }
            rateLimiter.setRate(qps);
        }

        if (!rateLimiter.tryAcquire()) {
            //限速中，提示用户
            System.out.println("use :" + (System.currentTimeMillis() - start) + "ms ; "
                    + service + " visited too frequently by key:" + userKey);
            return 99;
        } else {
            //正常访问
            System.out.println("use :" + (System.currentTimeMillis() - start) + "ms ; ");
            return 0;
        }
    }

    public static void test3() throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            long now = System.currentTimeMillis();
            System.out.println(" begin:" + now + " , dennyfly:" + i);
            int result = enter("methodA", "dennyfly");
            if (result == 99) {
                i = 0;
                Thread.sleep(1000);
            }
        }
    }

    public static void test4() throws InterruptedException {
        int j = 0;
        while (true) {
            j++;
            long now = System.currentTimeMillis();
            System.out.println(" begin:" + now + " , tom:" + j);
            int result = enter("methodB", "tom");
            if (result == 99) {
                j = 0;
                Thread.sleep(1000);
            }
        }
    }

}
