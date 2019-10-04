package com.leetcode.top100.medium;

/**
 * 最大乘积子序列
 * 
 * @author  hitomeng
 * @date    2019/10/02
 */
public class MaximumProductSubArr{

    /**
     * 动态规划[。dp[i] = Max(dp[i-1], dp[i-1]*nums[i])
     * 对于0和负数该如何处理呢？
     * 0乘于任何数都是零,不需要特殊处理。负数，负负得正，记录一个最小值保证值
     */
    public int maxProduct(int[] nums) {
        return 0;
    }
}