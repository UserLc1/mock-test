package com.example.commons.config.feign;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: Lc
 * @Date: 2021-10-14
 * @apiNote
 */
public class NodeTest {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);

        System.out.println(printListFromTailToHead4(listNode));
    }

    //从尾到头打印链表
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }

    //从尾到头打印链表
    public static ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {//13 ms 9688KB
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while(listNode != null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }

     static class ListNode {
        int val;
        ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }
}
