package com.day01;

public class 将数字变成0的操作次数_1342 {
}

class Solution12 {
    public int numberOfSteps (int num) {
        int result = 0;
        while(num > 0){
            if((num & 1) == 1){
                num &= -2;
            }else{
                num >>= 1;
            }
            result++;
        }
        return result;
    }
}