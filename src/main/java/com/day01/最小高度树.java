package com.day01;

import java.util.Arrays;

public class 最小高度树 {
    public static void main(String[] args) {
        TreeNode node = new Solution24().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node.val);
    }
}

class Solution24 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBST1(nums,0,nums.length);
    }

    public TreeNode sortedArrayToBST1(int[] nums,int start,int end){
        if(start>end || start==end) return null;
        int mid = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST1(nums,start,mid);
        node.right = sortedArrayToBST1(nums,mid+1,end);
        return node;
    }

}