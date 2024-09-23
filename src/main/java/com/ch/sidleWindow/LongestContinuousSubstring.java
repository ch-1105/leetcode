package com.ch.sidleWindow;

import java.net.FileNameMap;

/**
 2414. 最长的字母序连续子字符串的长度
 */
public class LongestContinuousSubstring {
    public static int longestContinuousSubstring(String s) {
        char[] charArray = s.toCharArray();
        int cur = 1;
        int res = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] - charArray[i - 1] == 1) {
                cur++;
            }else{
                cur = 1;
            }
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("abacaba"));
    }
}
