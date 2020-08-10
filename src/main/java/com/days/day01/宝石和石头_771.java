package com.days.day01;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class 宝石和石头_771 {
}

class Solution9 {
    public int numJewelsInStones(String J, String S) {
        Map<Character,Integer> maps = new HashMap<Character,Integer>();
        for(int i =0;i<J.length();i++){
            maps.put(J.charAt(i),1);
        }
        int result = 0;
        for(int i = 0;i<S.length();i++){
            if(maps.containsKey(S.charAt(i))) result++;
        }
        return result;
    }
}
