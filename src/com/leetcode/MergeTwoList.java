package com.leetcode;


import com.leetcode.struct.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * @author HitoM
 * @date 2019/3/25 10:33
 */
public class MergeTwoList {
    public static ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newList = new ListNode(-1);
        ListNode node = newList;

        while (l1 != null && l2 != null) {
            ListNode nextNode;
            if (l1.val > l2.val) {
                nextNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                nextNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            node.next = nextNode;
            node = node.next;
        }

        if (l1 == null) {
            node.next = l2;
        } else {
            node.next = l1;
        }
        return newList.next;
    }
}
