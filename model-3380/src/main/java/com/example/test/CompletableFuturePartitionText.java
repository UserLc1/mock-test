package com.example.test;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @Author: Lc
 * @Date: 2022-05-12
 * @apiNote
 */
public class CompletableFuturePartitionText {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        new CompletableFuturePartitionText().test2(list);
    }

    public void test1(List<Integer> ints){
        //获取开始时间
        long startTime=System.currentTimeMillis();
        List<BigDecimal> collect = ints.stream().map(integer -> {sleep(); return new BigDecimal(integer);}).collect(Collectors.toList());
        //结束时间
        long endTime=System.currentTimeMillis();
        System.out.println("耗时时间" + (endTime-startTime) +"ms");
    }

    public void test2(List<Integer> ints){
        long startTime=System.currentTimeMillis();

        //分片
        List<List<Integer>> partition = Lists.partition(ints, 2);
        //并行
        List<CompletableFuture<List<BigDecimal>>> futureList = Lists.newArrayList();
        for (int i = 0; i < partition.size(); i++) {
            int finalI = i;
            CompletableFuture<List<BigDecimal>> future = CompletableFuture.supplyAsync(() ->{
                List<Integer> integers = partition.get(finalI);
                return integers.stream().map(integer -> {sleep(); return new BigDecimal(integer);}).collect(Collectors.toList());
            });
            futureList.add(future);
        }

        //结束时间
        List<List<BigDecimal>> collect = futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("耗时时间" + (endTime-startTime) +"ms");
    }

    void sleep(){
        try {
            Thread.sleep(1000L);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
