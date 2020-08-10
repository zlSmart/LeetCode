package com.days.day01;

/**
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class 统计有序矩阵中的负数_1351 {
}
class Solution26 {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = grid[i].length-1;j>=0;j--){
                if(grid[i][j] >=0) break;
                result++;
            }
        }
        return result;
    }
}