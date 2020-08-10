package com.days.day08;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class 从头到尾打印链表 {
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
class Solution4 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack= new Stack<>() ;
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int i = 0;
        while(!stack.empty()){
            result[i++] = stack.pop();
        }
        return result;
    }
}