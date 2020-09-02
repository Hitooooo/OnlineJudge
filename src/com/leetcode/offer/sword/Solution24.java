package com.leetcode.offer.sword;

import com.leetcode.struct.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution24 {
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reversed = reverseList(next);
        ListNode tail = reversed;
        if (tail != null && tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return reversed;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = null;
        ListNode pre = head;
        while(pre != null){
            ListNode newPre = pre.next;
            pre.next = curr;
            curr = pre;
            pre = newPre;
        }
        return curr;
    } 

    public static void main(String[] args) {
        ListNode node = ListNode.generate(new int[] { 1, 2, 3, 4, 5 });
        ListNode head = reverseList2(node);
        System.out.println(head);
    }
}