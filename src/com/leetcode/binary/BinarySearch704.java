package com.leetcode.binary;

import org.junit.Test;

/**
 * 二分查找
 * 
 * @author hitomeng
 * @date 2020/01/14
 */
public class BinarySearch704 {
    /**
     * 尝试二分模板
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return target == nums[left] ? left : -1;
    }

    @Test
    public void test() {
        int[] arr = { -1, 0, 3, 5, 9, 12 };
        int r = search(arr, 13);
        System.out.println(r);
    }
}