package com.weeks.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class 三数之和_15 {
}
class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n<3){
            return ans;
        }
        Arrays.sort(nums);
        for (int first = 0;first < n-3;first++){
            if (first==0 || nums[first]!=nums[first-1]){
                int tar = -nums[first];
                int second = first+1;
                int third = n-1;
                for (;second<n-1;second++){
                    if (second==first+1 || nums[second-1]!=nums[second]){
                        while(second<third && nums[second] + nums[third] > tar){
                            third-=1;
                        }
                        if (second==third){
                            break;
                        }
                        if (nums[first]+nums[second]+nums[third]==0){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[first]);
                            temp.add(nums[second]);
                            temp.add(nums[third]);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
