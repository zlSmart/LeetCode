package com.weeks.week5;

public class 整数1_n中1出现的次数_43 {
}
class Solution5 {
    public int countDigitOne(int n) {
        int ans = 0;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        while (high!= 0 || cur!=0){
            if(cur==0){
                ans += high * digit;
            }else if (cur==1){
                ans += high * digit + low + 1;
            }else{
                ans += high * digit + digit;
            }
            low += cur * digit;
            cur = high %10;
            high /= 10;
            digit *= 10;
        }
        return ans;
    }
}