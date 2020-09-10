package com.weeks.week4;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms/
 */
public class 钥匙和房间_841 {
}
class Solution1 {
    boolean[] visited = null;
    int sum = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms,0);
        return sum==n;
    }

    private void dfs(List<List<Integer>> rooms, int index) {
        sum++;
        visited[index] = true;
        List<Integer> integers = rooms.get(index);
        for(int num:integers){
            if(!visited[num]) dfs(rooms,num);
        }
    }
}