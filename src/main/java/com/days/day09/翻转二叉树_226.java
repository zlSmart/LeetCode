package com.days.day09;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class 翻转二叉树_226 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution4 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp =  new TreeNode(0);
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}