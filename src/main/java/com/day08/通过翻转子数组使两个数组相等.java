package com.day08;

public class 通过翻转子数组使两个数组相等 {
}

class Solution5 {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;
        int[] tem = new int[1001];
        for (int num: target) {
            tem[num]++;
        }
        for(int num:arr){
            if(tem[num]==0) return false;
            tem[num]--;
        }
        return true;
    }
}