package com.leetcode.top100.medium;

import java.util.HashSet;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 Note:Do not modify the linked list
 * 
 * @author hitomeng
 * @since 2019/09/24
 */
public class LinkedListCycle {
    /**
     * 快慢双指针，如果存在环的话，快指针一定会追上慢指针。如何确定环的起始位置呢？ 慢指针走一步，快指针走俩步；设链表开始到环开始结点距离为
     * x1，相遇点到环开始距离为x2，相遇点到环开始点为x3 快指针走的路是慢指针的两倍 x1 + x2 + x3 + x2 = 2(x1 +
     * x2)======>x1=x3
     * 
     * 1. 确定有环，快指针不会指向null
     */
    public ListNode detectCycleFloyd(ListNode head) {
        if (head == null) {
            return null;
        }
        // 相遇点
        ListNode meet = getMeetNode(head);
        if (meet == null) {
            return null;
        }
        // 找到环起始点
        while (meet != head) {
            meet = meet.next;
            head = head.next;
        }
        return meet;
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return fast;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }

        return null;
    }

    public int[] fraction(int[] cont) {
        return helper(cont, 0);
    }

    private int[] helper(int[] cont, int index) {
        if (index == cont.length) {
            return null;
        }
        int[] next = helper(cont, index + 1);
        if (next != null) {
            return new int[] { cont[index] * next[0] + next[1], next[0] };
        } else {
            return new int[] { cont[index], 1 };
        }
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        char[] commands = command.toCharArray();
        int commandIndex = 0;
        int startX = 0;
        int startY = 0;
        while(startX <= x && startY <= y ){
            char commandC= commands[commandIndex % (command.length())];
            if(commandC == 'U'){
                startY++;
            }else if(commandC == 'R'){
                startX++;
            }
            commandIndex++;
            for (int[] var : obstacles) {
                if(var[0] == startX && var[1] == startY){
                    return false;
                }
            }
        }
        return false ;
    }

    @Test
    public void test(){
        robot("URR",new int[][]{},3,2);
    }
}