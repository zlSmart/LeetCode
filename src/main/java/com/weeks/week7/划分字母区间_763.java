package com.weeks.week7;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class 划分字母区间_763 {
}
class Solution3 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int len = S.length();
        if (S == null || len <= 0) {
            return ans;
        }
        char[] chars = S.toCharArray();
        int[] last = new int[26];
        for (int i = 0; i< len; i++){
            last[chars[i]-'a'] = i;
        }

        int start = 0,end=0;
        for (int i = 0; i< len; i++){
            end = Math.max(end,last[chars[i]-'a']);
            if (i==end){
                ans.add(end-start+1);
                start = end+1;
            }
        }
        return ans;
    }

}