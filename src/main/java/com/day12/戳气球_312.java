package com.day12;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 */
public class 戳气球_312 {
}
class Solution1 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        int[][] dp = new int[n+2][n+2];
        val[0] = val[n+1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for(int i =n;i>=0;i--){
            for(int j = 1;j<n+2;j++){
                for(int k = i+1;k<j;k++){
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k]+dp[k][j]+val[i]*val[k]*val[j]);
                }
            }
        }
        return dp[0][n+1];
    }
}