package com.days.day07;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class 三角形最小路径和_120 {
    public static void main(String[] args) {
    }
}
// 空间优化
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] result = new int[n];
        Arrays.fill(result,Integer.MAX_VALUE);
        result[0] = triangle.get(0).get(0);
        List<Integer> list;
        int temp,temp2 = Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        for(int j = 1;j<triangle.size();j++){
            list = triangle.get(j);
            int size = (list.size()-1);
            temp = result[size];
            for(int i = size;i>=0;i--){
                if(i>0) temp2 = result[i-1];
                result[i] = Math.min(temp,temp2) + list.get(i);
                temp = temp2;
            }
        }
        for(int i = 0;i< n;i++){
            if(r > result[i]) r = result[i];
        }
        return r;
    }
}

class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] result = new int[n][n];
        Arrays.fill(result[0],Integer.MAX_VALUE);
        result[0][0] = triangle.get(0).get(0);
        for(int i =1;i<n;i++){
            Arrays.fill(result[i],Integer.MAX_VALUE);
            result[i][0] = result[i-1][0] + triangle.get(i).get(0);
        }
        List<Integer> list;
        for(int j = 1;j<triangle.size();j++){
            list = triangle.get(j);
            for(int i = 1;i<list.size();i++){
                result[j][i] = Math.min(result[j-1][i],result[j-1][i-1]) + list.get(i);
            }
        }
        int r = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(r > result[n-1][i]) r = result[n-1][i];
        }
        return r;
    }
}
