package com.leetcode.dp;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Test;

public class Solution416 {
    /**
     * dp[i][w]: 对于前i个元素，能否构成和为w的子数组 dp[i][w] = dp[i-1][w] || dp[i-1][w-nums[i]]
     * 
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = IntStream.of(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][w + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; 
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][w];
    }

    @Test
    public void test() {
        boolean res = canPartition(new int[] { 1, 5, 11, 5 });
        System.out.println(res);
        assertEquals(false, canPartition(new int[]{1, 2, 3, 5}));
    }
}