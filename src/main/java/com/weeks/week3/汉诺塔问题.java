package com.weeks.week3;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/hanota-lcci/
 */
public class 汉诺塔问题 {
}
class Solution5 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A,B,C,A.size());
    }

    private void move(List<Integer> x, List<Integer> y, List<Integer> z, int n) {
        if(n==1) {
            z.add(x.remove(x.size()-1));
            return;
        }

        move(x,z,y,n-1);
        z.add(x.remove(x.size()-1));
        move(y,x,z,n-1);
    }
}