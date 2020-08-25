package com.weeks.week3;

/**
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 */
public class 重复子字符串_459 {
}
class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s,1)!= s.length();
    }
}