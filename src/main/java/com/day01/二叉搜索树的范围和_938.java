package com.day01;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class 二叉搜索树的范围和_938 {
}

class Solution39 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        int result = 0;

        if(root.val > R) {
            result += rangeSumBST(root.left,L,R);
        }
        if(root.val < L){
            result += rangeSumBST(root.right,L,R);
        }

        return (root.val + rangeSumBST(root.left,L,R) + rangeSumBST(root.right,L,R));
    }
}