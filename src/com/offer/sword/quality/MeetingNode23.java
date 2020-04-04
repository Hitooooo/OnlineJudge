package com.offer.sword.quality;

import com.leetcode.struct.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 
 * @author hitomeng
 * @date 2020-04-04 22:27:47
 */
public class MeetingNode23 {

    /**
     * 1. 确定是否有环。快慢指针，当两个指针相遇那么存在环。While的结束条件是什么?
     * 2.确定环的入口。相隔环大小的双指针，同时向前移动，相遇时因为两者的长度间隔是环的长度，刚好就是环的入口。
     * 
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetNode = meetNode(pHead);
        if (meetNode == null) {
            return null;
        }
        // 确定环的大小,meetNode走一圈回来经过的步数就是环的大小
        int size = 1;
        ListNode tempNode = meetNode.next;
        while (tempNode != meetNode) {
            tempNode = tempNode.next;
            size++;
        }
        // 寻找环的入口点
        ListNode p1 = pHead;
        ListNode sizeP = pHead;
        while(size > 0){
            sizeP = sizeP.next;
            size --;
        }
        while(p1 != sizeP){
            p1 = p1.next;
            sizeP = sizeP.next;
        }
        return sizeP;
    }

    /**
     * 第一步，返回相遇结点，确定是否有环
     * 
     * @param pHead
     * @return
     */
    private ListNode meetNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode p1 = pHead.next;
        if (p1 == null) {
            return null;
        }
        ListNode p2 = p1.next;
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            if (p2.next == null) {
                return null;
            } else {
                p2 = p2.next.next;
            }
        }
        return null;
    }
}