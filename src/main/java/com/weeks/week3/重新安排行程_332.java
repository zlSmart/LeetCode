package com.weeks.week3;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 */
public class 重新安排行程_332 {
}
class Solution10 {
    List<String> result = null;
    Map<String,PriorityQueue<String>> maps = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        maps = new HashMap<>();
        for (List<String> list: tickets) {
            if(!maps.containsKey(list.get(0))) maps.put(list.get(0),new PriorityQueue<String>());
            maps.get(list.get(0)).offer(list.get(1));
        }
        result = new ArrayList<>();
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String from) {
        while(maps.containsKey(from) && maps.get(from).size()>0){
            String poll = maps.get(from).poll();
            dfs(poll);
        }
        result.add(from);
    }
}