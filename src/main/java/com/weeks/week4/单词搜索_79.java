package com.weeks.week4;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/word-search/
 */
public class 单词搜索_79 {
}
class Solution {
    char[] words = null;
    boolean[][] visited = null;
    int[] direction = {0,1,0,-1,1,0,-1,0};
    char[][] boards = null;
    public boolean exist(char[][] board, String word) {
        if (board.length==0 || board[0].length==0) return false;
        words = word.toCharArray();
        boards = board;
        visited = new boolean[board.length][board[0].length];
//        Arrays.fill(visited,false);
        for(int i =0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                if (board[i][j]==words[0]){
                    visited[i][j] = true;
                    boolean res = dfs(i, j, 1);
                    visited[i][j] = false;
                    if (res==true) return  res;
                }
            }
        }
        return false;
    }

    private boolean dfs(int s_x, int s_y, int index) {
        if (index==words.length) return true;
        for(int i = 0;i<7;i+=2){
            int t_x = s_x + direction[i];
            int t_y = s_y + direction[i+1];
            if (t_x<0 || t_x>=boards.length || t_y<0 || t_y>=boards[0].length) continue;
            if (visited[t_x][t_y]==false && boards[t_x][t_y] ==words[index]){
                visited[t_x][t_y]=true;
                boolean res = dfs(t_x, t_y, index + 1);
                if (res==true) return true;
                visited[t_x][t_y]=false;
            }
        }
        return false;
    }
}