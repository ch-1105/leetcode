package com.ch.stack;

import java.util.ArrayDeque;

public class DecodeString {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        ArrayDeque<String> stack_res  = new ArrayDeque<>();
        ArrayDeque<Integer> stack_multi  = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 如果遇到左括号 '['
            if (c == '[') {
                // 将当前的重复次数multi压入栈stack_multi中
                stack_multi.addLast(multi);
                // 将重复次数multi重置为0
                multi = 0;
                // 将当前的res字符串压入栈stack_res中
                stack_res.addLast(res.toString());
                // 创建一个新的StringBuilder对象赋值给res，用于构建新的字符串
                res = new StringBuilder();
            }
            // 如果遇到右括号 ']'
            else if (c == ']') {
                // 创建一个新的StringBuilder对象temp，用于构建重复的字符串
                StringBuilder temp = new StringBuilder();
                // 从栈stack_multi中弹出最近一次的重复次数
                int repeatNum = stack_multi.removeLast();
                // 根据重复次数repeatNum，将res字符串重复添加到temp中
                for (int i = 0; i < repeatNum; i++) {
                    temp.append(res);
                }
                // 从栈stack_res中弹出最近一次的字符串，并和temp拼接后赋值给res
                res = new StringBuilder(stack_res.removeLast() + temp);
            }
            // 如果字符是数字
            else if (c >= '0' && c <= '9') {
                // 更新重复次数multi
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            // 其他字符
            else {
                // 将字符添加到res字符串中
                res.append(c);
            }
        }
        // 返回最终的字符串
        return res.toString();
    }

}
