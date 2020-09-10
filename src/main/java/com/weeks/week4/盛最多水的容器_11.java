package com.weeks.week4;

public class 盛最多水的容器_11 {
}
class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int n = height.length-1;
        int start = 0,end=n;
        while(start<end){
            int min = Math.min(height[start],height[end]);
            result = Math.max(result,min*(end-start));
            int a = min==height[start]?start++:end--;
        }
        return result;
    }
}