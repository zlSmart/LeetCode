package com.weeks.week7;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class 比较含退格的字符串_844 {
    public static void main(String[] args) {
        LocalDate id = LocalDate.now();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-DD h:mm:ss");
    }
}
class Solution1 {
    public boolean backspaceCompare(String S, String T) {
        int s_len = S.length()-1,t_len=T.length()-1;
        int ss = 0,tt=0;
        while(s_len>=0 || t_len>=0){
            while (s_len>=0){
                if (S.charAt(s_len)=='#'){
                    ss++;
                    s_len--;
                }else{
                    if (ss>0) {
                        ss--;
                        s_len--;
                    }
                    else break;
                }
            }
            while (t_len>=0){
                if (T.charAt(t_len)=='#'){
                    tt++;
                    t_len--;
                }else{
                    if (tt > 0) {
                        tt--;
                        t_len--;
                    }
                    else break;
                }
            }
            if (s_len>=0 && t_len>=0){
                if (S.charAt(s_len)!=T.charAt(t_len)) return false;
            }else{
                if (s_len>=0 || t_len>=0){
                    return false;
                }
            }
            s_len--;
            t_len--;
        }
        return true;
    }
}