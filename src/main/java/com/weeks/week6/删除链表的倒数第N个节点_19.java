package com.weeks.week6;

import com.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class 删除链表的倒数第N个节点_19 {
}
class Solution9 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head,second=head;
        for (int i = 0;i<n;i++){
            first=first.next;
        }
        if (first==null)return head.next;
        while(first.next!=null){
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return head;
    }
}