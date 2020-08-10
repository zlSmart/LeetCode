package com.days.day01;

/**
 *https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 */
public class 二叉树的镜像 {
}
class Solution35 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode node;
        mirrorTree(root.left);
        node = root.left;
        root.left = root.right;
        root.right = node;
        mirrorTree(root.left);
        return root;
    }
}