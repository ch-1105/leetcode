package com.ch.stringOrList.string;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder();
        String[] list = s.split(" ");
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].isEmpty()) {
                continue;
            }
            sb.append(list[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = rw.reverseWords("Let's take LeetCode contest");
        System.out.println(s);
    }
}
