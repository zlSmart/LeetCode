package com.days.day24;

public class 打家劫舍III_337 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution4 {
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0],result[1]);
    }
    public int[] dfs(TreeNode root){
        if(root==null){
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        return new int[]{root.val + left[1] + right[1],
                Math.max(left[0],left[1]) + Math.max(right[0],right[1])};
    }
}