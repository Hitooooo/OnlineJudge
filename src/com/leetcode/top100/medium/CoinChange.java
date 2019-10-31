package com.leetcode.top100.medium;

import org.junit.Test;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * @author hitomeng
 * @date 2019/10/31
 */
public class CoinChange {

    /**
     * dp[i] = min(1+dp[i-coin]) ;其中i指的是amount，coin是每一个银币面额 dp[0] = 0;
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int curr = -1;
            int min = Integer.MAX_VALUE;
            // min(1+dp[i-coin])
            for (int coin : coins) {
                if (i < coin || dp[i - coin] == -1) {
                    continue;
                } else {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? curr : min;
        }
        return dp[amount];
    }

    /**
     * 超时
     */
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        if (amount == 0) {
            return 0;
        }
        for (int coin : coins) {
            if (coin > amount) {
                continue;
            }
            int count = coinChange(coins, amount - coin);
            if (count == -1) {
                continue;
            }
            result = Math.min(count + 1, result);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    @Test
    public void test() {
        int[] coins = { 1, 2, 5 };
        int result = coinChange(coins, 11);
        System.out.println(result);
    }
}