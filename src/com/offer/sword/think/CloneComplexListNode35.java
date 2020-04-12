package com.offer.sword.think;

import com.leetcode.struct.RandomListNode;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 
 * @author hitomeng
 * @date 2020-04-12 13:25:58
 */
public class CloneComplexListNode35 {

    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return devide(pHead);
    }

    /**i
     * 将原链表中的每个节点都复制一个，插在原节点位置的后面
     * 
     * @param pHead
     */
    private void cloneNodes(RandomListNode pHead) {
        RandomListNode tempHead = pHead;
        while (tempHead != null) {
            RandomListNode cloneNode = new RandomListNode();
            cloneNode.label = tempHead.label;
            cloneNode.next = tempHead.next;
            cloneNode.random = null;

            tempHead.next = cloneNode;
            tempHead = cloneNode.next;
        }
    }

    private void connectRandomNodes(RandomListNode pHead) {
        RandomListNode head = pHead;
        while (head != null) {
            RandomListNode cloneNode = head.next;
            if (head.random != null) {
                cloneNode.random = head.random.next;
            }
            head = cloneNode.next;

        }
    }

    private RandomListNode devide(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode cloneHead = null;
        RandomListNode cloneNode = null;
        // 初始clone的头结点和遍历节点
        if (pNode != null) {
            cloneHead = cloneNode = pNode.next;
            pNode.next = cloneHead.next;
            pNode = pNode.next;
        }
        // 开始遍历
        while(pNode != null){
            // 先处理clone链表
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            // 再处理原链表
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
}