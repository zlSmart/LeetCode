package com.days.day14;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class 将有序数组转换为二叉搜索树_108 {
}

class Solution3 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortedBST(nums,0,nums.length-1);
    }
    public TreeNode sortedBST(int[] nums,int start,int end){
        if(start >end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int i = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[i]);
        root.left=sortedBST(nums,start,i-1);
        root.right = sortedBST(nums,i+1,end);
        return root;
    }
}