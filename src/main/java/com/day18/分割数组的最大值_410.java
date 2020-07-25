package com.day18;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class 分割数组的最大值_410 {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        new Solution().splitArray(nums,2);
    }
}
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i<=n;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        int[] sub =new int[n+1];
        for(int i =0;i< n;i++){
            sub[i+1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=Math.min(i,m);j++){
                for(int k = 0;k<i;k++) {
                    System.out.println(i+ " " + j+ " " +k);
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1],sub[i]-sub[k]));
                }
            }
        }
        return dp[n][m];
    }
}