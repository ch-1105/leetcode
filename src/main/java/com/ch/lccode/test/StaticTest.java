package com.ch.lccode.test;

import java.util.*;

public class StaticTest {

    public static  class Bk {
        @Override
        public int hashCode() {
            return 0;
        }
    }

    private static int a = 0;

    public int countNum(){
        a++;
        return a;
    }

    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Bk bk = new Bk();
            int code = bk.hashCode();
            if (objects.contains(code)) {
                System.out.println(code+"重复了");
            }else{
                objects.add(code);
            }
        }
    }
}
