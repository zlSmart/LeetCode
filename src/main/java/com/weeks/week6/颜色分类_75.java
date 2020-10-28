package com.weeks.week6;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class 颜色分类_75 {
}
class Solution4 {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int start=0,end=length-1,temp;
        for(int i= 0;i<length;i++){
            while (i<=end &&nums[i]==2){
                nums[i]= nums[end];
                nums[end--]=2;
            }
            if (nums[i]==0 && i!=start){
                nums[i]= nums[start];
                nums[start++]=0;
            }
        }
    }
}