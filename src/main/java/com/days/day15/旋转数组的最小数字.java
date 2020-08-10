package com.days.day15;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
class Solution {
    public int minArray(int[] numbers) {
        int low=0,high = numbers.length-1;
        while(low<high){
            int mid=(low+high)>>1;
            if(numbers[high] < numbers[mid]){
                low=mid+1;
            }else if(numbers[high] > numbers[mid]){
                high=mid;
            }else{
                high--;
            }
        }
        return numbers[low];
    }
}