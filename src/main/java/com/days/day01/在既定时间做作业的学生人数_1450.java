package com.days.day01;

/**
 * https://leetcode-cn.com/problems/number-of-students-doing-homework-at-a-given-time/
 */
public class 在既定时间做作业的学生人数_1450 {
}

class Solution20 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for(int i =0;i<startTime.length;i++){
            if(startTime[i]<= queryTime && endTime[i]>= queryTime) result++;
        }
        return result;
    }
}

