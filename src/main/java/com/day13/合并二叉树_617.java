package com.day13;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class 合并二叉树_617 {
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution2 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t2 == null || t1 == null) return t2==null?t1:t2;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
}