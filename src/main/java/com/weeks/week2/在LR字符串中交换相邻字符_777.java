package com.weeks.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/
 */
public class 在LR字符串中交换相邻字符_777 {
}
class Solution5 {
    public boolean canTransform(String start, String end) {
        int N = start.length();
        Map<Integer,Integer> maps = new HashMap<>();
        char[] S = start.toCharArray(), T = end.toCharArray();
        int i = -1, j = -1;
        while(++i < N && ++j < N){
            while(i<N && S[i]=='X') i++;
            while(j<N && T[j]=='X') j++;
            if(i>N||j>N) break;
            if(i<N && j<N){
                if(S[i]!=T[j] || (S[i]=='L' && i<j)||(S[i]=='R' && i>j)) return false;
            }
        }
        while(i<N&&S[i]=='X') i++;
        if(i<N) return false;
        while(j<N&&T[j]=='X') j++;
        if(j<N) return false;
        return true;
    }
}