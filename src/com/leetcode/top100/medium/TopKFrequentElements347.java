package com.leetcode.top100.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * @author hitomeng
 * @date 2019/11/5
 */
public class TopKFrequentElements347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((i1, i2) -> {
            return map.get(i1) - map.get(i2);
        });

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        LinkedList<Integer> topK  = new LinkedList<>();
        while(!queue.isEmpty()){
            topK.addFirst(queue.poll());
        }
        return topK;
    }
}