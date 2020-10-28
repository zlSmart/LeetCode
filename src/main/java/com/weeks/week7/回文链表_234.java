package com.weeks.week7;

import com.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class 回文链表_234 {
}
class Solution5 {
    ListNode slow,fast;
    public boolean isPalindrome(ListNode head) {
        if(head!=null){
            slow = fast = head;
            while(fast.next!=null){
                slow = slow.next;
                fast = fast.next;
            }
            ListNode temp = reverse(slow);
            fast = head;
            while(temp!=null){
                if (fast.val!=temp.val)return false;
                fast = fast.next;
                temp = temp.next;
            }
            slow.next = reverse(slow);
        }
        return true;
    }

    private ListNode reverse(ListNode slow) {
        ListNode cur=slow,prev = null;
        while(cur!=null){
            ListNode temp= cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}