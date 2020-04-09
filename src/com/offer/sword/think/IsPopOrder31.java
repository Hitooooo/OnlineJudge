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

    /**
     * 压栈过程中，判断栈顶元素是否和需要判断的弹出队列的首个元素相同。相同则做弹栈处理。
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && popA[popIndex] == stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    @org.junit.Test
    public void test() {
        boolean res = IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 });
        boolean res2 = IsPopOrder(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 });
        System.out.println(res);
        System.out.println(res2);
    }
}