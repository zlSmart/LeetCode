package com.day02;


import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/re-space-lcci/
 * 字典树构建查找
 */
public class 恢复空格 {

    public static void main(String[] args) {

        String[] dictionary = {"potimzz"};
        String sentence = "potimzzpotimzz";
        System.out.println(new Solution().respace(dictionary,sentence));
    }
}

class Solution {
    class Trie{
        boolean isWord;
        Trie[] child;
        public Trie(){
            child = new Trie[26];
            isWord = false;
        }
    }
    public void makeTrie(Trie root,String[] dictionary){
        for(String str:dictionary){
            Trie temp = root;
            for(int i = str.length()-1; i>=0; i--){
                int pos = str.charAt(i) - 'a';
                if(temp.child[pos] == null){
                    temp.child[pos] = new Trie();
                }
                temp = temp.child[pos];
            }
            temp.isWord = true;
        }
    }
    public int respace(String[] dictionary, String sentence) {
        Trie root = new Trie();
        makeTrie(root, dictionary);
        int n = sentence.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.child[t] == null) {
                    break;
                } else if (curPos.child[t].isWord) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.child[t];
            }
        }
        return dp[n];
    }
}