package com.day01;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 */

public class 一维数组动态和_1480 {
}

class Solution2 {
    public int[] runningSum(int[] nums) {
        for(int i = 1;i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

