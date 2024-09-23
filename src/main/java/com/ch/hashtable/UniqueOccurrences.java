package com.ch.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 */
public class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> integers = map.keySet();
        for (int i : integers) {
            if (set.contains(map.get(i))) {
                return false;
            } else {
                set.add(map.get(i));
            }
        }
        return true;
    }
}
