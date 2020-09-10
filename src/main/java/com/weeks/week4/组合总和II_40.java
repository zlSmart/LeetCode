package com.weeks.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class 组合总和II_40 {

}
class Solution6 {
    List<List<Integer>> result = null;
    List<Integer> temp = null;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(0,candidates,target);
        return result;
    }

    private void dfs(int index, int[] candidates, int target) {
        if (target==0 && !result.contains(new ArrayList<>(temp))) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index;i<candidates.length;i++) {
            if (candidates[i] > target) return;
            else {
                temp.add(candidates[i]);
                dfs(i + 1, candidates, target - candidates[i]);
                temp.remove(temp.size() - 1);

            }
        }
    }
}