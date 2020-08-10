package com.days.day20;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class 最长定差子序列_1218 {
}
class Solution1 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> maps = new HashMap<>();
        int ans = 0;
        for(int a:arr) {
            int temp = maps.getOrDefault(a-difference,0)+1;
            maps.put(a,temp);
            ans = Math.max(ans,temp);
        }
        return ans;

    }
}