package com.ch.prefixSum;

public class PivotIndex {
//    public static int pivotIndex(int[] nums) {
//        // 维护右列表
//        int rightSum = 0;
//        for (int i = nums.length-1; i > 0 ; i--) {
//            rightSum += nums[i];
//        }
//        int leftSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (rightSum == leftSum) {
//                return i;
//            }
//            leftSum += nums[i];
//            if (i+1 < nums.length) {
//                rightSum -= nums[i+1];
//            }else {
//                rightSum = 0;
//            }
//        }
//        return -1;
//    }

    public static int pivotIndex(int[] nums) {
        // 维护右列表
        int rightSum = 0;
        // 右列表倒序遍历
        for (int i = nums.length - 1; i >= 0 ; i--) {
            rightSum += nums[i];
        }
        int leftSum = 0;
        // 优化列表内部if结构，先减右和，在加左和
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
}
