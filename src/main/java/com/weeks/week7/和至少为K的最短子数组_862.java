package com.weeks.week7;

import com.sun.corba.se.impl.interceptors.SlotTable;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 */
public class 和至少为K的最短子数组_862 {
}
class Solution4 {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int nums = 0x7fffffff;
        int start = 0,end=0,sum = 0;
        while(true){
            while (end<len){
                sum += A[end];
                if (sum>=K){
                    nums = Math.min(nums,end-start+1);
                    end++;
                    break;
                }
            }
            while(start<end){
                sum -= A[start];
                if (sum>=K){
                    nums = Math.min(nums,end-start+1);
                    start++;
                }else if(A[start]<0){
                    sum-=A[start++];
                }else{
                    break;
                }
            }
            if (start==len) break;
        }
        if (nums==0x7fffffff){
            return -1;
        }else{
            return Math.min(nums,end-start+1);
        }
    }
}