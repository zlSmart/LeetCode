package com.weeks.week7;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 */
public class 数组中的最长山脉_845 {
}
class Solution8 {
    public int longestMountain(int[] A) {
        int ans = 0;
        int left = 0;
        int len = A.length;
        while(left+2<len){
            int right = left+1;
            if (A[right] > A[left]){
                while(right<len-1 && A[right]>A[right-1]) right++;
                if (right<len-1 && A[right] < A[right-1]){
                    while(right<len && A[right] < A[right-1]) right++;
                    ans = Math.max(ans,right-left+1);
                }else{
                    right++;
                }
            }
            left = right;

        }
        return ans;
    }
}