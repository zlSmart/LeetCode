package com.days.day23;

import java.util.Stack;

public class 二叉树展开为链表 {
}

class TreeNode {
    int val;
    TreeNode left;TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        root.right = root.left;
        root.left=null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = right;
    }
}