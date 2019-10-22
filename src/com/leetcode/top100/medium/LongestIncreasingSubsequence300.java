package com.leetcode.top100.medium;

import java.util.Arrays;

import org.junit.Test;

/**
 * 最大上升子序列（不需要连续，可间隔）
 * 
 * @author hitomeng
 * @date 2019/10/22
 */
public class LongestIncreasingSubsequence300 {

    /**
     * 动态规划。每个nums[i]都有可能跟前面的某个序列组成LIS，即使它比nums[i-1]要小。
     * 拿着nums[i]跟前面的每一个LIS尝试组成LIS。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // 过程中记录最大值，不需要再次循环判断了
        int max = dp[0];
        // 是否可虑相同值？
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    @Test
    public void test() {

    }
}