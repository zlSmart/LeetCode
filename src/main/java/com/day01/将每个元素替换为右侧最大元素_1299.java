package com.day01;

import java.util.Arrays;

/**
 *https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class 将每个元素替换为右侧最大元素_1299 {

}

class Solution30 {
    public int[] replaceElements(int[] arr) {
        int temp = arr[arr.length-1],temp2;
        arr[arr.length-1] = -1;
        for(int i =arr.length-2;i>=0;i--){
            temp2 = arr[i];
            arr[i] = temp;
            if(temp2>temp)
                temp =temp2;
        }
        return arr;
    }
}