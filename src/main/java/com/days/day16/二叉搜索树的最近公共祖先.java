package com.days.day16;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 */
public class 二叉搜索树的最近公共祖先 {
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val<q.val || root.val <p.val && root.val >q.val) return root;
        if(root.val == p.val || root.val==q.val) return root;
        if(root.val > p.val) return lowestCommonAncestor(root.left, p, q);
        else return lowestCommonAncestor(root.right, p, q);
    }
}