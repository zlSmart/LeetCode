package com.weeks.week2;

/**
 * https://leetcode-cn.com/problems/minesweeper/
 */
public class 扫雷游戏_529 {
}
class Solution4 {
    int[][] pos = {
            {0,1},{1,0},{0,-1},{-1,0},
            {-1,-1},{1,-1},{-1,1},{1,1}
    };
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        dfs(board,click[0],click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if(x<0 || x>=board.length || y<0 || y>=board[0].length) return;
        int count = 0;
        for(int[] x_y:pos){
            if(x+x_y[0]>=0 && x+x_y[0]<board.length && y+x_y[1]>=0 && y+x_y[1]<board[0].length
                    && board[x+x_y[0]][y+x_y[1]]=='M') count++;
        }
        if(count!=0) board[x][y] = (char)(count + '0');
        else{
            for(int[] x_y:pos){
                dfs(board,x+x_y[0],y+x_y[1]);
            }
        }
    }
}