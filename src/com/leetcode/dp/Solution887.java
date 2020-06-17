package com.leetcode.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution887 {

    // dp[K][m] K个鸡蛋，最多m次机会，能够最多确定楼层数
    // dp[K][m] = dp[K-1][m-1] + dp[K][m-1] + 1
    // dp[k][m - 1] 就是楼上的楼层数
    // dp[k - 1][m - 1] 就是楼下的楼层数 为什么加1，当前楼层
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i - 1][m - 1] + dp[i][m - 1] + 1;
            }
        }
        return m;
    }

    @Test
    public void test() {
        int res = superEggDrop(2, 6);
        assertEquals(3, res);
    }
}