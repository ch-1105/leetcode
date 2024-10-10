package com.ch.tree;

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            print();
        }
    }

    public static void print(){
        // 随机生成8位数字
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append((int)(Math.random() * 10));
        }
        System.out.println(sb);
    }
}
