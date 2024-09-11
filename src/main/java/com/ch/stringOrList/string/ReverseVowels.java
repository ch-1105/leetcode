package com.ch.stringOrList.string;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    // hello -> holle
    public String reverseVowels(String s) {
        HashSet<Character> characters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 移动左指针直到找到一个元音
            while (left < right && !characters.contains(charArray[left])) {
                left++;
            }
            // 移动右指针直到找到一个元音
            while (right > left && !characters.contains(charArray[right])) {
                right--;
            }
            // 如果两个指针都指向元音，则进行交换
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {

    }
}
