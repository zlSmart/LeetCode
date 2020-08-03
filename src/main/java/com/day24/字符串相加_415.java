package com.day24;

/**
 * https://leetcode-cn.com/problems/add-strings/
 */
public class 字符串相加_415 {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("0", "9"));
    }
}
class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1,j=num2.length()-1,in=0;
        while(i>=0||j>=0){
            int x = i>=0?num1.charAt(i)-'0':0;
            int y = j>=0?num2.charAt(j)-'0':0;
            System.out.println(x + " " + y);
            int sum = x + y + in;
            result.append(sum%10);
            in = sum /10;
            j--;
            i--;
        }
        if(in>0) result.append(in);
        return result.reverse().toString();
    }
}
class Solution1 {

    private int in = 0;
    private StringBuilder result = new StringBuilder();
    public String addStrings(String num1, String num2) {
        if(num2.length() > num1.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num2=="") return num1;
        int j = num1.length()-1;
        for(int i = num2.length()-1;i>=0;i--,j--){
            add(num1.charAt(j),num2.charAt(i));
        }
        while(j>=0){
            add(num1.charAt(j--),'0');
        }
        if(in==1) result.append(1+"");
        return result.reverse().toString();
    }

    public void add(char c1,char c2){
        int num1 = c1-  '0';
        int num2 = c2 - '0';
        int sum = num1 + num2 +in;
        if( sum >=10){
            in = 1;
            sum %=10;

        }else{
            in = 0;
        }
        result.append(sum+"");
    }
}