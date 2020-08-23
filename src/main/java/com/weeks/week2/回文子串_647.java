package com.weeks.week2;

/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class 回文子串_647 {
}
class Solution3 {
    public int countSubstrings(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append("$#");
        for(int i = 0;i<s.length();i++){
            builder.append(s.charAt(i));
            builder.append("#");
        }
        builder.append("^");
        char[] chars = builder.toString().toCharArray();
        int[] p = new int[chars.length];
        int count = 0;
        for(int i = 2;i<chars.length;i++){
            if(chars[i]!='#') {
                int c = 1;
                for (int j = 0; ; j++) {
                    if (i-j>=0 && i+j<chars.length && chars[i-j] == chars[i+j]) c++;
                    else break;
                }
                count = count + c - 1;
            }
        }
        return count;
    }
}
