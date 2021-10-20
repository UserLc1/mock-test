package com.example.commons.demo.demo;

import java.util.List;


/**
 * @Author: Lc
 * @Date: 2020-09-23
 */
public class Demo {

    public static void main(String[] args) {
//        Map<List,List> map = new HashMap<>();
//        Map<ArrayList,ArrayList> listMap= new HashMap<>();
//        map.putAll(listMap);
        System.out.println(7>>8);
    }
    public static List<? extends Demo>getT(List<? extends Demo> list){
        return list;
    }

}
