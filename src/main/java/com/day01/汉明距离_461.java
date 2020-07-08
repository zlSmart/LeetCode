package com.day01;

public class 汉明距离_461 {
}
class Solution38 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}