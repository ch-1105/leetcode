package com.ch.lccode.string;

/**
 * 1768.交替合并字符串
 */
public class MergeAlternately {
    public String mergeAlternately(String a, String b) {
        if (a.isEmpty() || b.isEmpty()) {
            return a+b;
        }

        int len = Math.min(a.length(), b.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        if (a.length() > len) {
            sb.append(a.substring(len));
        }
        if (b.length() > len) {
            sb.append(b.substring(len));
        }

        return sb.toString();
    }
}
