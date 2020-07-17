package com.day10;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/search-insert-position/https://leetcode-cn.com/problems/search-insert-position/
 */
public class 搜索插入位置_35 {
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int search = Arrays.binarySearch(nums, target);
        return search >=0?search:(Math.abs(search)-1);
    }
}
