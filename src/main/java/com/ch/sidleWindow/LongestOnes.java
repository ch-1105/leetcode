package com.ch.sidleWindow;

import java.util.Arrays;

/**
 * nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 */
public class LongestOnes {
    public static int longestOnes(int[] nums, int k) {
        if (nums.length == 0 || k < 0 || k > nums.length) {
            return 0;
        }
        int i = 0;
        int count = 0 ;
        int right = 0;
        int max = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                count++;
                right++;
                continue;
            }
            if (nums[right] == 0 && i < k) {
                count++;
                right++;
                i++;
                continue;
            }
            if (nums[right] == 0 && i >= k) {
                max = Math.max(count, max);
                count = 0;
                i = 1;
            }
        }
        max = Math.max(count, max);
        if (k>i) {
            max = max + (k - i);
        }
        return max;
    }

    // 最简
    //public int longestOnes(int[] A, int K) {
    //        int l = 0, r = 0;
    //        while (r < A.length) {
    //            if (A[r++] == 0) K--;
    //            if (K < 0 && A[l++] == 0) K++;
    //        }
    //        return r - l;
    //    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
