package com.days.day17;

/**
 * https://leetcode-cn.com/problems/divisor-game/
 */
public class 除数博弈_1025 {
}
class Solution {
    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}