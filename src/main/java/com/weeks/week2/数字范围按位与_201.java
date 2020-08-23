package com.weeks.week2;

/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 */
public class 数字范围按位与_201 {
}
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        while(m<n){
            m >>= 1;
            n >>= 1;
            result++;
        }
        return n << result;
    }
}