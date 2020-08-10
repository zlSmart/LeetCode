package com.days.day05;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/dungeon-game/solution/
 */
public class 地下城游戏_174 {
}

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row+1][col+1];
        for(int i = 0;i<=row;i++) Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[row][col-1] = dp[row-1][col] = 1;
        for(int i = row-1;i>=0;i--){
            for(int j = col-1;j>=0;j--){
                int minn = Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = Math.max(minn-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}