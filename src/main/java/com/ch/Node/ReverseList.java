package com.ch.Node;

import lombok.val;

/**
 * 206. 反转链表  1 2 3 4 5   -> 5 4 3 2 1
 */
public class ReverseList {
    /**
     * 反转链表
     *
     * @param head 原链表的头节点
     * @return 反转后链表的头节点
     */
    public ListNode reverseList(ListNode head) {
        // 如果链表为空或只有一个节点，则直接返回该节点
        if (head == null || head.next == null) return head;
        // 初始化前一个节点为null，当前节点为头节点
        ListNode prev = null;
        ListNode curr = head;
        // 遍历链表，直到当前节点为null
        while (curr != null){
            // 临时保存当前节点的下一个节点
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        // 返回反转后的链表的头节点
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseList().reverseList(head));
    }
}
