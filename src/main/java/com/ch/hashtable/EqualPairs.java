package com.ch.hashtable;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.zip.Inflater;

/**
 * 2352. 相等行列对
 */
public class EqualPairs {
//    public static int equalPairs(int[][] grid) {
//        return 0;
//    }
//        int repeatNum ;
//        int res = 0;
//        // m * n 矩阵
//        int m = grid.length;
//        int n = grid[0].length;
//        // 将列进列提取到set，再进行判断行
//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < m; i++) {
//            int[] col = new int[n];
//            for (int j = 0; j < n; j++) {
//                col[j] = grid[j][i];
//            }
//            if (set.contains(Arrays.toString(col))) {
//                repeatNum++;
//            }
//            set.add(Arrays.toString(col));
//        }
//        // 行提取
//        for (int i = 0; i < m; i++) {
//            int[] row = new int[n];
//            for (int j = 0; j < n; j++) {
//                row[j] = grid[i][j];
//            }
//            if (set.contains(Arrays.toString(row))) {
//                res++;
//            }
//        }
//        return res;

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        Map<List<Integer>, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(grid[i][j]);
            }
            cnt.put(row, cnt.getOrDefault(row, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                col.add(grid[j][i]);
            }
            if (cnt.containsKey(col)) {
                res += cnt.getOrDefault(col, 0);
            }
        }
        return res;
    }
}
