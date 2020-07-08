package com.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 */
public class 解压缩编码列表_1313 {
}

// 13
class Solution13 {
    public int[] decompressRLElist(int[] nums) {
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i = 0;i<nums.length-1;i+=2){
//            while(nums[i]>0){
//                list.add(nums[i+1]);
//                nums[i]--;
//            }
//        }
//        int[] result = new int[list.size()];
//        for(int i = 0;i<list.size();i++){
//            result[i] = list.get(i);
//        }
        int len = 0;
        for(int i = 0;i<nums.length-1;i+=2){
            len += nums[i];
        }
        int result[] = new int[len];
        int index = 0,i=0;
        while(i < nums.length){
            for(int k =0;k<nums[i];k++){
                result[index++] = nums[i+1];
            }
            i += 2;
        }
        return result;
    }
}
