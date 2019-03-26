package com.leetcode;


/**
 * @author Mht
 */
public class Main {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        System.out.println(MergeTwoList.solution(l1,l2));
    }
}
