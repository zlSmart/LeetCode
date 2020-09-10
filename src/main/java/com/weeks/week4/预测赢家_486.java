package com.weeks.week4;

/**
 * https://leetcode-cn.com/problems/predict-the-winner/
 */
public class 预测赢家_486 {
}
class Solution2 {
    int[][] visited=null;
    public boolean PredictTheWinner(int[] nums) {
        visited = new int[nums.length][nums.length];
        return dfs(nums,0,nums.length-1)>=0;

    }

    public int dfs(int[] nums,int start, int end){
        if(visited[start][end]!=0) return visited[start][end];
        if(start==end) return nums[start];
        visited[start+1][end] = dfs(nums,start+1,end);
        visited[start][end-1] = dfs(nums,start,end-1);
        return Math.max(nums[start]-visited[start+1][end],nums[end]-visited[start][end-1]);
    }
}
