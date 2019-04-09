package com.leetcode;

import com.leetcode.struct.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * @author HitoM
 * @date
 */
public class LinkedListCycle {

    /**
     * walker and runner
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode walker = head;
        ListNode runner = head;

        // 利用runner来判断 walker与runner的next
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
