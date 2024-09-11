package com.ch.doublePoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        // 基本解法
//        int i=0,j=0;
//        while(i < s.length() && j < t.length()){
//           if(s.charAt(i) == t.charAt(j)){
//               i++;
//           }
//           j++;
//        }
//        return i == s.length();

        /**
         * 进阶情况：
         * 当 S1, S2, ..., Sk 的数量非常大（例如有 10 亿个子序列待检查），我们需要优化算法的效率，不能对每个 Si 都单独扫描一次 T，否则性能会非常差。
         * 优化思路：
         * 预处理 t：
         * 由于 t 是固定不变的，可以对 t 进行预处理，利用某种数据结构加速判断每个 s 是否为 t 的子序列。我们可以为 t 构建一个类似于“字符跳跃表”的结构，这样在匹配 s 时可以快速定位 t 中下一个匹配的字符。
         * 二分查找加速跳跃：
         * 预处理 t 中每个字符的位置。对于每个字符 c，记录它在 t 中出现的所有索引位置。对于 s 中的每个字符 c，可以通过二分查找快速找到在 t 中下一个满足条件的字符。
         */

        // 预处理 t 中每个字符出现的所有位置
        Map<Character, List<Integer>> charIndicesMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!charIndicesMap.containsKey(c)) {
                charIndicesMap.put(c, new ArrayList<>());
            }
            charIndicesMap.get(c).add(i);
        }

        int prevIndex = -1; // 指向 t 中上一个字符的位置
        for (char c : s.toCharArray()) {
            if (!charIndicesMap.containsKey(c)) {
                return false; // 如果 t 中不包含 s 中的字符
            }
            List<Integer> indices = charIndicesMap.get(c);
            // 利用二分查找找到大于 prevIndex 的最小索引
            int nextIndex = binarySearch(indices, prevIndex);
            if (nextIndex == -1) {
                return false; // 找不到符合条件的下一个字符
            }
            prevIndex = nextIndex;
        }

        return true;
    }



    // 在有序列表中找到第一个大于 prevIndex 的元素
    private int binarySearch(List<Integer> indices, int prevIndex) {
        int left = 0, right = indices.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (indices.get(mid) > prevIndex) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left < indices.size() ? indices.get(left) : -1;
    }
}
