package com.ch.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 735. 小行星碰撞
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
 * 每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：
 *      两个小行星相互碰撞，较小的小行星会爆炸。
 *      如果两颗小行星大小相同，则两颗小行星都会爆炸。
 *      两颗移动方向相同的小行星，永远不会发生碰撞。
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack  = new ArrayDeque<>();
        for(int aster : asteroids){
            boolean alive = true;
            while (!stack .isEmpty() && alive && aster<0 && stack.peek() > 0){
                alive = stack.peek() < -aster;
                if (stack.peek() <= -aster){
                    stack.pop();
                }
            }
            if (alive){
                stack.push(aster);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
