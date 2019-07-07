package com.leetcode;

import com.leetcode.struct.ListNode;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * @auth HitoM
 * @date 2019/4/11 9:22
 **/
public class IntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();

        if (headA == null || headB == null) {
            return null;
        }

        while (headA != null || headB != null) {
            if (headA != null && !hashSet.add(headA)) {
                return headA;
            }

            if (headB != null && !hashSet.add(headB)) {
                return headB;
            }

            headA = headA == null ? null : headA.next;
            headB = headB == null ? null : headB.next;
        }

        return null;
    }

    /**
     * 两个链表前面不同，后面相同，那通过栈来做呢？
     *
     * @param headA node1
     * @param headB node2
     * @return intersection node
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        LinkedList<ListNode> listNodesA = new LinkedList<>();
        LinkedList<ListNode> listNodesB = new LinkedList<>();

        while (headA != null) {
            listNodesA.push(headA);
            headA = headA.next;
        }

        while (headB != null) {
            listNodesB.push(headB);
            headB = headB.next;
        }

        if (!listNodesA.peek().equals(listNodesB.peek())) {
            return null;
        }

        ListNode result = null;

        while (!listNodesA.isEmpty() && !listNodesB.isEmpty()) {
            if (listNodesA.peek().equals(listNodesB.peek())) {
                result = listNodesA.pop();
                listNodesB.pop();
            } else {
                break;
            }
        }
        return result;
    }
}
