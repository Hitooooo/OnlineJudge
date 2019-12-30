package com.leetcode.top100.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 * Given a list of daily temperatures T, return a list such that, for each day
 * in the input, tells you how many days you would have to wait until a warmer
 * temperature. If there is no future day for which this is possible, put 0
 * instead. For example, given the list of temperatures T = [73, 74, 75, 71, 69,
 * 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * @author hitomeng
 * @date 2019/12/30
 */
public class DailyTemperatures739{
    /**
     * 维护一个从栈顶到栈底单调不减的栈。
     * 每一个即将入栈的数，都与栈内的数进行比较，判断入栈的数是否是栈内的所有温度的下一次升高的温度。
     * 方法：栈顶最小，比一次，如果是栈顶弹栈，计算index。栈中下一个数比较。不是，新数入栈。
     */
    public int[] dailyTemperatures(int[] T) {
        if(T == null){
            return new int[]{};
        }
        int[] res = new int[T.length];
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < T.length; i++) {
           while(!stack.isEmpty() && T[stack.peek()] < T[i]){
               int top = stack.pop();
               res[top] = i - top;
           }
           stack.push(i);
        }
        return res;    
    }

    @Test
    public void test(){
        int[] arr = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures(arr);
        System.out.println(Arrays.toString(res));
    }
}