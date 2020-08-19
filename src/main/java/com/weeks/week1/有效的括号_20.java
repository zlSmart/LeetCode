package com.weeks.week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class 有效的括号_20 {
    public static void main(String[] args) {
    }
}
class Solution6 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:chars){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else{
                switch (c){
                    case ')':if(stack.size()==0 || stack.peek()!='(') return false; stack.pop(); break;
                    case ']':if(stack.size()==0 || stack.peek()!='[') return false; stack.pop(); break;
                    case '}':if(stack.size()==0 || stack.peek()!='{') return false; stack.pop(); break;
                }
            }
        }
        if(stack.size()==0) return true;
        else return false;
    }
}