package com.leetcode.top100.medium;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 将一个链表排序,要求时间复杂度nlgn，空间复杂度为常量。
 * 
 * @author hitomeng
 * @date 2019/09/29
 */
public class SortList {

    /**
     * nlgn，排序算法中有哪些时间复杂度是小于等于这个的？快排，归并。 那就归并吧
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    // 将两个有序链表合并为一个链表
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode(-1);
        ListNode headP = head;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                head.next = node1;
                node1 = node1.next;
            } else {
                head.next = node2;
                node2 = node2.next;
            }
            head = head.next;
        }
        if (node1 == null) {
            head.next = node2;
        } else {
            head.next = node1;
        }
        return headP.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(-1);
        ListNode head4 =new ListNode(4);
        ListNode head2 =new ListNode(2);
        ListNode head1 =new ListNode(1);
        ListNode head3 =new ListNode(3);
        head.next = head4;
        head4.next = head2;
        head2.next = head1;
        head1.next = head3;

        ListNode result = sortList(head.next);
        System.out.println(result);
    }
}