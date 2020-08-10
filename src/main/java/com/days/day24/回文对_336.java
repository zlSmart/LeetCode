package com.days.day24;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/palindrome-pairs/
 */
public class 回文对_336 {
    public static void main(String[] args) {

    }
}
class Solution9 {
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word : words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }
}

class Solution7 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int length = words.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1;j<length;j++){
                if(i!=j){
                    boolean palindrome = isPalindrome(words[i] + words[j]);
                    if(palindrome){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        result.add(list);
                    }
                    palindrome = isPalindrome(words[j] + words[i]);
                    if(palindrome){
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public boolean isPalindrome(String str){
        char[] chars = str.toCharArray();
        int length = chars.length;
        for(int i = 0;i<length;i++){
            if(chars[i]!=chars[length-1-i]) return false;
        }
        return true;
    }
}