package com.day01;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class 左旋转字符串 {
    public static void main(String[] args) {

    }
}
class Solution6 {
    public String reverseLeftWords(String s, int n) {
        String str1 = s.substring(0,n);
        String str2 = s.substring(n);
        return str2 + str1;
    }
}