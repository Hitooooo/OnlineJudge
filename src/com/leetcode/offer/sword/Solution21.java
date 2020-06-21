package com.leetcode.offer.sword;

import java.util.Arrays;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Solution21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int oddIndex = 0;
        int evenIndex = nums.length - 1;
        int curr = 0;
        while (oddIndex < evenIndex) {
            if ((nums[curr] & 1) == 0) {
                swap(nums, curr, evenIndex--);
                curr = evenIndex;
            } else {
                swap(nums, curr, oddIndex++);
                curr = oddIndex;
            }
        }
        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(exchange(new int[]{1,2,3,4,5,6})));
    }
}