package com.leetcode.top100.medium;

import java.util.Arrays;

import org.junit.Test;

/**
 * 最大乘积子序列
 * 
 * @author hitomeng
 * @date 2019/10/02
 */
public class MaximumProductSubArr {

    /**
     * 动态规划[。dp[i] = Max(dp[i-1], dp[i-1]*nums[i]) 对于0和负数该如何处理呢？
     * 0乘于任何数都是零,不需要特殊处理。负数，负负得正，记录一个最小值保证积最大。
     */
    public int maxProduct(int[] nums) {
        // dp[i] 表示i位置最大子序列
        int[] dp = Arrays.copyOf(nums, nums.length);
        // 最小子序列
        int[] nDp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            // 自身，前面的，自己和前面的相乘
            int a = dp[i - 1] * nums[i];
            int b = nDp[i - 1] * nums[i];
            int max = Math.max(Math.max(a, b), nums[i]);
            int min = Math.min(Math.min(a, b), nums[i]);
            dp[i] = max;
            nDp[i] = min;
        }
        // 比较各个位置的最大值子序列，当然也可以放在一次循环中做，用一个最大值来记录
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = new int[] { 2, 3, -2, 4 };
        maxProduct(arr);
    }
}