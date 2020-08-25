package com.weeks.week3;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class 接雨水_42 {
}
class Solution7 {
    public int trap(int[] height) {
        int left_max = 0,right_max = 0;
        int left=0;
        int right=height.length-1;
        int ans=0;
        while(left<right){
            if(height[left]<height[right]){
                if(height[left] >= left_max)left_max = height[left];
                else ans += (left_max - height[left]);
                ++left;
            }else{
                if(height[right] >= right_max)right_max = height[right];
                else ans += (right_max - height[right]);
                --right;
            }
        }
    return ans;
    }
}