package com.weeks.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 */
public class 计数二进制子串_696 {
}
class Solution2 {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int result=0,last=0;
        if(chars.length==1) return result;
        int pos = 0;
        while(pos<chars.length){
            int count = 1;
            char c = chars[pos++];
            while(pos<chars.length && chars[pos]==c){
                pos++;
                count++;
            }
            System.out.println(count);
            result += Math.min(last, count);
            last = count;
        }
        return result;
    }
}
class Solution1 {
    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int result=0;
        if(chars.length==1) return result;
        List<Integer> counts = new ArrayList<>();
        int count=1;
        for(int i = 1;i<chars.length;i++){
            if(chars[i-1]==chars[i]) count++;
            else{
                counts.add(count);
                count = 1;
            }
        }
        counts.add(count);
        for(int i = 1;i<counts.size();i++){
            result += Math.min(counts.get(i), counts.get(i-1));
        }
        return result;
    }
}