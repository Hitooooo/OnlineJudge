package com.leetcode;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * @author HitoM
 * @date 2019/3/28 23:48
 */
public class MaximumSubarray {

    /**
     * 暴力解法.
     *
     * @param nums
     * @return
     */
    public static int solution(int[] nums) {
        int max = nums[0];
        int thisNum;
        for (int i = 0; i < nums.length; i++) {
            thisNum = 0;
            for (int j = i ; j < nums.length; j++) {
                thisNum += nums[j];
                if (max < thisNum) {
                    max = thisNum;
                }
            }
        }
        return max;
    }
}
