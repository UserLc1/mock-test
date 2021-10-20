package com.example.commons.config.feign;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: Lc
 * @Date: 2021-10-12
 * @apiNote
 */
public class Test2 {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(4);
        Fibonacci fib = new Fibonacci(5);
        System.out.println(fjp.invoke(fib));
    }

    static class Fibonacci extends
            RecursiveTask<Integer>{
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if(n <= 1){
                return n;
            }
            Fibonacci f1 =
                    new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();
        }
    }
}
