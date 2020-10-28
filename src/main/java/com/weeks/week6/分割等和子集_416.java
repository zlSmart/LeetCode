package com.weeks.week6;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class 分割等和子集_416 {
}
class Solution5 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len<2) return false;
        int sum = 0;
        int max = -1;
        for (int num:nums
             ) {
            sum +=num;
            max = Math.max(max,num);
        }
        if((sum&1)==1) return false;
        int mid = sum>>1;
        if (max > mid) return false;
        boolean[][] dp = new boolean[len][mid+1];
        for (int i = 0;i<len;i++){
            dp[i][0] = true;
        }
        for (int i = 1;i<len;i++){
            int num = nums[i];
            for (int j = 1;j<=mid;j++){

                if (j>=num){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-num];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            if (dp[i][mid]){
                return true;
            }
        }
        return dp[len-1][mid];
    }
}