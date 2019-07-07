package com.leetcode;

import com.leetcode.struct.ListNode;

import java.util.LinkedList;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * TODO:你能优化吗？
 * @author HitoM
 * @date 2019/4/12 18:18
 **/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedList<ListNode> listNodes = new LinkedList<>();
        while (head != null) {
            listNodes.push(head);
            head = head.next;
        }
        int length = listNodes.size() / 2;
        for (int i = 0; i < length; i++) {

            if (listNodes.peekFirst().val == listNodes.peekLast().val) {
                listNodes.pollFirst();
                listNodes.pollLast();
            }

            if (listNodes.size() == 1 || listNodes.size() == 0) {
                return true;
            }
        }
        return false;
    }
}
