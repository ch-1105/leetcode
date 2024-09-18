package com.ch.sidleWindow;

/**
 1493. 删掉一个元素以后全为 1 的最长子数组
 */
public class LongestSubarray {
    public static int longestSubarray(int[] nums) {
        int l = 0, r = 0 , k = 1;
        while (r < nums.length) {
            if (nums[r++] == 0) {
                k--;
            }
            if (k < 0 && nums[l++] == 0) {
                k++;
            }
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,1,1,0,1,1,0,1,0,0,0,0};
        System.out.println(longestSubarray(nums));
    }
}
