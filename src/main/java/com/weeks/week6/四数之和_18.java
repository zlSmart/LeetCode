package com.weeks.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/4sum/
 */
public class 四数之和_18 {
}
class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len>=4){
            Arrays.sort(nums);
            for (int i = 0;i<len-4;i++){
                if (nums[i]+nums[i+1]+nums[i+3]+nums[i+4]>target) break;
                if (nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target) break;
                if (i==0 || nums[i]!=nums[i-1]){
                    for (int j = i+1;j<len-2;j++){
                        if (nums[i]+nums[j]+nums[j+1]+nums[j+2] > target) break;
                        if (nums[i]+nums[j]+nums[len-1]+nums[len-2] < target) break;
                        if (j==i+1 || nums[j]!=nums[j-1]){
                            int l = j+1,r=len-1;
                            while(l<r){
                                int tar = nums[i]+nums[j]+nums[l]+nums[r];
                                if (tar>target) r--;
                                else if (tar<target) l++;
                                else{
                                    ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                                    while(l<r && nums[l+1]==nums[l])l++;
                                    while(l<r && nums[r-1]==nums[r])r--;
                                    l++;
                                    r--;
                                }

                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}