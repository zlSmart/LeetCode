package com.weeks.week5;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class 全排列II_47 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[] = {1,2,5};
        while (in.hasNext()) {
            int n = in.nextInt();
            long res[] = new long[n + 1];
            res[0] = 1L;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j >= arr[i]) {
                        res[j] += res[j - arr[i]];
                    }
                }
            }
            System.out.println(res[n]);

        }
    }
}
class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited = null;
    List<Integer> temp = new ArrayList<>();
    int[] nums_ = null;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        nums_ = nums;
        visited = new boolean[n];
        dfs(0,n);
        return ans;
    }

    private void dfs(int index, int n) {
        if (index == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i< n; i++){
            if (visited[i] || (i > 0 && nums_[i] == nums_[i - 1] && !visited[i - 1])) {
                continue;
            }
            temp.add(nums_[i]);
            visited[i] = true;
            dfs(index + 1, n);
            visited[i] = false;
            temp.remove(temp.size()-1);
        }
    }
}
