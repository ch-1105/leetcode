package com.ch.lccode.test;

public class CopyTest {
    static class MyClass {
        private int value;

        public MyClass(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        MyClass obj = new MyClass(10);

        System.out.println("Before method call: " + obj.getValue());

        // 调用方法
        changeValue(obj);

        System.out.println("After method call: " + obj.getValue());

        // 尝试更改引用
        changeReference(obj); // 这里obj传入的值是20 ， 不会影响外部的引用

        System.out.println("After changing reference: " + obj.getValue());
    }

    // 更改对象的引用
    public static void changeReference(MyClass obj) {
        obj = new MyClass(30); // 更改方法内的引用，不影响外部的引用
    }

    // 修改对象的状态
    public static void changeValue(MyClass obj) {
        obj.setValue(20); // 修改对象的内容
    }


}
