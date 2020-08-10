package com.days.day12;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class 打开转盘锁_752 {

    public static void main(String[] args) {
        String[] deads = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(new Solution().openLock(deads, "8888"));
    }
}

class Solution {
    
    public String plusOne(String str,int i){
        char[] chars = str.toCharArray();
        if(chars[i] == '9') chars[i] = '0';
        else chars[i]+=1;
        return new String(chars);
    }
    public String minOne(String str,int i){
        char[] chars = str.toCharArray();
        if(chars[i] == '0') chars[i] = '9';
        else chars[i]-=1;
        return new String(chars);
    }
    
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for(String str:deadends) deads.add(str);

        Queue<String> lists = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        lists.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!lists.isEmpty()){
            int size = lists.size();
            for(int j = 0;j<size;j++){
                String poll = lists.poll();
                if(deads.contains(poll)) continue;
                if(poll.equals(target)) return step;
                for(int i = 0;i<4;i++){
                    String plus = plusOne(poll, i);
                    if(visited.add(plus)) lists.offer(plus);
                    String down = minOne(poll, i);
                    if(visited.add(down)) lists.offer(down);
                }
            }
            step++;
        }
        return -1;
    }
}