package com.days.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class 拥有最多糖果的孩子 {
}

class Solution3 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<Boolean>();
        int max = candies[0];
        for(int i =0;i<candies.length;i++){
            if(candies[i] > max) max = candies[i];
        }
        for(int i =0;i<candies.length;i++){
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
}