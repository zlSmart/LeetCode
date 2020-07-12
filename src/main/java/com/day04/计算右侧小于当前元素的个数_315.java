package com.day04;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/ji-suan-you-ce-xiao-yu-dang-qian-yuan-su-de-ge-s-7/
 */
public class 计算右侧小于当前元素的个数_315 {

    public static void main(String[] args) {
        new Solution().countSmaller(new int[]{5,2,6,1});
    }
}

class Solution {
    private int[] c;
    private int[] a;

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id - 1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }
    // C数组初始化为全零
    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }
    // 当x是奇数时 返回1 偶数时 返回x最大的2的幂因数
    private int lowBit(int x) {
        return x & (-x);
    }

    private void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }
    // 将原数组去重离散化后存入到数组中 并对数组排序
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }
    // 二分查找x的位置
    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
}