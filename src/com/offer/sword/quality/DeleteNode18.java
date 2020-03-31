package com.offer.sword.quality;

import com.leetcode.struct.ListNode;

import org.junit.Test;

/**
 * 1.删除链表中的节点，时间复杂度要求为o(1)。已知头指针和需要删除结点指针。 2.删除排序列表中重复的节点
 * 
 * @author hitomeng
 * @date 2020-03-31 15:31:25
 */
public class DeleteNode18 {

    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            // 为空或者近一个结点，直接返回即可
            return pHead;
        }
        // 申请一个头结点，统一操作
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode pre = newHead;
        ListNode current = pre.next;
        ListNode next = current.next;
        while (current != null) {
            if(next != null && current.val == next.val){
                while(next != null && current.val == next.val){
                    next = next.next;
                }
                pre.next = next;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }else{
                pre = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }     
        }
        return newHead.next;
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
        deleteDuplication(n1);
    }

    /**
     * 1.是否有头结点 2.目标节点不在链表中怎么办？
     * 
     * @param head
     * @param target
     * @return
     */
    public boolean delete(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return false;
        }
        // 将后一个结点复制到当前结点，然后将需要删除的结点的下一个结点指向下下个结点
        ListNode next = target.next;
        if (next != null) {
            target.val = next.val;
            target.next = next.next;
        } else {
            // 尾结点，直接置为空即可
            target = null;
        }
        return false;
    }
}