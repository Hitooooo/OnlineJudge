package com.offer.sword.quality;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail22 {
    /**
     * 双指针。两个距离为k的指针，当右面的指针移动到队列尾部的时候，左面指针指向的就是倒数第K个结点. Emm。提问：倒数是从零开始？ 不够K个怎么办？
     * 
     * @param head 链表首部
     * @param k    倒数多少
     * @return target
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (k > 0 && p2 != null) {
            p2 = p2.next;
            k--;
        }
        if(k > 0 && p2 == null){
            System.err.print("k超过链表范围");
            return null;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode nod = FindKthToTail(n1, 7);
        System.out.println(nod);
    }
}