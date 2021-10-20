package com.example.commons.thread;

import org.openjdk.jol.info.ClassLayout;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: Lc
 * @Date: 2021-06-19
 */
public class ThreadTest {
    public static void test1(){
        ThreadTest t = new ThreadTest();
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }

    public static void test2() throws InterruptedException {
        Thread.sleep(5000);
        ThreadTest a = new ThreadTest();
        synchronized (a) {
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
    }

    public static void test3() throws InterruptedException {
        Thread.sleep(5000);
        ThreadTest a = new ThreadTest();

        Thread thread1= new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable()); //偏向锁
                }
            }
        };
        thread1.start();
        thread1.join();
        Thread.sleep(10000);

        synchronized (a){
            System.out.println("main locking");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());//轻量锁
        }
    }

    public static void test4() throws InterruptedException {
        Thread.sleep(5000);
        ThreadTest a = new ThreadTest();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        //让线程晚点儿死亡，造成锁的竞争
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);

        for (ThreadInfo info : threadInfos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }

        System.out.println("******active threads count:" + Thread.activeCount());

    }
}
