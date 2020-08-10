package com.days.day03;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 */
public class 判定字符是否唯一 {
}

class Solution4 {
    public boolean isUnique(String astr) {
        long x1 = 0L,x2 = 0L, temp;
        for(int i = 0;i<astr.length();i++){
            char c = astr.charAt(i);
            temp = 1L;
            if(c >= 64){
                temp <<= (c-64);
                if((x2 & temp) == temp){
                    return false;
                }
                x2 |= temp;
            }else{
                temp <<= c;
                if((x1 & temp) == temp){
                    return false;
                }
                x1 |= temp;
            }
        }
        return true;
    }
}