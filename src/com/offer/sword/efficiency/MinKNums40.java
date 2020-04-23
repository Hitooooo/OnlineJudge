package com.offer.sword.efficiency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 
 * @author hitomeng
 * @date 2020-04-23 08:15:47
 */
public class MinKNums40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length < k || k <= 0) {
            return res;
        }
        // 构造函数中设置的大小是初始大小，并不是固定大小
        // 可以通过重写add方法或者外层控制add方法达到固定大小的目的
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            // 自定义比较器，实现大小根堆
            @Override
            public int compare(Integer o1, Integer o2) {
                // 倒排
                return o2 - o1;
            }
        });
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            res.add(0,queue.poll());
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = { 2, 3, 5, 1, 7 };
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 0);
        System.out.println(res);
    }
}