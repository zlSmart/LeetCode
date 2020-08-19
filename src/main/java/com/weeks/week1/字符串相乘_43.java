package com.weeks.week1;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 */
public class 字符串相乘_43 {
    public static void main(String[] args) {
    }
}
class Solution5 {
    public String multiply(String num1, String num2) {
        int n = num1.length(),m=num2.length();
        int[] temp = new int[n + m];
        for(int i = n-1;i>=0;i--){
            int a = num1.charAt(i)-'0';
            for(int j = m-1;j>=0;j--){
                int b = num2.charAt(j)-'0';
                int p1=i+j,p2=i+j+1;
                int sum = a * b + temp[p2];
                temp[p2] = sum % 10;
                temp[p1] += sum / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i<temp.length&&temp[i]==0) i++;
        while(i<temp.length) {
            builder.append((char) (temp[i++] + '0'));
        }
        return builder.length()==0?"0":builder.toString();
    }
}