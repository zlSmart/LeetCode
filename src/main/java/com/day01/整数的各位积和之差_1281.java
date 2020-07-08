package com.day01;

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class 整数的各位积和之差_1281 {
}



class Solution10 {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n>0){
            int temp = n % 10;
            mul *= temp;
            sum += temp;
            n/=10;
        }
        return mul - sum;
    }
}