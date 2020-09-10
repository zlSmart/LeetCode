package com.weeks.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/combination-sum/
 */
public class 组合总和_39 {
}
class Solution7 {
    List<List<Integer>> result = null;
    List<Integer> temp = null;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(candidates,0,target);
        return result;
    }

    private void dfs(int[] candidates, int index, int target) {
        if (target==0 && !result.contains(new ArrayList<>(temp))){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index;i<candidates.length;i++){
            if (candidates[i] > target) return;
            temp.add(candidates[i]);
            dfs(candidates,i,target-candidates[i]);
            temp.remove(temp.size()-1);
        }
    }
}