package com.days.day01;

import java.util.Arrays;

/**
 *  https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/comments/
 */
public class 数组中两元素的最大乘积_1464 {
}

class Solution23 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length-1] -1) * (nums[nums.length-2]-1);
    }
}
