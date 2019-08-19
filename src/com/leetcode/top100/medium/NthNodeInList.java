package com.leetcode.top100.medium;

import static org.junit.Assert.assertNull;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head. 移除链表中的第N个元素
 * 
 * @author hitomeng
 * @date 2019/08/19 22:39
 */
public class NthNodeInList {

    /**
     * 链表的话，快慢双指针。 慢指针指向当前i，快指针指向n+i-1。当快指针到达链表尾部的时候，慢指针既是需要remove的结点.
     * 这样是不行的，既然需要移除那么就需要知道移除结点的上一个结点！所以快指针指向的是remove的是n+i。 ps：所有的输入用例都是可用的
     * n<list.length
     * 1.边界条件 2.while判断条件
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slowP = head;
        ListNode fastP = slowP;
        while (n > 0) {
            fastP = fastP.next;
            n--;
        }
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        // 移除
        if (slowP.next != null) {
            slowP.next = slowP.next.next;
        }
        return head;
    }

     /**
      * 引入头结点，统一化操作
      */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHeader = new ListNode(-1);
        newHeader.next = head;
        ListNode slowP = newHeader;
        ListNode fastP = newHeader;
        while (n > 0) {
            fastP = fastP.next;
            n--;
        }
        while (fastP != null && fastP.next != null) {
            fastP = fastP.next;
            slowP = slowP.next;
        }
        // 移除
        if (slowP.next != null) {
            slowP.next = slowP.next.next;
        }
        return newHeader.next;
    }
    @Test
    public void testCase() {
        // ListNode=[1] n=1,空指针
        ListNode head = new ListNode(1);
        // failed ,引入头指针统一处理
        assertNull(removeNthFromEnd(head, 1)); 
    }

    @Test
    public void testCase2() {
        // ListNode=[1] n=1,空指针
        ListNode head = new ListNode(1);
        // failed ,引入头指针统一处理
        assertNull(removeNthFromEnd2(head, 1)); 
    }
}