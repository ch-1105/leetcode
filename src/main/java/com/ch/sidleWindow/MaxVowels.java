package com.ch.sidleWindow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 1456. 定长子串中元音的最大数目
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        if (s == null || s.isEmpty() || s.length() < k) return 0;
        int max;
        int count = 0;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        max = count;
        for (int i = 1; i <= s.length() - k ; i++) {
            if (set.contains(s.charAt(i-1))) {
                count--;
            }
            if (set.contains(s.charAt(i+k-1))) {
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
