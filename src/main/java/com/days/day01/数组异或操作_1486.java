package com.days.day01;

/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class 数组异或操作_1486 {

}
class Solution4 {
    public int xorOperation(int n, int start) {
        int result = start;
        for(int i = 1;i<n;i++){
            result ^= (start + (i << 1));
        }
        return result;
    }
}