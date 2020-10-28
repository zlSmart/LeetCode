package com.weeks.week7;

/**
 * https://leetcode-cn.com/problems/UlBDOe/solution/qiu-xie-shou-cang-ji-by-leetcode-solution/
 */
public class 秋叶收藏集 {
}
class Solution9 {
    public int minimumOperations(String leaves) {
        if(leaves=="")return 0;
        int len = leaves.length();
        int[][] dp = new int[len+1][3];
        char[] chars = leaves.toCharArray();
        dp[0][1] = dp[0][2] = Integer.MAX_VALUE;
        for (int i = 1;i<len;i++){
            int isYellow = chars[i]=='y'?1:0;
            dp[i][0] = dp[i-1][0] + isYellow;
            dp[i][1] = Math.min(dp[i-1][1],dp[i-1][0]) + (1 - isYellow);
            if (i>2){
                dp[i][2] = Math.min(dp[i-1][1],dp[i-1][2]) + isYellow;
            }
        }
        return dp[len][2];
    }
}