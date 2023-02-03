package com.chitucao.thread.completablefeature;

import org.junit.Test;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author DennyFly
 * @since 2021/3/18 13:43
 */
public class CompletableFeatureDemo {

    // 其他方法
    // CompletableFuture.allOf(userCountCf).join();  多个异步任务合并

    @Test
    public void runAsync() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end ...");
        });
        try {
            System.out.println(future.get());  // null
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void supplyAsync() {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();  // 提供返回值
        });
        long time = 0;
        try {
            time = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("time =" + time);
    }

    @Test
    public void whenComplete() {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (new Random().nextInt() % 2 == 0) {
                int i = 12 / 0;
            }
            System.out.println("run end ...");
            return System.currentTimeMillis();
        });

        future.whenComplete((r, t) -> {
            System.out.println("time =" + r);
            System.out.println("执行完成");
        });

        future.exceptionally(e -> {
            System.out.println("执行失败！" + e.getMessage());
            return null;
        });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenApply() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            System.out.println("result1 =" + result);
            return result;
        }).thenApply(e -> {
            int result = e * 5;
            System.out.println("result2 =" + result);
            return result;
        });
        long result = 0;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Test
    public void handle() {
        CompletableFuture<? extends Serializable> future = CompletableFuture.supplyAsync(() -> {
            int r = new Random().nextInt(100);
            if (r % 2 == 0) {
                int i = 12 / 0;
            }
            return r;
        }).handle((r, t) -> {
            if (Objects.nonNull(t)) {
                System.out.println("执行失败！");
                return t.getMessage();
            } else {
                System.out.println("执行成功！");
                return r;
            }
        });
        try {
            System.out.println("结果：" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenAccept() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                () -> new Random().nextInt(100)
        ).thenAccept(
                r -> System.out.println("结果：" + r)
        );
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenRun() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(
                () -> new Random().nextInt(100)
        ).thenRun(
                () -> System.out.println("thenRun ...")
        );
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenCombine() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "hello ");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "world");
        CompletableFuture<String> future3 = future1.thenCombine(future2, (r1, r2) -> r1 + r2);
        try {
            System.out.println("结果：" + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void thenAcceptBoth() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(3);
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f1=" + t);
            return t;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int t = new Random().nextInt(4);
            try {
                TimeUnit.SECONDS.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("f2=" + t);
            return t;
        });
        CompletableFuture<Void> future3 = future1.thenAcceptBoth(future2, (r1, r2) -> {
            System.out.println("r1=" + r1 + ";r2=" + r2 + ";");
        });
        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void applyToEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result1 = " + result);
            return result;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result2 = " + result);
            return result;
        });

        CompletableFuture<Integer> future3 = future1.applyToEither(future2, r -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return r * 2;
        });
        try {
            System.out.println("结果：" + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void acceptEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result1 = " + result);
            return result;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("result2 = " + result);
            return result;
        });

        CompletableFuture<Void> future3 = future1.acceptEither(future2, r -> {
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("结果：" + r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runAfterEither() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result1 = " + result);
            return result;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("result2 = " + result);
            return result;
        });

        CompletableFuture<Void> future3 = future1.runAfterEither(future2, () -> System.out.println("上面有一个已经完成了..."));

        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runAfterBoth() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result1 = " + result);
            return result;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("result2 = " + result);
            return result;
        });

        CompletableFuture<Void> future3 = future1.runAfterBoth(future2, () -> System.out.println("上面两个任务都执行完成了。"));

        try {
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void thenCompose() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int result = new Random().nextInt(100);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("result1 = " + result);
            return result;
        }).thenCompose(r -> CompletableFuture.supplyAsync(() -> {
            System.out.println("result2 = 999");
            return 999;
        }));
        try {
            System.out.println("结果：" + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    // 异步处理
//    CompletableFuture<List<TimelyMonitorItemResult>> futureDay1 = CompletableFuture.supplyAsync(() -> getTimelyMonitorItemResult(monitorService, siteId, yesterday, yesterday), threadPoolTaskExecutor);
//    CompletableFuture<TimelyMonitorItemResult> futureDay2 = CompletableFuture.supplyAsync(() ->
//            BeanUtils.copy(getFullMonitorItemResultForToday(monitorService, siteId, QualityMonitorConstants.SIGN_OPT), TimelyMonitorItemResult.class), threadPoolTaskExecutor);
//
//    CompletableFuture<List<TimelyMonitorItemResult>> futureMonth1 = CompletableFuture.supplyAsync(() -> getTimelyMonitorItemResult(monitorService, siteId, firstDayOfMonth, lastDayOfMonth), threadPoolTaskExecutor);
//    CompletableFuture<TimelyMonitorItemResult> futureMonth2 = CompletableFuture.supplyAsync(() ->
//            BeanUtils.copy(getFullMonitorItemResultForMonth(monitorService, siteId, QualityMonitorConstants.SIGN_OPT), TimelyMonitorItemResult.class), threadPoolTaskExecutor);
//
//        CompletableFuture.allOf(futureDay1, futureDay2, futureMonth1, futureMonth2).join();
}
