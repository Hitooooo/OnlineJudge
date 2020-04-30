package com.leetcode.struct;

import com.google.common.base.Preconditions;

/**
 * node is list
 *
 * @author HitoM
 * @date 2019/3/5 20:52
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String valStr = val + "";
        return next == null ? valStr : valStr + "," + next.toString() ;
    }

    public static ListNode generate(int[] arr){
        Preconditions.checkArgument(arr != null && arr.length > 0, "Input array is empty!");
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
           ListNode next = new ListNode(arr[i]);
           node.next = next;
           node = node.next;
        }
        return head;
    }
}
