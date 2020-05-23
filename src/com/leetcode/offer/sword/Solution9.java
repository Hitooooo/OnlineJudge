package com.leetcode.offer.sword;

import java.util.LinkedList;

/**
 * 用两个栈实现队列
 * 
 * @author hitomeng
 * @date 2020-05-23 08:23:12
 */
public class Solution9 {

    private LinkedList<Integer> inStack;
    private LinkedList<Integer> outStack;

    /**
     * 插入时都插入到inStack，出队时因为需要第一个元素，所以将inStack中元素弹出并压入outStack outStack栈顶即为第一个入队的元素。
     */
    public Solution9() {
        this.inStack = new LinkedList<>();
        this.outStack = new LinkedList<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            return -1;
        }

        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
               
        return outStack.isEmpty()? -1 : outStack.pop();
    }

}