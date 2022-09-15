package com.example.commons.config.feign;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: Lc
 * @Date: 2021-10-28
 * @apiNote
 */
public class BlockingQueueTest {
    // 任务队列
    BlockingQueue<Test1> bq=new
            LinkedBlockingQueue<>(2000);

    public static void main(String[] args) {
//        BlockingQueueTest blockingQueueTest = new BlockingQueueTest();
//        blockingQueueTest.start();
        Object o = 1;
        System.out.println(o);
    }

    public BlockingQueueTest(){
        for (int i = 0; i < 5; i++) {
            bq.add(new Test1());
        }
    }

    void start() {
        // 启动 5 个消费者线程
        // 执行批量任务
        ExecutorService es= Executors
                .newFixedThreadPool(5);
        for (int i=0; i<5; i++) {
            es.execute(()->{
                try {
                    while (true) {
                        // 获取批量任务
                        List<Test1> ts=pollTasks();
                        // 执行批量任务
                        execTasks(ts);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
    // 从任务队列中获取批量任务
    List<Test1> pollTasks()
            throws InterruptedException{
        List<Test1> ts=new LinkedList<>();
        // 阻塞式获取一条任务
        Test1 t = bq.take();
        while (t != null) {
            ts.add(t);
            // 非阻塞式获取一条任务
            t = bq.poll();
        }
        return ts;
    }
    // 批量执行任务
    void execTasks(List<Test1> ts) {
        // 省略具体代码无数
        System.out.println(111);
        for (int i = 0; i < 5; i++) {
            bq.add(new Test1());
        }
    }

}
