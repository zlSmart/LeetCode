package com.weeks.week1;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 */
public class 被围绕的区域_130 {
    public static void main(String[] args) {
        int i = 1; // i=1
        i = i++; // i = 1
        System.out.println(i);
        int j = i++; // j = 1 i = 2
        int k = i + ++i * i++; // 11 2 + 3 *3 i=4
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        System.out.println("k=" + k);
    }

}
class Solution3 {
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        int n = board.length;
        if(n==0) return;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[i][0]=='O'){
                board[i][0]='-';
                dfs(board,i,0);
            }
            if(board[i][m-1]=='O'){
                board[i][m-1]='-';
                dfs(board,i,m-1);
            }
        }
        for(int j = 1; j < m-1; j++){
            if(board[0][j]=='O'){
                board[0][j]='-';
                dfs(board,0,j);
            }
            if(board[n-1][j]=='O'){
                board[n-1][j]='-';
                dfs(board,n-1,j);
            }
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }
    }

    private void dfs(char[][] board, int cow, int row) {
        int tempX;
        int tempY;
        for(int[] pos:direction){
            tempX = cow + pos[0];
            tempY = row + pos[1];
            if(tempX<=0 || tempX >= board.length || tempY<=0 || tempY >= board[0].length ) continue;
            if(board[tempX][tempY]=='O'){
                board[tempX][tempY] = '-';
                dfs(board,tempX,tempY);
            }
        }
        return;
    }
}