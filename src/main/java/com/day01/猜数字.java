package com.day01;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 */
public class 猜数字 {
}

class Solution8 {
    public int game(int[] guess, int[] answer) {

        return (guess[1] == answer[1]?1:0) + (guess[0] == answer[0]?1:0) + (guess[2] == answer[2]?1:0);
    }
}