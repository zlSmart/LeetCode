package com.day08;

import java.util.Optional;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class 不同的二叉搜索树_96 {
    public static void main(String[] args) {
    }
}

/**
 * 考察数学 卡特兰数 h(n) = h(n-1)*(4n+2)/(n+2);
 *      其他情况:
 *          二叉树计数、出栈序列、 加括号、 凸多边形划分、 排队买票找零问题、 高矮排队问题
 */
class Solution1 {
    public int numTrees(int n) {
        long result = 1;
        for(int i = 0;i<n;i++){
            result = result * (4*i+2) / (i+2);
        }
        return (int)result;
    }
}
