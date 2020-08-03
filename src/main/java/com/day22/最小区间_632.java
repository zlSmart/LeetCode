package com.day22;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 最小区间_632 {
}
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0,rangeRight=Integer.MAX_VALUE;
        int range = Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int size = nums.size(),minNum;
        int minNext;
        int[] next =new int[size];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums.get(o1).get(next[o1]) - nums.get(o2).get(next[o2]);
            }
        });
        for(int i = 0;i<size;i++){
            queue.offer(i);
            max = Math.max(max,nums.get(i).get(0));
        }
        while(true){
            minNext = queue.poll();
            minNum = nums.get(minNext).get(next[minNext]);
            int minRange = max-minNum;
            if(minRange < range){
                range = minRange;
                rangeLeft = minNum;
                rangeRight = max;
            }
            next[minNext]++;
            while(next[minNext]+1 < nums.get(minNext).size() && nums.get(minNext).get(next[minNext]+1) <= max)
                next[minNext]++;
            if(next[minNext] == nums.get(minNext).size())break;
            queue.offer(minNext);
            max = Math.max(max,nums.get(minNext).get(next[minNext]));
        }
        return new int[]{rangeLeft,rangeRight};
    }
}