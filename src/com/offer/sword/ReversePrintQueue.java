package com.offer.sword;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 倒序打印链表
 * 
 * @author hitomeng
 * @date 2020/01/28
 */
public class ReversePrintQueue {

    /**
     * 很容易想到递归的解法.另外就是，对于倒序处理栈是最合适的。
     */
    public void print(ListNode node) {
        if (node == null) {
            return;
        }
        print(node.next);
        System.out.println(node.val);
        ;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        print(null);
    }
}