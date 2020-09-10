package com.weeks.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/combinations/
 */
public class 组合_77 {
}
class Solution8 {
    List<List<Integer>> result = null;
    List<Integer> temp = null;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        temp = new LinkedList<>();
        dfs(1,k,n);
        return result;
    }

    private void dfs(int index, int k, int n) {
        if(temp.size() + (n-index)+1 < k) return;
        if(temp.size()==k){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index;i<=n;i++){
            temp.add(i);
            dfs(i+1,k,n);
            temp.remove(temp.size()-1);
        }

    }
}