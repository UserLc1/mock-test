package com.example.commons.config.feign;


import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: Lc
 * @Date: 2021-10-08
 * @apiNote
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
         Map<String, String> gos=new ConcurrentHashMap<>();
        gos.put("1","1");
        String str = gos.remove("1");
        System.out.println(str);
        System.out.println(new Test1().getInt());
    }

    public Integer getInt() {
        int temp = 0;
        AtomicStampedReference<Test1> rf = new AtomicStampedReference<>(new Test1(),temp);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(executor);
        AtomicReference<Integer> m = new AtomicReference<>(Integer.MAX_VALUE);
        // 异步向电商 S1 询价
        cs.submit(()->getPriceByS1());
        // 异步向电商 S2 询价
        cs.submit(()->getPriceByS2());
        // 异步向电商 S3 询价
        cs.submit(()->getPriceByS3());
        // 将询价结果异步保存到数据库
        // 并计算最低报价
        for (int i=0; i<3; i++) {
            Integer r = null;
            try {
                r = cs.take().get();
            } catch (Exception e) {}
            m.set(Integer.min(m.get(),r));

        }
        return m.get();
    }

    public Integer getPriceByS1(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    public Integer getPriceByS2(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 2;
    }

    public Integer getPriceByS3(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 3;
    }
}
