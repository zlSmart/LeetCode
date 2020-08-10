package com.days.day01;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class 替换空格 {
}
class Solution27 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==' '){
                builder.append("%20");
            }else{
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
