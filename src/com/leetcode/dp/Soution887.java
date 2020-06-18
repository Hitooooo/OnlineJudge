package com.leetcode.dp;

import org.junit.Test;

public class Soution887 {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i < dp[0].length; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < dp[0].length; j++) {
                int res = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
                    res = Math.min(res, Math.max(dp[i - 1][l - 1], dp[i][j - l]) + 1);
                }
                dp[i][j] = res;
            }
        }
        return dp[K][N];
    }

    @Test
    public void test() {
        int res = superEggDrop(2, 6);
        System.out.println(res);
    }
}