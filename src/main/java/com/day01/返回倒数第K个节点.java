package com.day01;

/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class 返回倒数第K个节点 {
}
class Solution32 {
    public int kthToLast(ListNode head, int k) {
        ListNode result,temp;
        result = head;
        temp = head;

        for(int i = 0;i<k;i++){
            temp = temp.next;
        }
        while(temp!=null){
            result = result.next;
            temp = temp.next;
        }
        return result.val;
    }
}