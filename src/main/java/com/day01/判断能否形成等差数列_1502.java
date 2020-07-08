package com.day01;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class 判断能否形成等差数列_1502 {
}
class Solution19 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        boolean flag = true;
        Arrays.sort(arr);
        int r = arr[1] - arr[0];
        for(int i = 2;i<arr.length;i++){
            if(arr[i] - r != arr[i-1]){
                flag = false;
                break;
            }
        }
        return flag;
    }
}