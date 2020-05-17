package com.leetcode.offer.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 从尾到头打印链表
 */
public class Solution6 {

    public int[] reversePrintRecursive(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        ArrayList<Integer> resList = new ArrayList<>();
        reverseCore(head, resList);
        return resList.stream().mapToInt(Integer::valueOf).toArray();
    }

    public void reverseCore(ListNode head, ArrayList<Integer> list) {
        if (head == null) {
            return;
        }
        reverseCore(head.next, list);
        list.add(list.size(), head.val);
    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            int val = stack.pop().val;
            res[i++] = val;
        }
        return res;
    }

    @Test
    public void test() {
        ListNode head = ListNode.generate(new int[] { 1, 2, 3 });
        System.out.println(Arrays.toString(reversePrintRecursive(head)));
    }
}