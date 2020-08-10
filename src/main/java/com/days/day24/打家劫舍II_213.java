package com.days.day24;

import java.util.Arrays;

public class 打家劫舍II_213 {
}
class Solution6 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int pre=0,cur=0,ans1=0,ans2=0,i=0;
        for(;i<n-1;i++){
            ans1 = Math.max(pre+nums[i],cur);
            pre = cur;
            cur = ans1;
        }
        pre=0;
        cur=0;
        for(i =1;i<n;i++){
            ans2 = Math.max(pre+nums[i],cur);
            pre = cur;
            cur = ans2;
        }
        return  Math.max(ans1,ans2);
    }
}
class Solution5 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp1 = new int[n +1];
        int[] dp2 = new int[n +1];
        for(int i = 0;i<n-1;i++){
            if(i==0) dp1[i+1] = nums[i];
            else if(i==1) dp1[i+1] = Math.max(nums[i-1],nums[i]);
            else dp1[i+1] = Math.max(dp1[i],dp1[i-1]+nums[i]);
        }
        System.out.println(Arrays.toString(dp1));
        for(int i = 1;i<n;i++){
            if(i==1) dp2[i] = nums[i];
            else if(i==2) dp2[i] = Math.max(nums[i-1],nums[i]);
            else dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        System.out.println(Arrays.toString(dp2));
        return  Math.max(dp1[n-1],dp2[n-1]);
    }
}