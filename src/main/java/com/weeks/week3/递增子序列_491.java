package com.weeks.week3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/increasing-subsequences/
 */
public class 递增子序列_491 {
}
class Solution3 {
    List<List<Integer>> results;
    public List<List<Integer>> findSubsequences(int[] nums) {
        results = new ArrayList<>();
        dfs(nums,0,new ArrayList<>());
        return results;
    }

    private void dfs(int[] nums, int index, List<Integer> lists) {
        if(lists.size()>1){
            results.add(new ArrayList<>(lists));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = index;i<nums.length;i++ ){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            if(lists.size()==0||lists.get(lists.size()-1)>=nums[i]){
                lists.add(nums[i]);
                dfs(nums, i, lists);
                lists.remove(lists.size() - 1);
            }
        }
    }
}