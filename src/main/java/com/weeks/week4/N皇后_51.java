package com.weeks.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 */
public class N皇后_51 {
    public static void main(String[] args) {
    }
}
class Solution5 {
    List<List<String>> result = new ArrayList<>();
    int[] visited;
    public List<List<String>> solveNQueens(int n) {
        visited = new int[n];
        dfs(0,n);
        return result;
    }

    public void dfs(int index,int n){
        if(index == n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i<n;i++){
                char[] chars = new char[n];
                Arrays.fill(chars,'.');
                chars[visited[i]] = 'Q';
                list.add(new String(chars));
            }
            result.add(list);
            return;
        }else{
            for(int i = 0;i<n;i++){
                if(isTrue(i,index)==false) continue;
                visited[index] = i;
                dfs(index+1,n);
            }
        }
    }
    public boolean isTrue(int pos, int index){
        for (int i = 0;i<index;i++){
            int qIndex = visited[i];
            if (pos==qIndex || Math.abs(qIndex-pos)==Math.abs(index-i)) return false;
        }
        return true;
    }
}