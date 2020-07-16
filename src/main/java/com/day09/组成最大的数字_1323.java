package com.day09;

/**
 * https://leetcode-cn.com/problems/maximum-69-number/
 */
public class 组成最大的数字_1323 {
    public static void main(String[] args) {
    }
}
class Solution6 {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(chars[i]=='6'){
                chars[i] = '9';
                break;
            }
        }
        return Integer.valueOf(new String(chars));
    }
}