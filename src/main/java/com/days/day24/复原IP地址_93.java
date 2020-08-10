package com.days.day24;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class 复原IP地址_93 {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("1231231231234"));
    }
}
class Solution {
    private List<String> result =new ArrayList<>();
    private char[] chars = null;
    private int[] segAddr = new int[4];
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12) return result;
        chars = s.toCharArray();
        dfs(0,0);
        return result;
    }

    public void dfs(int id,int start){
        if(id==4){
            if(start == chars.length){
                StringBuilder builder = new StringBuilder();
                builder.append(segAddr[0]);
                for(int i = 1;i<4;i++){
                    builder.append('.');
                    builder.append(segAddr[i]);
                }
                result.add(builder.toString());
            }
            return;
        }

        if(start==chars.length) return;
        if(chars[start]=='0'){
            segAddr[id] = 0;
            dfs(id+1,start+1);
            return;
        }
        int sum = 0;
        for(int i = 0;i<3 && (start+i)<chars.length;i++){
            sum = sum * 10 + (chars[start+i]-'0');
            if(sum > 0 && sum <=0xFF) {
                segAddr[id] = sum;
                dfs(id + 1, start + i + 1);
            }else break;
        }
    }
}