package com.day09;

/**
 * https://leetcode-cn.com/problems/to-lower-case/
 */
public class 转换成小写字母_709 {
}
class Solution5 {
    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(c >='A' && c <= 'Z'){
                c += 32;
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}