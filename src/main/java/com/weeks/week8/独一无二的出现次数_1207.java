package com.weeks.week8;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */
public class 独一无二的出现次数_1207 {
}
class Solution {
//    public boolean uniqueOccurrences(int[] arr) {
//        Map<Integer,Integer> times = new HashMap<>();
//        for (int num:arr) {
//            int time = times.getOrDefault(num,0);
//            times.put(num,++time);
//        }
//        int size = times.size();
//        Set<Integer> ans = new HashSet<>(times.values());
//        return ans.size()==size;
//    }
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int counts = 1;
            while (i < arr.length - 1) {
                if(arr[i+1] == arr[i]) {
                    counts++;
                    i++;
                }else {
                    break;
                }
            }
            if(set.contains(counts)) {
                return false;
            } else {
                set.add(counts);
            }
        }
        return true;
    }
}