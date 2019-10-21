package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * @author hitomeng
 * @date 2019/10/21
 */
public class PerfactSquares279 {

    /**
     * dp[i] = min(dp[i - j * j] ... ) + 1，其中j是j^2<i的所有值遍历
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int j = 1;
            int currentMin = i;
            while (j * j <= i && j > 0) {
                currentMin = Math.min(currentMin, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = currentMin;
        }
        return dp[n];
    }

    @Test
    public void test() {
        int r = numSquares(13);
        System.out.println(r);
    }
}