package com.example.commons.config.feign;

import org.checkerframework.checker.units.qual.A;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Lc
 * @Date: 2021-10-20
 * @apiNote
 */
public class Test3 {
    volatile static AtomicReference<Boolean> Boinited = new AtomicReference<>(false);
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 3; i++) {
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        scn();
                    }
                });
            }
        }finally {
            Thread.sleep(2000);
            executorService.shutdown();
            System.out.println(count);
        }

    }


    public static void scn(){
        if(Boinited.getAndSet(true)){
            return;
        }
        count++;
    }
}
