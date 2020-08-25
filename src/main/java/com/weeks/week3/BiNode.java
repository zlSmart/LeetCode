package com.weeks.week3;

import com.TreeNode;

/**
 * https://leetcode-cn.com/problems/binode-lcci/
 */
public class BiNode {
}
class Solution4 {
    TreeNode head = new TreeNode(-1);
    TreeNode prev = null;

    public TreeNode convertBiNode(TreeNode root) {
        if(root==null) return null;
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if(root==null) return;
        helper(root.left);
        if(prev==null){
            prev=root;
            head.right = root;
        }else{
            prev.right = root;
            prev = root;
        }
        root.left=null;
        helper(root.right);
    }
}