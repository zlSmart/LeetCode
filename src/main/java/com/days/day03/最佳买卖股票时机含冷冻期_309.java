package com.days.day03;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class 最佳买卖股票时机含冷冻期_309 {
}


class Solution3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0 || n == 1) return 0;
        int x = -prices[0],y = 0, z = 0;

        for(int i = 1;i<n;i++){
            int temp = y;
            y = x + prices[i];
            x = Math.max(x,z-prices[i]);
            z = Math.max(temp,z);
        }
        return Math.max(z,y);
    }
}

class Solution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0 || n == 1) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = - prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1] - prices[1]);
        for(int i = 2;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-2][0] + prices[i-1],dp[i-1][1]);
        }
        return Math.max(dp[n-2][0]+prices[n-1],dp[n-1][1]);
    }
}

class Solution1 {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if(n==0 || n == 1) return 0;
        int[][] dp = new int[n][3];
        dp[0][0] = - prices[0];
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2] - prices[i]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[n-1][1],dp[n-1][2]);
    }
}