package com.ch.sidleWindow;

/**
 * 643. 子数组最大平均数 I
 */
public class FindMaxAverage {
//    public static double findMaxAverage(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            return 0;
//        }
//        // 设置初始值为负无穷，避免参数都是负数计算返回0
//        double max = Double.NEGATIVE_INFINITY;
//        for (int i = 0; i <= nums.length - k ; i++) {
//            // copy of range 左闭右开
//            max = Math.max(max,avg(Arrays.copyOfRange(nums, i, i + k)) );
//        }
//        return max;
//    }
//
//    /**
//     * 后续优化改动，滑动窗口，不用计算每次的平均数，只需要将上一个减去，并加入下一个即可
//     */
//    public static double avg(int[] nums) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        return (double) sum / nums.length;
//    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        // 设置初始值为负无穷，避免参数都是负数计算返回0
        double max = Double.NEGATIVE_INFINITY;
        // 设置初始值
        double sum = 0;
        for (int i = 0; i < k ; i++) {
            sum += nums[i];
        }
        max = sum/k;
        // 滑动窗口
        for (int i = 1; i <= nums.length-k; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            max = Math.max(sum/k, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{0,1,1,3,3},4));
    }
}
