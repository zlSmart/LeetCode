package com.weeks.week7;

import com.ListNode;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class 重排链表_143 {
}
class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode slowp = head;
        ListNode fastp = head;

        // 当快指针到达链表末尾，慢指针恰好到达链表中点之前的节点
        while (fastp.next != null && fastp.next.next != null) {
            slowp = slowp.next;
            fastp = fastp.next.next;
        }

        // 拟造一个 “新链表头”，将原链表分为两个“等长”链表
        ListNode newHead = slowp.next;
        slowp.next = null;

        newHead = reverseList(newHead);

        // 将两半链表，交相穿插拼接
        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    /**
     * 倒置 链表
     * @param head
     * @return
     */
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        head = head.next;
        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }
}