package com.weeks.week2;

import sun.reflect.generics.tree.Tree;

public class 有序链表转换为二叉搜索树_109 {
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        return BuildTree(head,null);
    }

    private TreeNode BuildTree(ListNode left, ListNode right) {
        if(left == right) return null;
        ListNode middle = getMiddle(left,right);
        TreeNode treeNode = new TreeNode(middle.val);
        treeNode.left = BuildTree(left,middle);
        treeNode.right = BuildTree(middle.next,right);
        return treeNode;
    }

    private ListNode getMiddle(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while(fast!=right && fast.next!=right){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow;
    }
}