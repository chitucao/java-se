package cn.chitucao.other;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

public class RateLimitTest {

    @Test
    public void testLimit() {
        RateLimiter rateLimiter = RateLimiter.create(2);
//        while (true) {
//            if( rateLimiter.tryAcquire(2);){
//
//            }
//
//            System.out.println(System.currentTimeMillis());
//        }
    }
}
