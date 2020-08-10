package com.days.day01;

/**
 * https://leetcode-cn.com/problems/minimum-time-visiting-all-points/
 */
public class 访问所有点的最小时间_1266 {
}
class Solution37 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for(int i = 1;i<points.length;i++){
            int x= Math.abs(points[i][0] - points[i-1][0]);
            int y = Math.abs(points[i][1]-points[i-1][1]);
            result += Math.max(x,y);
        }
        return result;
    }
}