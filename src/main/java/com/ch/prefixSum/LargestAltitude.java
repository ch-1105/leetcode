package com.ch.prefixSum;

import ch.qos.logback.core.pattern.FormatInfo;

public class LargestAltitude {
//    public int largestAltitude(int[] gain) {
//        int max = Math.max(gain[0], 0);
//        for (int i = 1; i < gain.length; i++) {
//            gain[i] = gain[i-1] + gain[i];
//            max = Math.max(max, gain[i]);
//        }
//        return max;
//    }

    /**
     * 前缀和
     */
    public int largestAltitude(int[] gain) {
        int sum=0,ans=0;
        for (int j : gain) {
            sum += j;
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
