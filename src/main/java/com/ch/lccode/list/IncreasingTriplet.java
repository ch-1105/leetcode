package com.ch.lccode.list;

import java.util.Arrays;

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        // 构建左边
        for (int i = 1; i < n-1; i++) {
            leftMin[i] = Math.min(nums[i],leftMin[i-1]);
        }
        // 构建右边
        int[] rightMin = new int[n];
        rightMin[n-1] = nums[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rightMin[i] = Math.max(nums[i],rightMin[i+1]);
        }
        // 查找
        for (int i = 1; i < n-1; i++) {
            if (nums[i] > leftMin[i-1] && nums[i] < rightMin[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }
}
