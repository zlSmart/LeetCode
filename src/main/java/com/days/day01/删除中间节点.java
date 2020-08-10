package com.days.day01;

/**
 *  https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class 删除中间节点 {
}

class Solution7 {
    public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
