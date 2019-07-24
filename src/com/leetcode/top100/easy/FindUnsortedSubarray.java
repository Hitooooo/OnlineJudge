package com.leetcode.top100.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending
 * order, then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * @author HitoM
 * @date 2019/6/26 17:29
 **/
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == temp[start]) {
                start++;
            } else {
                break;
            }
        }

        while (end > start) {
            if (nums[end] == temp[end]) {
                end--;
            } else {
                break;
            }
        }
        return end == start ? 0 : end - start + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int[] tem = nums.clone();
        Arrays.sort(tem);

        int start = 0;
        int end = n - 1;
        while (start < end && tem[start] == nums[start]) {
            start++;
        }

        while (end > start && tem[end] == nums[end]) {
            end--;
        }

        return end == start ? 0 : end - start + 1;
    }
}
