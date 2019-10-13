package com.leetcode.top100.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 找到数组中第K大的数.面试高频题 ****
 * 
 * @author hitomeng
 * @date 2019/10/11
 */
public class KthLargestElement215 {

    /**
     * 简单朴素想法，排序后查找
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    /**
     * 维护一个K大小的队列，保留最大的K个数
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (i1, i2) -> i1 - i2);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }

    @Test
    public void test() {
        int[] arr = { 3, 2, 1, 5, 6, 4 };
        int result = findKthLargest2(arr, 2);
        System.out.println(result);
    }
}