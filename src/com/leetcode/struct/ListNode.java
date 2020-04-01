package com.leetcode.struct;

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
}
