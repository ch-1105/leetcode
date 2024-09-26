package com.ch.stack.deque;

import ch.qos.logback.core.pattern.FormatInfo;

import java.util.ArrayDeque;

class RecentCounter {

    private ArrayDeque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    //for (int i = 0; i < queue.size(); i++) {
    //            Integer first = queue.getFirst();
    //            if (t - first > 3000) {
    //                queue.pollFirst();
    //            } else {
    //                break;
    //            }
    //        }

    public int ping(int t) {
        queue.addLast(t);
        while (queue.getFirst() < t - 3000){
            queue.pollFirst();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
