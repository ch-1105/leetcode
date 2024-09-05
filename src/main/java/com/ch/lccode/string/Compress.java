package com.ch.lccode.string;

public class Compress {
    public int compress(char[] chars) {
        int length = chars.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            char cur = chars[right];
            int cnt = 0;
            while(right<length && chars[right] == cur){
                right++;
                cnt++;
            }
            chars[left++] = cur;
            if (cnt != 1) {
                //写入cnt
                char[] charArray = (cnt+"").toCharArray();
                for (char c : charArray) {
                    chars[left++] = c;
                }
            }
        }
        return left;
    }

    public static void main(String[] args) {
        char[] chars = "aabcccccaaa".toCharArray(); //8
        System.out.println(new Compress().compress(chars));
    }
}
