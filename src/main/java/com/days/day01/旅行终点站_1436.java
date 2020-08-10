package com.days.day01;

import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/destination-city/
 */
public class 旅行终点站_1436 {
}

class Solution25 {
    public String destCity(List<List<String>> paths) {
        String str = "";
        HashSet<String> set = new HashSet<String>();
        for(List<String> list:paths){
            set.add(list.get(0));
        }
        for(List<String> list:paths){
            if(!set.contains(list.get(1))) return list.get(1);
        }
        return str;
    }
}