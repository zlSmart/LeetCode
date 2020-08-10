package com.days.day01;

/**
 * https://leetcode-cn.com/problems/na-ying-bi/
 */
public class 拿硬币 {
}

class Solution18 {
    public int minCount(int[] coins) {
        int result = 0;
        for(int i =0;i<coins.length;i++){
            if((coins[i] & 1) == 1) {
                result++;
                coins[i]--;
            }
            result += (coins[i]>>1);
        }
        return result;
    }
}