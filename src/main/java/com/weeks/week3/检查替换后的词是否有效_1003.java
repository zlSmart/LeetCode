package com.weeks.week3;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions/
 */
public class 检查替换后的词是否有效_1003 {
    public static void main(String[] args) {

    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c!='c') stack.push(c);
            else{
                if(stack.isEmpty() || stack.pop()!='b') return false;
                if(stack.isEmpty() || stack.pop()!='a') return false;
            }
        }
        return stack.isEmpty();
    }
}
class Solution11 {
    public boolean isValid(String s) {
        while(s.indexOf("abc")!=-1){
            s = s.replace("abc","");
        }
        return s.equals("");
    }
}