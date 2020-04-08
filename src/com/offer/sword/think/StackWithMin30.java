package com.offer.sword.think;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * 
 * @author hitomeng
 * @date 2020-04-08 21:47:24
 */
public class StackWithMin30 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        if(node < min){
            min = node;
        }
        minStack.push(min);
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    /**
     * 原始思路，压栈时记录最小值。可是如果最小值弹栈了，记录的最小值得不到更新，Wrong！
     * 
     * @return
     */
    public int min() {
        return minStack.peek();
    }
}