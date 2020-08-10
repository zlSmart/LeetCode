package com.days.day01;

/**
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 */
public class 按既定顺序创建目标数组_1389 {
}
class Solution14 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int result[] = new int[nums.length];
        for(int i = 0;i<index.length;i++){
            for(int j = result.length-1;j>index[i];j--){
                result[j] = result[j-1];
            }
            result[index[i]] = nums[i];
        }
        return result;
    }
}