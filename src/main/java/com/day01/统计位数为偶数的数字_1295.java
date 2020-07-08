package com.day01;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 */
public class 统计位数为偶数的数字_1295 {
}
class Solution16 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int i = 0 ;i<nums.length;i++){
            if((nums[i]>=10 && nums[i]<100) || (nums[i]>=1000 && nums[i]<10000) || nums[i] == 100000){
                result++;
            }
        }
        return result;
    }
}