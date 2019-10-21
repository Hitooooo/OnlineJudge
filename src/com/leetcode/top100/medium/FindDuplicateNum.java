package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * 找到数组中重复的数
 * 
 * @author hitomeng
 * @date 2019/10/21
 */
public class FindDuplicateNum {
    /**
     * 1.排序后查找 2. set判断 3.快慢指针 注意相遇点并不是相同值的点，相同值的点既是环的开始点。
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        // 从相遇点和开始向中间找相同点
        int start = nums[0];
        int end = fast;
        while (end != start) {
            start = nums[start];
            end = nums[end];
        }
        
        return end;
    }

    @Test
    public void test() {
        int r = findDuplicate(new int[] { 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 });
        System.out.println(r);
    }
}