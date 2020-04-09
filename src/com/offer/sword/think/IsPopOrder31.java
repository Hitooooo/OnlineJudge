package com.offer.sword.think;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 
 * @author hitomeng
 * @date 2020-04-09 08:29:43
 */
public class IsPopOrder31 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> pushStack = new Stack<>();
        Stack<Integer> popStack = new Stack<>();
        for (int i = popA.length - 1; i >= 0; i--) {
            popStack.push(popA[i]);
        }
        // 需要压栈下标
        int i = 0;
        while (!popStack.isEmpty()) {
            int next = popStack.peek();
            // 找到和弹出序列栈顶元素相同的index
            while (i < pushA.length && pushA[i] != next) {
                pushStack.push(pushA[i++]);
            }
            // 所有元素都已经入栈
            if (i < pushA.length) {
                popStack.pop();
                i++;
            } else {
                while (pushStack.isEmpty() && popStack.isEmpty()) {
                    if (pushStack.pop() != popStack.pop()) {
                        return false;
                    }
                }
            }

        }
        return popStack.isEmpty();
    }

    @org.junit.Test
    public void test() {
        boolean res = IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 });
        boolean res2 = IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 });
        System.out.println(res);
        System.out.println(res2);
    }
}