package com.leetcode.top100.easy;

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
     * @param nums nums array
     * @return maximum subarray sum
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


    /**
     * 动态规划！！牛批
     * f(x) = max(f(x-1)+nums[x],f(x-1))
     *
     * @param nums nums array
     * @return maximum subarray sum
     */
    public static int solution2(int[] nums) {
        int[] f = nums;
        for (int i = 0; i < nums.length - 1; i++) {
            f[i + 1] = Math.max(f[i] + nums[i + 1], nums[i + 1]);
        }
        int max = nums[0];
        for (int i = 0; i < f.length; i++) {
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
