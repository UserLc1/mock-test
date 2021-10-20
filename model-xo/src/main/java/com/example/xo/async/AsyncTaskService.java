package com.example.xo.async;

import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: Lc
 * @Date: 2021-07-21
 */
@Component
@Async
@Order(1)
public class AsyncTaskService {
    public Future<String> testFun() throws InterruptedException {
        System.out.println("触发：testFun");
        testFuture();
        return testFuture2();
    }


    public Future<String> testFutureTask() throws InterruptedException {
        System.out.println("触发：testFutureTask");
        final FutureTask<String> stringFutureTask = testFuture3();
        new Thread(stringFutureTask).start();
        return stringFutureTask;
    }

    public Future<String> testFuture() throws InterruptedException {
        System.out.println("触发：testFuture");
        Thread thread = new Thread();
        thread.run();
        for (int i = 0; i < 10; i++) {
            thread.sleep(1000);
            System.out.println("testFuture:"+i);
        }

        return new AsyncResult<>("testFuture");
    }

    public Future<String> testFuture2() throws InterruptedException {
        System.out.println("触发：testFuture2");
        Thread thread = new Thread();
        thread.run();
        for (int i = 0; i < 10; i++) {
            thread.sleep(1000);
            System.out.println("testFuture2:"+i);

        }
        return new AsyncResult<>("testFuture");
    }

    public FutureTask<String> testFuture3() throws InterruptedException {
        System.out.println("触发：testFuture3");

        Callable<String> callable = () -> "testFuture";
        return new FutureTask<>(callable);
    }
}
