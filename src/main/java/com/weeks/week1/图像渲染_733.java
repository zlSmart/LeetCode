package com.weeks.week1;

/**
 * https://leetcode-cn.com/problems/flood-fill/
 */
public class 图像渲染_733 {
}
class Solution {
    int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]!=newColor){
            dfs(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int newColor) {
        image[sr][sc] = newColor;
        for(int i = 0;i<4;i++){
            int _x = sr + direction[i][0];
            int _y = sc + direction[i][1];
            if(_x>=0 && _x < image.length && _y>=0 && _y<image[0].length && image[_x][_y]==color){
                dfs(image,_x,_y,color,newColor);
            }
        }
    }
}