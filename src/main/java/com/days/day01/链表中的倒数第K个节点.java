package com.days.day01;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class 链表中的倒数第K个节点 {
}
class Solution36 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode result,temp;
        result = head;
        temp = head;
        for(int i =0;i<k;i++){
            temp = temp.next;
        }
        while(temp!=null){
            result = result.next;
            temp = temp.next;
        }
        return result;
    }
}