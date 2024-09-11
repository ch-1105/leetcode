package com.ch.stringOrList.list.linkedList;

import java.util.LinkedList;

public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        LinkedList<Object> objects = new LinkedList<>();
        objects.add(1);
        objects.add(2);
        Object o = objects.get(1);
        System.out.println("xxx : "+o);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reverseAPartOfList(listNode1, 2, 4);
//        printNode(listNode1);
    }

    public static void printNode(ListNode node){
        Object o = new Object();

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static ListNode reverseAPartOfList(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        //指针到翻转起始位
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }
        ListNode tempNode ;
        start=pre.next;
        end = start;
        for (int i = 0; i < n-m+1; i++) {
            end = end.next;
        }
        printNode(end.next);
        return null;
    }
}
