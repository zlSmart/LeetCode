package com.days.day08;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/solution/ge-chong-pai-xu-shuang-zhi-zhen-by-toxic-3/
 */
public class 有序数组的平方_977 {
}

/**
 * 尝试流式解决该问题
 */
class Solution2 {
    public int[] sortedSquares(int[] A) {
        return Arrays.stream(A).map(i->Math.abs(i)).sorted().map(i->(int)Math.pow(i,2)).toArray();
    }
}