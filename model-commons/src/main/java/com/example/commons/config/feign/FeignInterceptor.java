package com.example.commons.config.feign;

import com.example.commons.bean.LiveMessage;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

/**
 * @Author: Lc
 * @Date: 2021-08-10
 * @apiNote
 */
public class FeignInterceptor implements RequestInterceptor {
    StampedLock lock = new StampedLock();
    private Semaphore semaphore;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
            System.out.println("feign xid："+xid);
        }
        requestTemplate.header(RootContext.KEY_XID, xid);
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException {
//        System.out.println(test());
        // 任务 1：洗水壶 -> 烧开水
        CompletableFuture<Void> f1 =
                CompletableFuture.runAsync(()->{
                    System.out.println("T1: 洗水壶...");
                    sleep(1, TimeUnit.SECONDS);
                    System.out.println("T1: 烧开水...");
                    sleep(15, TimeUnit.SECONDS);
                });
// 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
        CompletableFuture<String> f2 =
                CompletableFuture.supplyAsync(()->{
                    System.out.println("T2: 洗茶壶...");
                    sleep(1/0, TimeUnit.SECONDS);
                    System.out.println("T2: 洗茶杯...");
                    sleep(2, TimeUnit.SECONDS);
                    System.out.println("T2: 拿茶叶...");
                    sleep(1, TimeUnit.SECONDS);
                    return " 龙井 ";
                }).exceptionally(e-> "西湖龙井");
// 任务 3：任务 1 和任务 2 完成后执行：泡茶
        CompletableFuture<String> f3 =
                f1.thenCombine(f2, (__, tf)->{
                    System.out.println("T1: 拿到茶叶:" + tf);
                    System.out.println("T1: 泡茶...");
                    return " 上茶:" + tf;
                });
// 等待任务 3 执行结果
        System.out.println(f3.join());
    }
    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        }catch(InterruptedException e){}
    }
    public static Integer test() throws InterruptedException, ExecutionException {
        // 创建线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(3);
// 创建 CompletionService
        CompletionService<Integer> cs =
                new ExecutorCompletionService<>(executor);
// 用于保存 Future 对象
        List<Future<Integer>> futures =
                new ArrayList<>(3);
// 提交异步任务，并保存 future 到 futures
        futures.add(
                cs.submit(()->geocoderByS1()));
        futures.add(
                cs.submit(()->geocoderByS2()));
        futures.add(
                cs.submit(()->geocoderByS3()));
// 获取最快返回的任务执行结果
        Integer r = 0;
        try {
            // 只要有一个成功返回，则 break
            for (int i = 0; i < 3; ++i) {
                r = cs.take().get();
                // 简单地通过判空来检查是否成功返回
                if (r != null) {
                    break;
                }
            }
        } finally {
            // 取消所有任务
            for(Future<Integer> f : futures) {
                f.cancel(true);
            }
        }
// 返回结果
        return r;
    }

    public static int geocoderByS1(){
        System.out.println("A");
        Random random = new Random();
        return (int)(Math.random()*100)-1;
    }
    public static int geocoderByS2(){
        System.out.println("B");
        return (int)(Math.random()*200)-1;
    }
    public static int geocoderByS3(){
        System.out.println("C");
        return (int)(Math.random()*300)-1;
    }
}
