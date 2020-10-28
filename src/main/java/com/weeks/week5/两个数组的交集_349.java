package com.weeks.week5;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class 两个数组的交集_349 {
}
class Solution6 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num: nums1) {
            set1.add(num);
        }
        for (int num: nums2) {
            set2.add(num);
        }
        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int idx = 0;
        for (int s : set1) ans[idx++] = s;
        return ans;
    }
}