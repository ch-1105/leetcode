package com.ch.Node;

/**
 2130. 链表最大孪生和 1 2 3 4 5 6
 */
public class PairSum {
    public static int pairSum(ListNode head) {
        // 链表二分进行反转 , 这里后续可以优化成使用快慢指针，减少一次获取长度
        int i = 0;
        int res = 0;
        ListNode curr = head;
        ListNode next ;
        ListNode pre = null;
        // 得出链表长度
        while (curr != null){
            curr = curr.next;
            i++;
        }
        curr = head;
        // 反转链表，这里反转前半部分和后半部分均可
        for (int j = 0; j < i/2; j++) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        // 反转后pre目前在链表 3 ， curr在 4
        for (int j = 0; j < i/2; j++) {
            res = Math.max(curr.val + pre.val, res);
            curr = curr.next;
            pre = pre.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(pairSum(node));

    }
}
