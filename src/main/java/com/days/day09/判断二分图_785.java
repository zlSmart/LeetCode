package com.days.day09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 */
public class 判断二分图_785 {
}
// BFS染色法判断
class Solution1 {
    private int UNCOLOR = 0;
    private int RED = 1;
    private int GREED = 2;

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<graph.length;i++){
            if(colors[i]==UNCOLOR){
                queue.offer(i);
                colors[i] = RED;
                while(!queue.isEmpty()){
                    int node = queue.poll();
                    int color = colors[node] == RED?GREED:RED;
                    for(int pos:graph[node]){
                        if(colors[pos] == UNCOLOR){
                            queue.offer(pos);
                            colors[pos] = color;
                        }else if(colors[pos] != color){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}