package com.example.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;


@BenchmarkMode(Mode.AverageTime)     //使用模式  :是对吞吐量 平均响应时间等
@Warmup(iterations = 3)     //配置预热次数， 这里我们设置为3次 ，让Jvm该加载的都加载
//本例是一次运行5秒，总共运行3次
// 在性能对比时候，采用默认1秒即可，
@Measurement(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(1) // 配置同时起多少个线程执行 ，也可以设置到方法上
@Fork(1)    //代表启动多个单独的进程分别测试每个方法，我们这里指定为每个方法启动一个进程
@OutputTimeUnit(TimeUnit.NANOSECONDS)   //OutputTimeUnit 统计结果的时间单位，这个例子的单位为 秒
public class JMHTestDemo {


    @Benchmark
    public void testStringAdd() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("1");
        }
//        System.out.println( sb.toString());
    }

    @Benchmark
    public void testStringBuilderAdd() {
        List<String> strings = new ArrayList<>(100000);
        StringBuilder sb = new StringBuilder();

        strings.stream().forEach(a-> sb.append("1"));
//        System.out.println(sb.toString());
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHTestDemo.class.getSimpleName())
                .build();
        new Runner(opt).run();
//        new JMHTestDemo().getSumByArray();
    }

//    @Benchmark
    public void getSumByArray() {
        long[] array = new long[90000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long result = 0;
        //非分治算法统计数组数据之和
        long startTime = System.currentTimeMillis();
        for(int i=0;i<array.length;i++) {
            result += array[i];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("非分治算法计算结果， sum: " + result + " in " + (endTime - startTime) + " ms");

        //分治算法统计数组数据之和， fork/join:
        ForkJoinTask<Long> task = new fontStr(array, 0, array.length);
        startTime = System.currentTimeMillis();
        result = ForkJoinPool.commonPool().invoke(task);
        endTime = System.currentTimeMillis();
        System.out.println("分治算法计算结果，sum: " + result + " in " + (endTime - startTime) + " ms");
//        System.out.println( sb.toString());
    }


    class fontStr extends RecursiveTask<Long> {
        static final int THRESHOLD = 50000;
        long[] array;
        int start;
        int end;

        fontStr(long[] array,int start,int end){
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // 如果任务足够小,直接计算:
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += this.array[i];
                }
                return sum;
            }
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            fontStr subtask1 = new fontStr(this.array, start, middle);
            fontStr subtask2 = new fontStr(this.array, middle, end);
            invokeAll(subtask1, subtask2);
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            Long result = subresult1 + subresult2;
            return result;
        }
    }
}
