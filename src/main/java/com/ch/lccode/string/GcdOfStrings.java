package com.ch.lccode.string;

public class GcdOfStrings {
    public String gcdOfStrings(String s1, String s2) {
        if (s1 == null || s2 == null) return "";
        if(!s1.concat(s2).equals(s2.concat(s1))) return "";

        return s1.substring(0,gcd(s1.length(),s2.length()));
    }

    public int gcd(int a, int b) {
        int i = a % b;
        // 辗转相除法
        while (i!=0){
            a = b;
            b = i;
            i = a%b;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(16%12);
    }
}
