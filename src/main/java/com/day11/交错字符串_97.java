package com.day11;

/**
 * https://leetcode-cn.com/problems/interleaving-string/
 */
public class 交错字符串_97 {
}
// 动态规划
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(),m=s2.length(),k=s3.length();
        if((n+m)!=k) return false;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                int p = i + j -1;
                if(i>0){
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i) == s3.charAt(p));
                }
                if(j>0){
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j) == s3.charAt(p));
                }
            }
        }
        return dp[n][m];
    }
}


