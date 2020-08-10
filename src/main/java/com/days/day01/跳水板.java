package com.days.day01;


/**
 * https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class 跳水板 {
}

class Solution1 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];

        if (shorter == longer) {
            int[] result = {shorter * k};
            return result;
        } else {
            int[] result = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                result[i] = (k - i) * shorter + i * longer;
            }
            return result;
        }
    }
}