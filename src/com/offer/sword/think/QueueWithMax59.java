package com.offer.sword.think;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

/**
 * 实现一个队列，其中有一个函数max返回列表中的最大，且时间复杂度为o(1)
 * 
 * @author hitomeng
 * @date 2020-05-09 17:48:01
 */
public class QueueWithMax59 {
    // 保存可能是最大值的队列，队首为最大值
    private LinkedList<QueueNode> maxIndexQueue = new LinkedList<>();

    private LinkedList<QueueNode> realQueue = new LinkedList<>();

    private int currentIndex = 0;

    public void pushBack(int num) {
        // 每添加一次，删除不可能是最大的值
        while (!maxIndexQueue.isEmpty() && num >= maxIndexQueue.peekLast().val) {
            maxIndexQueue.pollLast();
        }
        maxIndexQueue.add(new QueueNode(currentIndex, num));
        realQueue.addLast(new QueueNode(currentIndex, num));
        currentIndex++;
    }

    public int popFront() {
        if (!realQueue.isEmpty()) {
            // 删除时记得同步
            if (realQueue.peekFirst().index == maxIndexQueue.peekFirst().index) {
                maxIndexQueue.pollFirst();
            }
            return realQueue.pollFirst().val;
        } else {
            throw new RuntimeException();
        }

    }

    public int max() {
        return maxIndexQueue.peekFirst().val;
    }

    @Test
    public void test() {
        QueueWithMax59 queue = new QueueWithMax59();
        queue.pushBack(2);
        assertEquals(2, queue.max());

        queue.pushBack(3);
        assertEquals(3, queue.max());

        queue.pushBack(4);
        assertEquals(4, queue.max());

        queue.pushBack(2);
        assertEquals(4, queue.max());
    }

    class QueueNode {
        int index;
        int val;

        public QueueNode(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}