package com.ch.Node;

/**
 * 2095. 删除链表的中间节点
 */
public class DeleteMiddle {
    // 快慢指针
    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        // 1,3,4,1,2,6
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(deleteMiddle(head));

    }
}
