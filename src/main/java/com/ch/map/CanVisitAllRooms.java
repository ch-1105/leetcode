package com.ch.map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> can = new HashSet<>();
        int size = rooms.size();
        for (int i = 0; i < size; i++) {
            can.add(i);
        }
        dfs(rooms,can,0);
        return can.isEmpty();
    }

    public void dfs(List<List<Integer>> rooms,HashSet<Integer> can,int target){
        can.remove(target);
        List<Integer> integers = rooms.get(target);
        HashSet<Integer> keys = new HashSet<>(integers);
        for (int i : keys.stream().toList()) {
            if (can.contains(i)) {
                dfs(rooms,can,i);
            }
        }
    }
}
