package com.days.day24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class 课程表_207 {
}
class Solution3 {
    List<List<Integer>> out = new ArrayList<>();

    int[] degree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0;i<numCourses;i++){
            out.add(new ArrayList<>());
        }
        degree = new int[numCourses];
        for(int[] edge:prerequisites){
            out.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(degree[i]==0) queue.offer(i);
        }
        int visited = 0;
        while(!queue.isEmpty()){
            visited++;
            int v = queue.poll();
            for(int in: out.get(v)){
                degree[in]--;
                if(degree[in]==0) queue.offer(in);
            }
        }
        return visited == numCourses;
    }
}