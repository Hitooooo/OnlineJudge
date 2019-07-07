package com.leetcode;

import com.leetcode.struct.ListNode;

/**
 * Reverse a singly linked list.
 *
 * @author HitoM
 * @date 2019/4/12 11:10
 **/
public class ReverseLinkedList {

    /**
     * 直观的方法，使用stack。
     * 那么不使用stack呢
     *
     * @param head linked list head
     * @return reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode current = head;
        // 头结点
        ListNode newHead = new ListNode(-1);

        while (current != null) {
            ListNode temp = new ListNode(current.val);
            temp.next = newHead.next;
            newHead.next = temp;
            current = current.next;
        }

        return newHead.next;
    }

}
