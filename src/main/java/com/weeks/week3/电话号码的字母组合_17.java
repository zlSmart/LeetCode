package com.weeks.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class 电话号码的字母组合_17 {
}
class Solution9 {
    List<String> combinations = null;
    Map<Character, String> phoneMap = null;
    public List<String> letterCombinations(String digits) {
        combinations = new ArrayList<String>();
        phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        if (digits.length() == 0) {
            return combinations;
        }

        backtrack(digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}