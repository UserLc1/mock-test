package com.example.commons.bean;

/**
 * @Author: Lc
 * @Date: 2021-03-18
 */
public class TSynchronized implements Runnable {

    static int i = 0;

    public void increase(){
        i++;
    }


    @Override
    public void run() {
        for(int i = 0;i < 1000;i++) {
            increase();
        }
        System.out.println("i = " + i);
    }

    public static void main(String[] args) throws InterruptedException {

        TSynchronized tSynchronized = new TSynchronized();
        Thread aThread = new Thread(tSynchronized);
        Thread bThread = new Thread(tSynchronized);
        aThread.start();
        bThread.start();
    }

}
