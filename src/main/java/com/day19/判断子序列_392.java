package com.day19;

/**
 * https://leetcode-cn.com/problems/is-subsequence/
 */
public class 判断子序列_392 {
}
class Solution1 {
    public boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        if(chars.length==0) return true;
        int n = t.length();
        for(int i = 0,j=0;i<n;i++){
            if(chars1[i]==chars[j])j++;
            if(j==chars.length) return true;
        }
        return false;
    }
}
