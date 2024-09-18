package com.ch.hashtable;

import ch.qos.logback.core.pattern.FormatInfo;

import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 2215. 找出两数组的不同
 */
public class FindDifference {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> diff1 = new ArrayList<>(set1);
        diff1.removeAll(set2);
        List<Integer> diff2 = new ArrayList<>(set2);
        diff2.removeAll(set1);
        return Arrays.asList(diff1, diff2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {2, 3};
        List<List<Integer>> result = findDifference(nums1, nums2);
        System.out.println(result);
    }
}
