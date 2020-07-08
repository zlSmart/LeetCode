package com.day01;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 */
public class 分割平衡字符串_1221 {
}

class Solution31 {
    public int balancedStringSplit(String s) {
        int result = 0;
        int stack = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='R') stack++;
            else stack--;
            if(stack==0) result++;
        }
        return result;
    }
}