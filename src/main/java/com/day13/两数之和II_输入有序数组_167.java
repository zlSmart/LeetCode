package com.day13;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class 两数之和II_输入有序数组_167 {
}
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {1,numbers.length};
        while(true){
            if(numbers[result[0]-1] + numbers[result[1]-1] == target) return result;
            else if(numbers[result[0]-1] + numbers[result[1]-1] > target) result[1]--;
            else result[0]++;
        }
    }
}