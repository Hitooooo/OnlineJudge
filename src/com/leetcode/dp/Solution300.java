package com.leetcode.dp;

import java.util.Arrays;

import org.junit.Test;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] maxs = Arrays.copyOf(nums, nums.length);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxLen = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > maxs[j] && dp[j] + 1 > maxLen) {
                    maxLen = dp[j] + 1;
                    maxs[i] = nums[i];
                }
            }
            dp[i] = maxLen;
            max = Math.max(maxLen, max);
        }
        return max;
    }

    @Test
    public void test() {
        int res = lengthOfLIS(new int[] { 0});
        System.out.println(res);
    }
}