package com.ch.Node;
/**
 * 92. 反转链表 II  1 2 3 4 5   1 4 3 2 5
 */
public class ReverseBetween {
//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head == null || left == right || head.next == null) {
//            return head;
//        }
//        ListNode curr = head;
//        ListNode pre = null;
//        ListNode next;
//        ListNode end = head;
//
//        for (int i = 0; i < right && end.next != null; i++) {
//            end = end.next;
//        }
//        ListNode tempPre = end;
//
//        for (int i = 1; i <= right && curr.next != null ; i++) {
//            if (i == left -1 ) {
//                pre = curr;
//            }
//            if (i>= left) {
//                next = curr.next;
//                curr.next = tempPre;
//                tempPre = curr;
//                curr = next;
//            }else {
//                curr = curr.next;
//            }
//        }
//        if (pre !=null) {
//            pre.next = tempPre;
//        }else { // left = 1 无前缀拼接
//            return tempPre;
//        }
//        return head;
//    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        ListNode next;
        ListNode end = head;
        ListNode tempPre = null;

        // 找到right的下一个节点end，并保存反转区间后面的节点
        for (int i = 1; i <= right; i++) {
            end = end.next;
        }

        // 反转[left, right]区间
        for (int i = 1; i <= right; i++) {
            if (i == left - 1) {
                pre = curr;  // 记录反转前的最后一个节点
            }
            // 在反转区间内，进行反转
            if (i >= left) {
                next = curr.next;
                curr.next = tempPre;
                tempPre = curr;
                curr = next;
            } else { //不在区间内，链表寻找下一个节点
                curr = curr.next;
            }
        }

        // 拼接反转后的链表
        if (pre != null) {
            pre.next = tempPre;  // 将反转前的最后一个节点连接到反转后的第一个节点
        } else {
            head = tempPre;  // 如果left == 1，反转后的第一个节点是新的头节点
        }

        // 将反转后的最后一个节点连接到right后的节点
        curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = end;

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = reverseBetween(node, 2, 4);
    }
}
