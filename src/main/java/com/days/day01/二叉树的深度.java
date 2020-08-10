package com.days.day01;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 */
public class 二叉树的深度 {
}
class Solution34 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}