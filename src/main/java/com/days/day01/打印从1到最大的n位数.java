package com.days.day01;

/**
 *https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class 打印从1到最大的n位数 {
}

class Solution33 {
    public int[] printNumbers(int n) {
        int len = (int)Math.pow(10,n)-1;
        int[] result = new int[len];
        for(int i = 0;i< len;i++){
            result[i] = i+1;
        }
        return result;
    }
}