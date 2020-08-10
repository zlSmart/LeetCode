package com.days.day01;

/**
 *https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class 二进制链表转整数_1290 {
}

class Solution22 {
    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head!=null){
            result = (result << 1) + head.val;
            head = head.next;
        }
        return result;
    }
}
