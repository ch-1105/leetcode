package com.ch.stringOrList.string;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Compress {
    public int compress(char[] chars) {
        int length = chars.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            char c = chars[right];
            int count = 0;
            while (right < length && c == chars[right]) {
                count++;
                right++;
            }
            chars[left++] = c;
            if(count > 1){
                char[] charArray = (count+"").toCharArray();
                for (char aChar : charArray) {
                    chars[left++] = aChar;
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
