package com.weeks.week3;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class 字符串转换整数_8 {
}
class Solution2 {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        boolean flag = true;
        int i = 0;
        for(;i<chars.length;i++){
            if (chars[i] == ' ') continue;
            if(chars[i]=='-' || chars[i]=='+') {flag = chars[i]=='-'?false:true;i++;break;}
            break;
        }
        for(;i<chars.length;i++){
            if(chars[i]>'9' || chars[i]<'0') break;
            if(result > (Integer.MAX_VALUE - (chars[i]-'0'))/10)
                return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
            result = result * 10 + (chars[i] - '0');
        }
        return flag?result:0-result;
    }
}