package com.weeks.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class 子集_78 {
}
class Solution3 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int len = (1 << n);
        for(int i = 0;i<len;i++){
            List<Integer> temp = new ArrayList<>();
            int tem = i;
            while(tem>0){
                if ((tem & 1)==1){
                    temp.add(nums[tem]);
                }
                tem >>= 1;
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}