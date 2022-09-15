package com.example.bean;

import lombok.Data;

/**
 * @Author: Lc
 * @Date: 2022-02-28
 * @apiNote
 */
@Data
public class TestQueue {

    private Long id;

    private String createTime;

    private String setting;

    private String  msgNumber;

    private Integer status;

    private String ackTime;

    private Integer failCount;

    private String sendTime;

    private String remarks;

    private Integer sort;

//    public static void main(String[] args) {
//        TaskThread t = new TaskThread();
//        t.start();
//        for (;;){
//            if(t.getIsFall()){
//                System.out.println("可以");
//            }
//        }
//    }
//
//    static class TaskThread extends Thread{
//       private  boolean isFall = false;
//
//       public boolean getIsFall(){
//           return isFall;
//       }
//
//        @Override
//        public void run() {
//           try{
//               Thread.sleep(1000);
//           }catch (InterruptedException e){
//                e.printStackTrace();
//           }
//           this.isFall = true;
//            System.out.println("isFall=" + isFall);
//        }
//    }

}
