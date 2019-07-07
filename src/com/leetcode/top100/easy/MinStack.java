package com.leetcode;

import java.util.Stack;

/**
 * TODO
 *
 * @author HitoM
 * @date 2019/4/11 8:37
 **/
public class MinStack {

    private Stack<Integer> stackAll;
    private Stack<Integer> stackMins;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackAll = new Stack<Integer>();
        stackMins = new Stack<Integer>();
    }

    public void push(int x) {
        stackAll.push(x);
        if (stackMins.empty() || x <= stackMins.peek()) {
            stackMins.push(x);
        }
    }

    public void pop() {
        if (stackAll.pop().equals(stackMins.peek())) {
            stackMins.pop();
        }
    }

    public int top() {
        return stackAll.peek();
    }

    public int getMin() {
        return stackMins.peek();
    }
}