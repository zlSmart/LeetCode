package com.weeks.week6;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class N皇后II_52 {
    public static void main(String[] args) {
    }
}
class Solution8 {
    int ans = 0;
    int[] visited=null;
    public boolean isVaild(int index,int j,int n){
        for (int i = 0;i<index;i++){
            if (visited[i]==j || visited[i]==j-index+i || visited[i]==j+index-i){
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n) {
        if(n!=0){
            visited=new int[n];
            dfs(0,n);
        }
        return ans;
    }
    public void dfs(int index,int n){
        if (index==n) {
            ans++;
            return;
        }
        for (int i =0;i<n;i++){
            if(isVaild(index,i,n)) {
                visited[index] = i;
                dfs(index + 1, n);
                visited[index] = 0;
            }
        }
    }
}