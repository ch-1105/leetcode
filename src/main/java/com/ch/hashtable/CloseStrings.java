package com.ch.hashtable;

import java.util.*;
import java.util.stream.Collectors;

/**
 1657. 确定两个字符串是否接近
 */
public class CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        // 验证长度
        if (word1.length() != word2.length()) {
            return false;
        }
        // 验证字符内容
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c :word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c :word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        // 验证字符频率
        List<Integer> count1 = map1.values().stream().sorted().toList();
        List<Integer> count2 = map2.values().stream().sorted().toList();
        return count1.equals(count2);
    }

    public static void main(String[] args) {
        System.out.println(closeStrings("cabbba", "cabbba"));
    }
}
