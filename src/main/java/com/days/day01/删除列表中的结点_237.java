package com.days.day01;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class 删除列表中的结点_237 {
}
//17

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
class Solution17 {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
