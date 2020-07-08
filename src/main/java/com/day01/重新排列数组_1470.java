package com.day01;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shuffle-the-array/
 */
public class 重新排列数组_1470{

    public static void main(String[] args) {

    }
}

class Solution5 {
    public int[] shuffle(int[] nums, int n) {
        int result[] = new int[n<<1];
        for(int i = 0;i<n;i++){
            result[i<<1] = nums[i];
            result[(i<<1)+1] = nums[n + i];
        }
        return result;
    }
}