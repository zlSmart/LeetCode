package com.days.day20;

/**
 * https://leetcode-cn.com/problems/integer-break/
 */
public class 整数拆分_343 {
}

class Solution2 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i = 2;i<=n;i++){
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
