package com.leetcode.struct;

/**
 * 每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 * 
 * @author hitomeng
 * @date 2020-04-12 11:04:43
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(){}

    public RandomListNode(int label) {
        this.label = label;
    }
}