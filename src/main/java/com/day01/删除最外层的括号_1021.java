package com.day01;

import java.util.LinkedList;
import java.util.Stack;

/**
 *  https://leetcode-cn.com/problems/remove-outermost-parentheses/
 */
public class 删除最外层的括号_1021 {
    public static void main(String[] args) {
    }
}

class Solution29 {
    public String removeOuterParentheses(String S) {
        StringBuilder builder = new StringBuilder();
        int level = 0;
        for(int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '(') level++;
            if(level > 1) builder.append(c);
            if(c == ')') level--;
        }
        return builder.toString();
    }
}

class Solution28 {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder builder = new StringBuilder();
        int start = 0,end = 0;
        for(int i = 0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == '('){
                if(stack.empty()) start = i;
                stack.push(c);
            }else{
                stack.pop();
                if(stack.empty()){
                    builder.append(S.substring(start+1,i));
                }
            }
        }
        return builder.toString();
    }
}