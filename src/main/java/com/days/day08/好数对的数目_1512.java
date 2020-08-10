package com.days.day08;

/**
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 */
public class 好数对的数目_1512 {
}

class Solution3 {
    public int numIdenticalPairs(int[] nums) {
        int[] temp = new int[101];
        int ans = 0;
        for(int num:nums){
            ans += temp[num]++;
        }
        return ans;
    }
}
