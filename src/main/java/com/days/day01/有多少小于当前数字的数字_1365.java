package com.days.day01;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class 有多少小于当前数字的数字_1365 {

}
//15
class Solution15 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sums = new int[101];
        int[] result = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            sums[nums[i]]  += 1;
        }
        int temp = sums[0],temp2 = 0;
        sums[0] = 0;
        for(int i = 1;i<sums.length;i++){
            temp2 = sums[i];
            sums[i] = sums[i-1] + temp;
            temp = temp2;
        }
        for(int i = 0;i<nums.length;i++){
            result[i] = sums[nums[i]];
        }
        return result;
    }
}