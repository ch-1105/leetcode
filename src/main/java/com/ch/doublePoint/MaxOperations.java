package com.ch.doublePoint;

import java.util.Arrays;

/**
 * 1679. K 和数对的最大数目
 */
public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        // 第一种
//        int ans = 0;
//        int target = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            target = k - num;
//            Integer i = map.get(target);
//            if(i != null && map.get(target) > 0) {
//                ans++;
//                map.put(target, map.get(target) - 1);
//            }
//            else{
//                Integer cnt = map.getOrDefault(num, 0);
//                map.put(num, cnt + 1);
//            }
//        }
//        return ans;

        // 第二种
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0,right = n - 1;
        int count = 0;
        while (left < right) {

            if (nums[left] + nums[right] > k) {
                right--;
            } else if (nums[left] + nums[right] < k) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        System.out.println(maxOperations(nums, 6));
    }
}
