package com.weeks.week2;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class 平衡二叉树_110 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return height(root)>=0;

    }

    public int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);

        if(left== -1 || right==-1 || Math.abs(left-right)>1)return -1;
        else return Math.max(left,right)+1;
    }
}