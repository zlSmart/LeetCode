package com.weeks.week4;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class 组合总和III_216 {
}
class Solution10 {
    List<List<Integer>> ans = null;
    List<Integer> temp = null;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        temp = new ArrayList<>();
        dfs(n,k,1);

        return ans;
    }

    private void dfs(int n, int k, int index) {
        if(n==0 && temp.size()==k ){
            ans.add(new ArrayList<>(temp));
            return;
        }else if(n==0 || index>9){
            return;
        }
        if (index<=n){
            temp.add(index);
            dfs(n-index,k,index+1);
            temp.remove(temp.size()-1);
            dfs(n,k,index+1);
        }
    }
}