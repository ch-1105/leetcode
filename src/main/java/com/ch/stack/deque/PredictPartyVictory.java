package com.ch.stack.deque;

import ch.qos.logback.core.util.StringUtil;

import java.util.ArrayDeque;

/**
 * 649. Dota2 参议院
 */
public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        int length = senate.length();
        ArrayDeque<Integer> radiant = new ArrayDeque<>();
        ArrayDeque<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            if ('R' == senate.charAt(i)) {
                radiant.addLast(i);
            }else {
                dire.addLast(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()){
            int r = radiant.peekFirst();
            int d = dire.peekFirst();
            if (r < d){
                action(radiant, dire, length);
            }else {
                action(dire, radiant, length);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }

    public void action(ArrayDeque<Integer> queue1, ArrayDeque<Integer> queue2,int index){
        queue1.addLast(index+queue1.pop());
        queue2.removeFirst();
    }

    public static void main(String[] args) {
        PredictPartyVictory predictPartyVictory = new PredictPartyVictory();
        String s = predictPartyVictory.predictPartyVictory("RDRDRDRDR");
        System.out.println(s);
    }
}
