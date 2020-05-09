package com.offer.sword.think;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 * 
 * @author hitomeng
 * @date 2020-05-09 16:55:15
 */
public class MaxInWindows59 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < 1 || size < 1 || size > num.length) {
            return res;
        }
        // 保存上一个窗口最大值，和当前窗口可能的最大值
        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            // 删除不可能是当前窗口最大值的数 
            while (!indexQueue.isEmpty() && (num[indexQueue.peekLast()] < num[i])) {
                indexQueue.pollLast();
            }
            // 一个新元素，都有可能成为后面的最大值，添加到队列尾部
            indexQueue.add(i);
            // 可能的最大值，也许超出窗口范围，需要移除
            if(i - indexQueue.peekFirst() > size - 1){
                indexQueue.pollFirst();
            }
            // 窗口铺满才开始添加
            if (i >= size - 1) {
                res.add(num[indexQueue.peekFirst()]);
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }
}