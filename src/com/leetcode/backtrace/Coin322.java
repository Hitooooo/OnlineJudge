package com.leetcode.backtrace;

import java.util.Arrays;

import org.junit.Test;

public class Coin322 {

    /**
     * dp[i] = min(dp[i-coin]) + 1
     */
    public int coinChangeDp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j] || dp[i - coins[j]] == -1) {
                    continue;
                } else {
                    count = Math.min(count, dp[i - coins[j]] + 1);
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        backtrace(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private int minCount = Integer.MAX_VALUE;

    private void backtrace(int[] coins, int amount, int count, int i) {
        if (i < 0 || amount < 0 || amount / coins[i] + count >= minCount) {
            return;
        }
        if (amount % coins[i] == 0) {
            minCount = Math.min(minCount, count + amount / coins[i]);
            return;
        }
        for (int c = amount / coins[i]; c >= 0; c--) {
            backtrace(coins, amount - c * coins[i], count + c, i - 1);
        }
    }

    @Test
    public void test() {
        int res = coinChangeDp(new int[] { 7,8,9 }, 100);

        System.out.println(res);

    }
}