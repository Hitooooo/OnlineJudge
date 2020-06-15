package com.leetcode.dp;

import org.junit.Test;

public class Solution518 {
    // 多少种凑法
    public int change(int amount, int[] coins) {
        int w = amount;
        int n = coins.length;
        int[][] dp = new int[n + 1][w + 1];
        // dp[0][w] = 0 ;dp[n][0] = 1
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][w];
    }

    @Test
    public void test(){
        int res = change(5, new int[]{1,2,5});
        System.out.println(res);
    }
}