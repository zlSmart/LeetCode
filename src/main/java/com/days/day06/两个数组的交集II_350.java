package com.days.day06;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class 两个数组的交集II_350 {
}


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int temp[];
        int n = nums1.length;
        int m = nums2.length;
        if(n < m){
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            n = n ^m;
            m = n ^ m;
            n = n ^ m;
        }
        Map<Integer,Integer> maps = new HashMap<>();
        List<Integer> arrays = new ArrayList<>();
        for(int i = 0;i<m;i++){
            int t = nums2[i];
            if(maps.containsKey(t))
                maps.put(t,maps.get(t)+1);
            else
                maps.put(t,1);
        }
        for(int i =0;i<n;i++){
            int t = nums1[i];
            if(maps.containsKey(t)){
                Integer integer = maps.get(t);
                if(integer > 0) {
                    arrays.add(t);
                    integer--;
                    maps.put(t,integer);
                }
            }
        }
        return arrays.stream().mapToInt(Integer::intValue).toArray();
    }
}