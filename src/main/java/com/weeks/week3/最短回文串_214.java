package com.weeks.week3;

/**
 * https://leetcode-cn.com/problems/shortest-palindrome/
 */
public class 最短回文串_214 {

    public static void main(String[] args) {
    }
}
class Solution8 {
    public String shortestPalindrome(String s) {
        if(s.length()==0) return "";
        StringBuilder temp = new StringBuilder();
        temp.append("$#");
        for(char c:s.toCharArray()){
            temp.append(c);
            temp.append('#');
        }
        temp.append('@');
        char[] chars = temp.toString().toCharArray();
        int len = 1;
        for(int i = 2;i<chars.length;i++){
            int pos = 0;
            int j = 1;
            for(;j<i;j++){
                if(i+j<chars.length && chars[i-j] == chars[i+j]){
                    pos++;
                }else break;
            }
            if(i==j) len = Math.max(pos,len);
        }
        System.out.println(len);
        StringBuilder builder = new StringBuilder();
        builder.append(s.substring(len,s.length())).reverse().append(s);
        return builder.toString();
    }
}