package com.weeks.week7;

import java.util.Arrays;

public class 视频拼接_1024 {
}
class Solution7 {
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp,0x7fffffff);
        dp[0] = 0;
        for (int i = 1;i<=T;i++){
            for (int[] clip:clips){
                if (clip[0]<=i && i<=clip[1]){
                    dp[i] = Math.min(dp[i],dp[clip[0]]+1);
                }
            }
        }
        return dp[T]==0x7fffffff?-1:dp[T];
    }
}
class Solution6 {
    public int videoStitching(int[][] clips, int T) {
        int count = 0;
        int e;
        int s=0;
        for(int i = 0;i<=T;i++){
            e = 0;
            for (int j = 0 ;j<clips.length;j++){
                if (clips[j][0]<=s){
                    e = Math.max(clips[j][1],e);
                }
            }
            count++;
            if (e>=T)return count;
            s = e;
        }
        return -1;
    }
}