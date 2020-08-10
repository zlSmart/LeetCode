package com.算法;

/**
 * 马拉车算法
 */
public class Manacher {
    public static boolean  isPalindromePairs(String str){
        StringBuilder builder = new StringBuilder();
        /**
         * 预处理 将回文串变为奇数串
         */
        builder.append("$");
        char[] chars = str.toCharArray();
        int slength = chars.length;
        for (int i = 0;i<slength;i++) builder.append("#"+chars[i]);
        builder.append("#@");
        /**
         *  以第i个字符为中心的最长回文半径辅助数组
         */
        int length = builder.length();
        int[] p = new int[length];
        int id = 0, mx = 0, maxLength=-1,index = 0;
        for (int j=1; j<length-1; j++) {
            // 参看前文第五部分
            p[j] = mx > j ? Math.min(p[2*id-j], mx-j) : 1;
            // 向左右两边延伸，扩展右边界
            while (builder.charAt(j+p[j]) == builder.charAt(j-p[j])) {
                p[j]++;
            }
            // 如果回文子串的右边界超过了mx，则需要更新mx和id的值
            if (mx < p[j] + j) {
                mx = p[j] + j;
                id = j;
            }
            // 如果回文子串的长度大于maxLength，则更新maxLength和index的值
            if (maxLength < p[j] - 1) {
                // 参看前文第三部分
                maxLength = p[j] - 1;
                index = j;
            }
        }
        //最长回文子串的起始索引int index = (i - p[i])/2。
        int start = (index - maxLength)>>1;
        return false;
    }
}
