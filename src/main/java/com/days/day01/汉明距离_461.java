package com.days.day01;

/**
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class 汉明距离_461 {
}
class Solution38 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}